package com.flower.intellij.domain;

import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
/**
 * @author wanli zhou
 * @created 2018-01-01 1:50 PM.
 */
public class SwitchDomainTest extends BaseTest{

	@PersistenceContext
	private EntityManager em;


	@Transactional
	@Test
	public void saveStrategyTest(){
		Switch sws = new Switch();
		sws.setLocation(1);
		sws.setName("水控");
		em.persist(sws);

		List<SwitchGroups> sgs = em.createQuery("SELECT sg FROM SwitchGroups sg where sg.name in (:names)", SwitchGroups.class)
			.setParameter("names", Arrays.asList(new String[]{"水控"})).getResultList();

		Strategy s = new Strategy();
		s.setName("上午9:00打开大棚1的左侧遮阳板10秒钟");
		s.setEnable(true);
		s.setUser(null);
		s.setContinueMin(1);
		s.setDescription("上午9:00打开大棚1的左侧遮阳板10秒钟");
		s.setStrategyStartAt(new Date());
		s.setRepeatGapMin(1);
		s.setSwitchGroups(sgs);
		em.persist(s);

		Strategy ss = em.createQuery("select c from Strategy c where c.repeatGapMin = :repeatGapMin", Strategy.class)
			.setParameter("repeatGapMin", 1).getSingleResult();
		ss.setName("上午9:00打开大棚1的左侧遮阳板10秒钟");
		ss.setDescription("上午9:00打开大棚1的左侧遮阳板10秒钟");
	}
	@Transactional
	@Test
	public void saveSwitchTest()   {
		final String SHED_NAME = "1号大棚";
		Shed shed = new Shed();
		shed.setName(SHED_NAME);
		em.persist(shed);
		em.flush();

		Shed sd = em.createQuery("SELECT shed FROM Shed shed WHERE shed.name = :name", Shed.class)
			.setParameter("name", SHED_NAME).getSingleResult();
		assertEquals(sd.getName(), SHED_NAME);

		Switch sws = new Switch();
		sws.setLocation(1);
		sws.setName("水控");
		sws.setShed(sd);
		sd.getSwitchs().add(sws);

		em.flush();
		Shed sd1 = em.createQuery("SELECT shed FROM Shed shed WHERE shed.name = :name", Shed.class)
			.setParameter("name", SHED_NAME).getSingleResult();
		System.out.println(sd1.getSwitchs().get(0).getName());
		assertEquals(sd1.getSwitchs().get(0).getName(), "水控");
	}

}
