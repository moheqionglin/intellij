package com.flower.intellij.strategy.message;

import com.flower.intellij.domain.Strategy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wanli zhou
 * @created 2018-02-04 12:34 PM.
 */
public class StrategyDetailInfo {
	private Integer id ;
	private String name;
	private boolean enable;

	private List<SwitchGroupMetaData> switchGroups = new ArrayList<>();
	private String desc;
	private Date strategyStartAt;

	private Integer continueMin;

	private Integer repeatGapMin;

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public StrategyDetailInfo() {
	}

	public StrategyDetailInfo(final Strategy s) {
		this.id = s.getId();
		this.name = s.getName();
		this.enable = s.isEnable();
		this.desc = s.getDescription();
		this.switchGroups.addAll(s.getSwitchGroups().stream().map(sg -> new SwitchGroupMetaData(sg.getName(), sg.getId())).collect(Collectors.toList()));
		this.strategyStartAt = s.getStrategyStartAt();
		this.continueMin = s.getContinueMin();
		this.repeatGapMin = s.getRepeatGapMin();
	}

	public StrategyDetailInfo(Integer id, String name, boolean enable, String desc, List<SwitchGroupMetaData> switchGroups) {
		this.id = id;
		this.name = name;
		this.enable = enable;
		this.desc = desc;
		this.switchGroups.addAll(switchGroups);
	}

	public List<SwitchGroupMetaData> getSwitchGroups() {
		return switchGroups;
	}

	public void setSwitchGroups(List<SwitchGroupMetaData> switchGroups) {
		this.switchGroups = switchGroups;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEnable() {
		return enable;
	}

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

	public void setEnable(boolean enable) {
		this.enable = enable;
	}
}
