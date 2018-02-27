package com.flower.intellij.strategy;

import com.flower.intellij.domain.SwitchStatus;
import com.flower.intellij.strategy.message.SwitchHandlerMessage;
import com.tuya.smart.TuyaCloudClient;
import com.tuya.smart.model.RequestMessage;
import com.tuya.smart.model.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author wanli zhou
 * @created 2018-02-27 10:51 AM.
 */
@Component
public class SwitchHandler {

	private Timer timer = new Timer();
	@Autowired
	private TuyaCloudClient tuyaCloudClient;

	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Async
	public void openSwitch(List<SwitchHandlerMessage> sgs){
		sgs.stream().forEach(s -> {
			switchStatus(s, SwitchStatus.OPEN);
		});
	}

	@Async
	public void closeSwitch(List<SwitchHandlerMessage> sgs, int mins){
		timer.schedule(new TimerTask() {
			public void run() {
				sgs.stream().forEach(s -> {
					switchStatus(s, SwitchStatus.CLOSE);
				});
				this.cancel();
			}
		}, mins * 60 * 1000);
	}


	public boolean switchStatus(SwitchHandlerMessage sg, SwitchStatus status) {

		String devId = sg.getDeviceId();
		Integer dps = sg.getLocation();
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
		log.info("Switch Status for dev id is : {}, location is : {}, send status : {}, response is : {}", devId, dps, status, response);
		return response.isSuccess();
	}

}
