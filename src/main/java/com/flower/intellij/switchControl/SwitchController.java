package com.flower.intellij.switchControl;

import com.flower.intellij.domain.SwitchStatus;
import com.flower.intellij.switchControl.message.ShedOrGroupDetailRsp;
import com.flower.intellij.switchControl.message.SwitchControllerResponse;
import com.flower.intellij.switchControl.message.SwitchControllerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanli zhou
 * @created 2018-01-29 11:09 PM.
 */
@RestController
@RequestMapping(path = "/resources/switchController")
public class SwitchController {

	@Autowired
	private SwitchControllerService switchControllerService;

	@GetMapping(path = "/all/{userid}")
	public ResponseEntity getAllSwitchAndGroup(@PathVariable("userid") String userid){
		SwitchControllerResponse rsp = switchControllerService.getAll(userid);
		return ResponseEntity.ok(rsp);
	}

	@GetMapping(path = "/{shed}/{id}")
	public ResponseEntity getShedOrGroupDetail(@PathVariable("shed") SwitchControllerType type, @PathVariable("id") Integer id ){
		ShedOrGroupDetailRsp rsp = switchControllerService.getShedOrGroupDetail(type, id);
		return ResponseEntity.ok(rsp);
	}

	@GetMapping(path = "/switch/{id}/status/{status}")
	public ResponseEntity switchStatus(@PathVariable("id") Integer id, @PathVariable("status")SwitchStatus status){
		boolean success = switchControllerService.switchStatus(id, status);
		return ResponseEntity.ok(success);
	}

	@GetMapping(path = "/switch/{id}/rename/{name}")
	public ResponseEntity renameForSwitch(@PathVariable("id") Integer id, @PathVariable("name") String name){

		return ResponseEntity.ok(switchControllerService.renameForSwitch(id, name));
	}
}
