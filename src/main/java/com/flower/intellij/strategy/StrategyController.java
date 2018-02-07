package com.flower.intellij.strategy;

import com.flower.intellij.strategy.message.StrategyDetailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author wanli zhou
 * @created 2018-02-04 11:42 AM.
 */
@RestController
@RequestMapping(path = "/resources/strategy/")
public class StrategyController {

	@Autowired
	private StrategyService strategyService;

	@GetMapping(path = "detail/{userid}/{id}")
	public ResponseEntity getStrategyDetail(@PathVariable("userid") String userid, @PathVariable("id") Integer id){
		return ResponseEntity.ok(strategyService.getStrategyDetail(userid, id));
	}

	@GetMapping(path = "list/{userid}")
	public ResponseEntity getStrategyList(@PathVariable("userid") String userid){
		return ResponseEntity.ok(strategyService.getStrategyList(userid));
	}

	@GetMapping(path = "/{id}/status/{status}")
	public ResponseEntity switchStrategyStatus(@PathVariable("id")Integer id,  @PathVariable("status") boolean status){
		return ResponseEntity.ok(strategyService.switchStrategyStatus(id ,status));
	}

	@PostMapping(path = "/save/{userid}")
	public ResponseEntity saveStrategy(@PathVariable("userid") String userid, @RequestBody StrategyDetailRequest req){
		return ResponseEntity.ok(strategyService.saveStrategy(userid, req));
	}
}
