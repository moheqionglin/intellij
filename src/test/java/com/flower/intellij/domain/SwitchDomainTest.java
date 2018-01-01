package com.flower.intellij.domain;

import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import static org.junit.Assert.*;
/**
 * @author wanli zhou
 * @created 2018-01-01 1:50 PM.
 */
public class SwitchDomainTest extends BaseTest{

	@PersistenceContext
	private EntityManager em;

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
		sws.setLocation("shed 1");
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
