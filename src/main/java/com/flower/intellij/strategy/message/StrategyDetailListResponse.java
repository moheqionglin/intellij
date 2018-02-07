package com.flower.intellij.strategy.message;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanli zhou
 * @created 2018-02-06 10:16 AM.
 */

public class StrategyDetailListResponse {


	List<StrategyDetailInfo> strategyDetails = new ArrayList<>();

	public List<StrategyDetailInfo> getStrategyDetails() {
		return strategyDetails;
	}

	public void setStrategyDetails(List<StrategyDetailInfo> strategyDetails) {
		this.strategyDetails = strategyDetails;
	}
}
