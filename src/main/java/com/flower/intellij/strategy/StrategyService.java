package com.flower.intellij.strategy;

import com.flower.intellij.domain.Strategy;
import com.flower.intellij.domain.SwitchGroups;
import com.flower.intellij.domain.User;
import com.flower.intellij.strategy.message.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wanli zhou
 * @created 2018-02-04 11:42 AM.
 */
@Component
public class StrategyService {

	@PersistenceContext
	private EntityManager em;


	@Transactional
	public StrategyDetailResponse getStrategyDetail(String userid, @PathVariable("id") Integer id){
		//根据userId 获取关联的大棚，然后获取关联的设备
		User user = em.createQuery("SELECT u FROM User u WHERE u.dingDingId = :dingDingId", User.class)
			.setParameter("dingDingId", userid).getSingleResult();
		StrategyDetailResponse rsp = new StrategyDetailResponse();
		rsp.getSwitchGroups().addAll(user.getSwitchGroups().stream().map(sg -> new SwitchGroupMetaData(sg.getName(), sg.getId())).collect(Collectors.toList()));

		if(id == -1){// new strategy
			return rsp;
		}
		Strategy strategy = em.createQuery("SELECT s FROM Strategy s WHERE s.id = :id", Strategy.class)
			.setParameter("id", id).getSingleResult();

		rsp.setStrategyDetail(new StrategyDetailInfo(strategy));

		return rsp;
	}

	@Transactional
	public StrategyDetailListResponse getStrategyList(String userid) {
		StrategyDetailListResponse rsp = new StrategyDetailListResponse();
		User user = em.createQuery("SELECT u FROM User u WHERE u.dingDingId = :dingDingId", User.class)
			.setParameter("dingDingId", userid).getSingleResult();
		rsp.getStrategyDetails().addAll(user.getStrategies().stream().map(StrategyDetailInfo::new).collect(Collectors.toList()));
		return rsp;
	}

	@Transactional
	public boolean switchStrategyStatus(Integer id, boolean status) {

		em.createQuery("UPDATE Strategy s SET s.enable = :enable where s.id = :id")
			.setParameter("enable", status)
			.setParameter("id", id).executeUpdate();

		return true;

	}

	@Transactional
	public boolean saveStrategy(String userid, StrategyDetailRequest req) {
		User user = em.createQuery("SELECT u FROM User u WHERE u.dingDingId = :dingDingId", User.class)
			.setParameter("dingDingId", userid).getSingleResult();
		if(req.getId() == null){ // new
			List<SwitchGroups> sgs = em.createQuery("SELECT sg FROM SwitchGroups sg where sg.id in (:ids)", SwitchGroups.class)
				.setParameter("ids", req.getSwitchGroups().stream().map(s -> s.getId()).collect(Collectors.toList())).getResultList();
			Strategy s = new Strategy();
			s.setName(req.getName());
			s.setEnable(true);
			s.setUser(user);
			s.setContinueMin(req.getContinueMin());
			s.setDescription(req.getDesc());
			s.setStrategyStartAt(new Date());
			s.getSwitchGroups().addAll(sgs);
			s.setRepeatGapMin(req.getRepeatGapMin());
			em.persist(s);
		}else{
			Strategy strategy = em.createQuery("SELECT s FROM Strategy s where s.id = :id", Strategy.class)
				.setParameter("id", req.getId()).getSingleResult();
			strategy.setName(req.getName());
			strategy.setEnable(true);
			strategy.setUser(user);
			strategy.setContinueMin(req.getContinueMin());
			strategy.setDescription(req.getDesc());
			strategy.setStrategyStartAt(req.getStrategyStartAtDate());
			strategy.setRepeatGapMin(req.getRepeatGapMin());
			em.createNativeQuery("delete from strategy_sg_mapping where strategy_id = :strategy_id")
				.setParameter("strategy_id", strategy.getId()).executeUpdate();
			req.getSwitchGroups().stream().forEach(sgid -> {
				em.createNativeQuery("insert into strategy_sg_mapping values (:sg, :strategy)")
					.setParameter("sg", sgid.getId())
					.setParameter("strategy", strategy.getId()).executeUpdate();
			});
		}

		return true;
	}

}
