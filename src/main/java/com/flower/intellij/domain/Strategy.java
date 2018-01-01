package com.flower.intellij.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author wanli zhou
 * @created 2017-12-31 8:32 PM.
 */
@Entity
@Table(name = "strategy")
public class Strategy extends BasePersistable{

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	private String name;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
