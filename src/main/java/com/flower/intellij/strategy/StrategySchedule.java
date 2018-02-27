package com.flower.intellij.strategy;

import com.flower.intellij.domain.Strategy;
import com.flower.intellij.strategy.message.SwitchHandlerMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wanli zhou
 * @created 2018-02-26 9:35 PM.
 */
@Component
public class StrategySchedule {

	@PersistenceContext
	private EntityManager em;

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SwitchHandler switchHandler;

	private Date currentDate = null;

	public StrategySchedule(){
		this.currentDate = new Date();
	}

	@Scheduled(cron = "0 0/1 * * * ?")
	@Transactional
	public void checkStrategy(){
		Date beforeDate = currentDate;
		currentDate = new Date();

		List<Strategy> ss = em.createQuery("SELECT s FROM Strategy s WHERE s.enable = true AND s.strategyStartAt >= :startTime AND s.strategyStartAt < :endTime", Strategy.class)
			.setParameter("startTime", beforeDate)
			.setParameter("endTime", currentDate)
			.getResultList();

		log.info("=> Start check from {} to {} strategy. result size is : {}", beforeDate, currentDate, ss.size());

		if(ss.size() > 0){
			ss.stream().forEach(s -> {
				List<SwitchHandlerMessage> shms = new ArrayList<SwitchHandlerMessage>();
				s.getSwitchGroups().stream().forEach(sg -> {
					shms.addAll(sg.getSwitchs().stream().map(sw -> new SwitchHandlerMessage(sw.getLocation(), sw.getDeviceId())).collect(Collectors.toList()));
				});
				switchHandler.openSwitch(shms);
				log.info("Start to open switches : {}", shms);
				switchHandler.closeSwitch(shms, s.getContinueMin());
				log.info("Send to close switches : {}, delay time is {}.", shms, s.getContinueMin());
			});

		}
	}
}
