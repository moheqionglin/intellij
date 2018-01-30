package com.flower.intellij.domain;

import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author wanli zhou
 * @created 2018-01-01 2:09 PM.
 */
public class UserDomainTest extends BaseTest{
	@PersistenceContext
	private EntityManager em;


	@Transactional
	@Test
	public void saveUserTest()   {
		final String DING_DING_ID = "dingding_id";
		final String SHED_NAME = "shed_name";
		User user = new User();
		user.setDingDingId(DING_DING_ID);

		Shed shed = new Shed();
		shed.setName(SHED_NAME);
		user.getSheds().add(shed);

		SwitchGroups sg = new SwitchGroups();
		sg.setName("SwitchGroups_name");
//		sg.setUser(user);
		user.getSwitchGroups().add(sg);

		Strategy strategy = new Strategy();
		strategy.setName("strategy name");
		user.getStrategies().add(strategy);
//		strategy.setUser(user);
		em.persist(user);
		em.flush();

		User u = em.createQuery("SELECT u FROM User u where u.dingDingId = :dingDingId", User.class)
			.setParameter("dingDingId", DING_DING_ID)
			.getSingleResult();


		assertEquals(u.getId(), Integer.valueOf(1));
		System.out.println("User id is : " + u.getId());

		u.getSwitchGroups().get(0).setUser(u);
		u.getStrategies().get(0).setUser(u);
		em.flush();
		assertEquals(u.getSheds().get(0).getName(), SHED_NAME);
		SwitchGroups sg1 = em.createQuery("SELECT sg FROM SwitchGroups sg WHERE sg.name = :name", SwitchGroups.class)
			.setParameter("name", "SwitchGroups_name").getSingleResult();
		System.out.println(sg1.getUser().getId());
		assertEquals(sg1.getUser().getId(), Integer.valueOf(1));

//
//		ObjectMapper jsonMapper = new ObjectMapper();
//		try {
//			jsonMapper.writeValue(System.out, u);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

	}
}
