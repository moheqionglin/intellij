package com.flower.intellij.strategy.message;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanli zhou
 * @created 2018-02-04 11:48 AM.
 */
public class StrategyDetailResponse {
	private List<SwitchGroupMetaData> switchGroups = new ArrayList<>();
	private StrategyDetailInfo strategyDetail;


	public List<SwitchGroupMetaData> getSwitchGroups() {
		return switchGroups;
	}

	public void setSwitchGroups(List<SwitchGroupMetaData> switchGroups) {
		this.switchGroups = switchGroups;
	}

	public StrategyDetailInfo getStrategyDetail() {
		return strategyDetail;
	}

	public void setStrategyDetail(StrategyDetailInfo strategyDetail) {
		this.strategyDetail = strategyDetail;
	}
}

