package com.flower.intellij.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

	private boolean enable;

	private String description;

	@ManyToMany()
	@JoinTable(name = "strategy_sg_mapping",
		joinColumns = @JoinColumn(name = "strategy_id"),
		inverseJoinColumns = @JoinColumn(name = "sg_id"))
	private List<SwitchGroups> switchGroups = new ArrayList<>();

	@Column(name = "strategy_start_At")
	@Temporal(TemporalType.TIME)
	private Date strategyStartAt;

	@Column(name = "continue_min")
	private Integer continueMin;

	@Column(name = "repeat_gap")
	private Integer repeatGapMin;

	public Date getStrategyStartAt() {
		return strategyStartAt;
	}

	public void setStrategyStartAt(Date strategyStartAt) {
		this.strategyStartAt = strategyStartAt;
	}

	public Integer getContinueMin() {
		return continueMin;
	}

	public void setContinueMin(Integer continueMin) {
		this.continueMin = continueMin;
	}

	public Integer getRepeatGapMin() {
		return repeatGapMin;
	}

	public void setRepeatGapMin(Integer repeatGapMin) {
		this.repeatGapMin = repeatGapMin;
	}


	public List<SwitchGroups> getSwitchGroups() {
		return switchGroups;
	}

	public void setSwitchGroups(List<SwitchGroups> switchGroups) {
		this.switchGroups = switchGroups;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
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
