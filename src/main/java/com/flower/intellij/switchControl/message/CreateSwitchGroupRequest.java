package com.flower.intellij.switchControl.message;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanli zhou
 * @created 2018-01-30 11:12 AM.
 */
public class CreateSwitchGroupRequest {

	private String name;
	private List<SwitchItem> switchs = new ArrayList<>();


	public CreateSwitchGroupRequest() {
	}

	@Override
	public String toString() {
		return "CreateSwitchGroupRequest{" +
			"name='" + name + '\'' +
			", switchs=" + switchs +
			'}';
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SwitchItem> getSwitchs() {
		return switchs;
	}

	public void setSwitchs(List<SwitchItem> switchs) {
		this.switchs = switchs;
	}
}
