package com.flower.intellij.app;

import com.alibaba.fastjson.JSON;
import com.dingding.AuthHelper;
import com.dingding.UserHelper;
import com.dingtalk.open.client.api.model.corp.CorpUserDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wanli zhou
 * @created 2018-01-01 7:09 PM.
 */
@Controller
@RequestMapping(path = "/resources", consumes = "application/json", produces = "application/json")
public class UserInfoController {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@GetMapping("userinfo")
	public ResponseEntity getUserInfo(@RequestParam("code") String code, @RequestParam("corpid") String corpid){
		log.info("Get user info, authCode is : {}, corpid is : {}", code, corpid);
		try {

			String accessToken = AuthHelper.getAccessToken();
			System.out.println("access token:" + accessToken);
			CorpUserDetail user = UserHelper.getUser(accessToken, UserHelper.getUserInfo(accessToken, code).getUserid());


			String userJson = JSON.toJSONString(user);
			log.info("Get user info: {}", userJson);

			return ResponseEntity.ok(user);
		} catch (Exception e) {
			log.error("Get user info error : {}", e);
			throw new RuntimeException(e);
		}
	}
}
