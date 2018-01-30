package com.flower.intellij.switchControl.message;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanli zhou
 * @created 2018-01-29 11:13 PM.
 */
public class SwitchControllerResponse {

	List<SwitchGroupOrShedItem> items = new ArrayList<>();

	public List<SwitchGroupOrShedItem> getItems() {
		return items;
	}

	public void setItems(List<SwitchGroupOrShedItem> items) {
		this.items = items;
	}
}

