package com.flower.intellij.switchControl.message;

import com.flower.intellij.strategy.message.SwitchGroupMetaData;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanli zhou
 * @created 2018-02-04 1:06 PM.
 */
public class SwitchGroupListResponse {
	private List<SwitchGroupMetaData> switchGroups = new ArrayList<>();

	public List<SwitchGroupMetaData> getSwitchGroups() {
		return switchGroups;
	}

	public void setSwitchGroups(List<SwitchGroupMetaData> switchGroups) {
		this.switchGroups = switchGroups;
	}
}
