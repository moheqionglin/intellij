package com.flower.intellij.statusCheck;

import com.flower.intellij.domain.Shed;
import com.flower.intellij.domain.User;
import com.tuya.smart.TuyaCloudClient;
import com.tuya.smart.model.RequestMessage;
import com.tuya.smart.model.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.alibaba.fastjson.JSONObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wanli zhou
 * @created 2018-01-26 9:25 PM.
 */
@Component
public class StatusCheckService {

	Logger log = LoggerFactory.getLogger(this.getClass());
	@PersistenceContext
	private EntityManager em;

	@Autowired
	private TuyaCloudClient tuyaCloudClient;

	/**
	 * 1、首先罗列所有 DevId
	 * 2、逐个DevId 发送请求，记录每个DevId的 isOnlive，设备的状态
	 * 3、打印设备错误日志
	 * 4、计算百分比
	 *
	 * */
	@Transactional
	public StatusCheckResponse statusCheckByUserId(String userid) {
		List<DevIdStatusResponse> devIdStatusResponses = new ArrayList<>();

		StringBuilder errorSb = new StringBuilder();

		errorSb.append("userid: [" + userid + "] 获取设备信息. ");

		//根据userId 获取关联的大棚，然后获取关联的设备
		User user = em.createQuery("SELECT u FROM User u WHERE u.dingDingId = :dingDingId", User.class)
			.setParameter("dingDingId", userid).getSingleResult();

		List<Shed> sheds = user.getSheds();
		List<String> devIds = sheds.stream().map(shed -> shed.getSwitchs().stream().map(s -> s.getDeviceId()).distinct()).flatMap(s -> s).distinct().collect(Collectors.toList());

		devIds.stream().forEach(devId -> {
			RequestMessage request = new RequestMessage();
			request.setApi("tuya.cloud.device.get");
			request.setApiVersion("1.0");
			request.setOs("Linux");
			request.setLang("zh");

			Map<String, String> params = new HashMap<String, String>();
			params.put("devId", devId);
			request.setParams(params);
			DevIdStatusResponse devIdStatusResponse = new DevIdStatusResponse();
			devIdStatusResponse.setDeviceId(devId);
			try {
				ResponseMessage rsp = tuyaCloudClient.sendRequest(request);
				if(!rsp.isSuccess()){
					errorSb.append("devId: ["+ devId + "] error code: [" + rsp.getErrorCode() + "], ERROR msg : [" +rsp.getErrorMsg()  +  "] ");
					return;
				}
				devIdStatusResponse.setResponseError(rsp.isSuccess());
				JSONObject rspJsonObject = (JSONObject) rsp.getResult();


				devIdStatusResponse.setOnline(rspJsonObject.getBoolean("isOnline"));
				JSONObject dpsJsonObj = rspJsonObject.getJSONObject("dps");
				devIdStatusResponse.setBreakdown(dpsJsonObj.getBoolean("7"));
				devIdStatusResponse.setResponseError(false);

				errorSb.append("devId: ["+ devId + "] isOnline: [" + devIdStatusResponse.isOnline() + "], is Breakdown : [" +devIdStatusResponse.isBreakdown()  +  "] ");
			}catch (Exception e){
				devIdStatusResponse.setResponseError(true);
				log.error("Get devid : {} error {}", devId, e);
				return;
			}
			devIdStatusResponses.add(devIdStatusResponse);
		});

		log.info(errorSb.toString());
		//Build Response
		StatusCheckResponse ssRsp = new StatusCheckResponse();
		long workDevIdCount = devIdStatusResponses.size() - devIdStatusResponses.stream().filter(d -> d.isResponseError() || d.isBreakdown() || !d.isOnline()).count();
		Map<String, DevIdStatusResponse> devIdStatusResponseMap = devIdStatusResponses.stream().filter(d -> d.isResponseError() || d.isBreakdown() || !d.isOnline()).collect(Collectors.toMap(is -> is.getDeviceId(), is -> is) );

		ssRsp.setPercent(BigDecimal.valueOf(workDevIdCount).divide(BigDecimal.valueOf(devIdStatusResponses.size()), 2, RoundingMode.HALF_UP).floatValue());

		sheds.stream().forEach(shed -> {
			ShedStatusResponse shedStatusResponse = new ShedStatusResponse();
			shedStatusResponse.setName(shed.getName());
			shedStatusResponse.setId(shed.getId());
			shed.getSwitchs().stream().forEach(sw -> {
				if(!devIdStatusResponseMap.containsKey(sw.getDeviceId())){
					return;
				}
				String devId = sw.getDeviceId();
				SwitchStatusResponse switchStatusResponse = new SwitchStatusResponse();
				switchStatusResponse.setId(sw.getId());
				switchStatusResponse.setDeviceId(sw.getDeviceId());
				switchStatusResponse.setName(sw.getName());
				DevIdStatusResponse ds = devIdStatusResponseMap.get(switchStatusResponse.getDeviceId());
				switchStatusResponse.setBreakdown(ds.isBreakdown());
				switchStatusResponse.setOnline(ds.isOnline());
				switchStatusResponse.setResponseError(ds.isResponseError());
				shedStatusResponse.getSwitchDetails().add(switchStatusResponse);
			});
			ssRsp.getStatusDetails().add(shedStatusResponse);
		});
		return ssRsp;
	}
}
