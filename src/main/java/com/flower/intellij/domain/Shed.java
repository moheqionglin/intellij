package com.flower.intellij.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wanli zhou
 * @created 2017-12-31 7:21 PM.
 */
@Entity
@Table(name = "sheds")
public class Shed extends BasePersistable{
	private String name;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "shed")
	private List<Switch> switchs = new ArrayList<>();

	public List<Switch> getSwitchs() {
		return switchs;
	}

	public void setSwitchs(List<Switch> switchs) {
		this.switchs = switchs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
