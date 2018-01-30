package com.flower.intellij.statusCheck;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanli zhou
 * @created 2018-01-26 9:23 PM.
 */
@RestController
@RequestMapping(path = "/resources/status")
public class StatusCheckController {
	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private StatusCheckService statusCheckService;


	/**
	 * 状态信息有两个： 离线和故障
	 * */
	@GetMapping(path = "/userid/{userid}")
	public ResponseEntity statusCheckByUserId(@PathVariable("userid") String userid){
		if(StringUtils.isEmpty(userid)){
			log.error("status Check By User Id error, Cased by userid is empty");
			return ResponseEntity.badRequest().body("");
		}

		StatusCheckResponse rsp = statusCheckService.statusCheckByUserId(userid);
		return ResponseEntity.ok(rsp);
	}
}
