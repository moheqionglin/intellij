package com.flower.intellij.switchControl.message;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanli zhou
 * @created 2018-01-30 10:46 AM.
 */
public class AllSwitchsRsp {
	List<ShedItem> items = new ArrayList<>();

	public List<ShedItem> getItems() {
		return items;
	}

	public void setItems(List<ShedItem> items) {
		this.items = items;
	}
}
