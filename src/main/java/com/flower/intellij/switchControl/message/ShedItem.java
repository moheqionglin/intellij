package com.flower.intellij.switchControl.message;

import com.flower.intellij.domain.Shed;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wanli zhou
 * @created 2018-01-30 10:42 AM.
 */
public class ShedItem {
	private Integer id;
	private String name;
	private List<SwitchItem> switchs = new ArrayList<>();

	public ShedItem(Shed shed) {
		this.id = shed.getId();
		this.name = shed.getName();
		switchs.addAll(shed.getSwitchs().stream().map(SwitchItem::new).collect(Collectors.toList()));
	}
	public ShedItem() {
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

	public List<SwitchItem> getSwitchs() {
		return switchs;
	}

	public void setSwitchs(List<SwitchItem> switchs) {
		this.switchs = switchs;
	}
}
