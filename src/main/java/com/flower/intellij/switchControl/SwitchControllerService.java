package com.flower.intellij.switchControl;

import com.alibaba.fastjson.JSONObject;
import com.flower.intellij.domain.*;
import com.flower.intellij.strategy.message.SwitchGroupMetaData;
import com.flower.intellij.switchControl.message.*;
import com.tuya.smart.TuyaCloudClient;
import com.tuya.smart.model.RequestMessage;
import com.tuya.smart.model.ResponseMessage;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wanli zhou
 * @created 2018-01-29 11:12 PM.
 */
@Component
public class SwitchControllerService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@PersistenceContext
	private EntityManager em;
	@Autowired
	private TuyaCloudClient tuyaCloudClient;

	@Transactional
	public SwitchControllerResponse getAll(String userid){
		User u = em.createQuery("SELECT u FROM com.flower.intellij.domain.User u where u.dingDingId = :userid", User.class)
			.setParameter("userid", userid).getSingleResult();

		SwitchControllerResponse rsp = new SwitchControllerResponse();
		rsp.getItems().addAll(u.getSwitchGroups().stream().map(SwitchGroupOrShedItem::new).collect(Collectors.toList()));
		rsp.getItems().addAll(u.getSheds().stream().map(SwitchGroupOrShedItem::new).collect(Collectors.toList()));
		return rsp;
	}

	public ShedOrGroupDetailRsp getShedOrGroupDetail(SwitchControllerType type, Integer id) {

		List<Switch> ss = null;
		StringBuilder shedName = new StringBuilder();
		switch (type){
			case SHED:
				Shed shed = em.createQuery("SELECT shed FROM Shed shed where shed.id = :id", Shed.class)
					.setParameter("id", id).getSingleResult();
				ss = shed.getSwitchs();
				shedName.replace(0, shedName.length(), shed.getName());
				break;
			case GROUP:
				SwitchGroups grp = em.createQuery("SELECT ss FROM SwitchGroups ss where ss.id = :id", SwitchGroups.class)
					.setParameter("id", id).getSingleResult();
				ss = grp.getSwitchs();
				shedName.replace(0, shedName.length(), grp.getName());
				break;

		}

		if(ss == null || ss.isEmpty()){
			throw new RuntimeException("Empty value for " + type + ", id is " + id);
		}
		Map<String, JSONObject> devRsp = new HashMap<>();
		ss.stream().map(s -> s.getDeviceId()).distinct().forEach(devId -> {
			RequestMessage request = new RequestMessage();
			request.setApi("tuya.cloud.device.get");
			request.setApiVersion("1.0");
			request.setOs("Linux");
			request.setLang("zh");

			Map<String, String> params = new HashMap<String, String>();
			params.put("devId", devId);
			request.setParams(params);
			try {
				ResponseMessage rsp = tuyaCloudClient.sendRequest(request);
				if(!rsp.isSuccess()){
					log.error("Get response From tuya error by id : {}", devId);
					return;
				}
				JSONObject rspJsonObject = (JSONObject) rsp.getResult();
				JSONObject dpsJsonObj = rspJsonObject.getJSONObject("dps");
				devRsp.put(devId, dpsJsonObj);
			}catch (Exception e){
				log.error("Get devid : {} error {}", devId, e);
				return;
			}
		});

		ShedOrGroupDetailRsp rsp = new ShedOrGroupDetailRsp();
		ss.stream().forEach(s -> {
			String devId = s.getDeviceId();
			if(!devRsp.containsKey(devId)){
				log.error("Could return switch : {}, because tuya hashMap not have this devid: {}", s.getId(), devId);
				return;
			}

			SwitchItem item = new SwitchItem();
			item.setId(s.getId());
			item.setName(s.getName());
			item.setShedName(shedName.toString());
			JSONObject dpsJsonObj = devRsp.get(devId);
			item.setActive(dpsJsonObj.getBoolean(s.getLocation().toString()));
			rsp.getItems().add(item);
		});
		return rsp;
	}

	public boolean switchStatus(Integer id, SwitchStatus status) {
		Switch s = em.createQuery("SELECT s FROM Switch s WHERE s.id = :id", Switch.class)
			.setParameter("id", id).getSingleResult();

		String devId = s.getDeviceId();
		Integer dps = s.getLocation();
		boolean sStatus = status.equals(SwitchStatus.OPEN);
		// 构造HTTPS请求
		RequestMessage request = new RequestMessage();
		request.setApi("tuya.cloud.device.dp.publish"); //通过手机号注册的API
		request.setApiVersion("1.0");
		request.setOs("Linux");
		request.setLang("zh");

		// 封装请求参数(接口需要的具体参数请参考API手册)
		Map<String, String> params = new HashMap<String, String>();
		params.put("devId", devId);
		params.put("dps", "{\"" + dps + "\":" + sStatus + "}");
		request.setParams(params);
		ResponseMessage response = tuyaCloudClient.sendRequest(request);
		log.info("Switch Status for switch id : {}, dev id is : {}, location is : {}, send status : {}, response is : {}", id, devId, dps, status, response);
		return response.isSuccess();
	}

	@Transactional
	public boolean renameForSwitch(Integer id, String name) {
		Switch s = em.createQuery("SELECT s FROM Switch s WHERE s.id = :id", Switch.class)
			.setParameter("id", id).getSingleResult();
		s.setName(name);
		return true;
	}

	public Object getAllSwitchs(String userid) {
		User u = em.createQuery("SELECT u FROM com.flower.intellij.domain.User u where u.dingDingId = :userid", User.class)
			.setParameter("userid", userid).getSingleResult();
		AllSwitchsRsp rsp = new AllSwitchsRsp();


		rsp.getItems().addAll(u.getSheds().stream().map(ShedItem::new).collect(Collectors.toList()));
		return rsp;



	}

	@Transactional
	public boolean createSwitchGroup(String userid, CreateSwitchGroupRequest req) {
		User u = em.createQuery("SELECT u FROM com.flower.intellij.domain.User u where u.dingDingId = :userid", User.class)
			.setParameter("userid", userid).getSingleResult();

		List<Switch> ss = em.createQuery("SELECT s FROM Switch s WHERE s.id IN (:ids)")
			.setParameter("ids", req.getSwitchs().stream().map(swi -> swi.getId()).collect(Collectors.toList())).getResultList();
		SwitchGroups sgp = new SwitchGroups();
		sgp.setUser(u);
		sgp.setName(StringUtils.substring(req.getName(), 0, 99));
		sgp.setSwitchs(ss);
		em.persist(sgp);
		return true;
	}

	@Transactional
	public SwitchGroupListResponse getSwitchGroups(String userid) {
		User u = em.createQuery("SELECT u FROM com.flower.intellij.domain.User u where u.dingDingId = :userid", User.class)
			.setParameter("userid", userid).getSingleResult();
		SwitchGroupListResponse rsp = new SwitchGroupListResponse();
		rsp.getSwitchGroups().addAll(u.getSwitchGroups().stream().map(sg -> new SwitchGroupMetaData( sg.getName(), sg.getId())).collect(Collectors.toList()));
		return rsp;
	}
}
