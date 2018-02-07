package com.flower.intellij.strategy.message;

/**
 * @author wanli zhou
 * @created 2018-02-04 12:34 PM.
 */
public class SwitchGroupMetaData {
	private String name;
	private Integer id;

	public SwitchGroupMetaData() {
	}

	public SwitchGroupMetaData(String name, Integer id) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
