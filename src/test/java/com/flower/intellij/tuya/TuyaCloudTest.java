package com.flower.intellij.tuya;

import com.alibaba.fastjson.JSONObject;
import com.tuya.smart.TuyaCloudClient;
import com.tuya.smart.model.RequestMessage;
import com.tuya.smart.model.ResponseMessage;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wanli zhou
 * @created 2018-01-23 11:08 PM.
 */
public class TuyaCloudTest {
	private static final String END_URI = "https://a1.tuyacn.com/api.json";// 调用中国区的API（您可换成其他可用区）

	private static final String ACCESS_ID = ""; // TODO: 请联系涂鸦获取

	private static final String ACCESS_KEY = ""; // TODO: 请联系涂鸦获取

	@Ignore
	@Test
	public void devicDetailByDevIdTest(){
		/*
            创建client，accessId&accessKey由涂鸦提供
            accessId作为clientId
            accessKey用于签名
           */
		TuyaCloudClient client = new TuyaCloudClient(ACCESS_ID, ACCESS_KEY, END_URI);

		// 构造HTTPS请求
		RequestMessage request = new RequestMessage();
		request.setApi("tuya.cloud.device.get"); //通过手机号注册的API
		request.setApiVersion("1.0");
		request.setOs("Linux");
		request.setLang("zh");

		// 封装请求参数(接口需要的具体参数请参考API手册)
		Map<String, String> params = new HashMap<String, String>();
		params.put("devId", "012004452c3ae841d7dc");
           /*
            注:
               除注册及获取统计数据等少量接口,大部份接口都需要sessionId。
               具体是否需要sessionId请参考API手册。
               您可以从注册和登录接口返回结果得到,返回结果字段为sid
           */

		// 将请求参数加入到HTTPS请求中
		request.setParams(params);

           /*
            发起请求，获得响应
            如果请求成功, 则response里的result会是个JSON对象封装的结果.
            如果请求失败, 请查看errorMsg和errorCode,进行相应的处理.
           */
		ResponseMessage response = client.sendRequest(request);
		com.alibaba.fastjson.JSONObject json = (JSONObject) response.getResult();
		com.alibaba.fastjson.JSONObject dpsObj = json.getJSONObject("dps");
		System.out.println(response.getResult());
		System.out.println(json.getString("isActive"));
		System.out.println(json.getJSONObject("dps"));
		System.out.println(dpsObj.getString("1"));
		System.out.println(dpsObj.getBoolean("7"));
	}
	@Ignore
	@Test
	public void devicPublicTest(){
		TuyaCloudClient client = new TuyaCloudClient(ACCESS_ID, ACCESS_KEY, END_URI);

		// 构造HTTPS请求
		RequestMessage request = new RequestMessage();
		request.setApi("tuya.cloud.device.dp.publish"); //通过手机号注册的API
		request.setApiVersion("1.0");
		request.setOs("Linux");
		request.setLang("zh");

		// 封装请求参数(接口需要的具体参数请参考API手册)
		Map<String, String> params = new HashMap<String, String>();
		params.put("devId", "012004452c3ae841da17");
		params.put("dps", "{\"1\":true}");
		request.setParams(params);
		ResponseMessage response = client.sendRequest(request);
		System.out.println(response.getResult());
	}
}
