package com.flower.intellij.switchControl.message;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanli zhou
 * @created 2018-01-29 11:59 PM.
 */
public class ShedOrGroupDetailRsp {
	List<SwitchItem> items = new ArrayList<>();

	public List<SwitchItem> getItems() {
		return items;
	}

	public void setItems(List<SwitchItem> items) {
		this.items = items;
	}
}

