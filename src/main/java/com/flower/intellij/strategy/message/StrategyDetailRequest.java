package com.flower.intellij.strategy.message;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author wanli zhou
 * @created 2018-02-04 12:34 PM.
 */
public class StrategyDetailRequest {
	private Integer id ;
	private String name;
	private boolean enable;

	private List<SwitchGroupMetaData> switchGroups = new ArrayList<>();
	private String desc;
	private String strategyStartAt;

	private Integer continueMin;

	private Integer repeatGapMin;

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public StrategyDetailRequest() {
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

	public String getStrategyStartAt() {
		return strategyStartAt;
	}

	public Date getStrategyStartAtDate(){
		SimpleDateFormat sdf =  new SimpleDateFormat("HH:mm:ss" );
		return sdf.parse(this.strategyStartAt, new ParsePosition(0));
	}
	public void setStrategyStartAt(String strategyStartAt) {
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
