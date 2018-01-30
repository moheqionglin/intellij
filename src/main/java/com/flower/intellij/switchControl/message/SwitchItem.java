package com.flower.intellij.switchControl.message;

import com.flower.intellij.domain.Switch;

/**
 * @author wanli zhou
 * @created 2018-01-30 12:33 AM.
 */
public class SwitchItem{

	private Integer id;
	private String name;
	private boolean active;
	private String shedName;

	public SwitchItem(Switch s) {
		this.id = s.getId();
		this.name = s.getName();
	}

	public SwitchItem(Integer id, String name, boolean active, String shedName) {
		this.id = id;
		this.name = name;
		this.active = active;
		this.shedName = shedName;
	}

	public SwitchItem() {
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "SwitchItem{" +
			"id=" + id +
			", name='" + name + '\'' +
			", active=" + active +
			", shedName='" + shedName + '\'' +
			'}';
	}

	public String getShedName() {
		return shedName;
	}

	public void setShedName(String shedName) {
		this.shedName = shedName;
	}
}
