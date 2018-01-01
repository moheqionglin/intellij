package com.flower.intellij.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wanli zhou
 * @created 2017-12-17 10:19 PM.
 */
@Entity
@Table(name = "users")
public class User extends BasePersistable{
	@Column(name = "dingding_id")
	private String dingDingId;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "sheds_user_mapping",
		joinColumns = @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "shed_id"))
	private List<Shed> sheds = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user")
	private List<SwitchGroups> switchGroups= new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user")
	private List<Strategy> strategies = new ArrayList<>();

	public List<Strategy> getStrategies() {
		return strategies;
	}

	public void setStrategies(List<Strategy> strategies) {
		this.strategies = strategies;
	}

	public List<SwitchGroups> getSwitchGroups() {
		return switchGroups;
	}

	public void setSwitchGroups(List<SwitchGroups> switchGroups) {
		this.switchGroups = switchGroups;
	}

	public String getDingDingId() {
		return dingDingId;
	}

	public void setDingDingId(String dingDingId) {
		this.dingDingId = dingDingId;
	}

	public List<Shed> getSheds() {
		return sheds;
	}

	public void setSheds(List<Shed> sheds) {
		this.sheds = sheds;
	}
}
