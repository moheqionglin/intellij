package com.flower.intellij.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wanli zhou
 * @created 2017-12-31 8:24 PM.
 */
@Entity
@Table(name = "switch_groups")
public class SwitchGroups extends BasePersistable{
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	private String name;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "group_switch_mapping",
		joinColumns = @JoinColumn(name = "switch_id"),
		inverseJoinColumns = @JoinColumn(name = "switch_group_id"))
	private List<Switch> switchs = new ArrayList<>();

	public List<Switch> getSwitchs() {
		return switchs;
	}

	public void setSwitchs(List<Switch> switchs) {
		this.switchs = switchs;
	}

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
