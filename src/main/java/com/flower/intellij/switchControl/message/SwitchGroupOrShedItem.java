package com.flower.intellij.switchControl.message;

import com.flower.intellij.domain.Shed;
import com.flower.intellij.domain.SwitchGroups;

/**
 * @author wanli zhou
 * @created 2018-01-30 12:33 AM.
 */
public class SwitchGroupOrShedItem {
	private Integer id;
	private SwitchControllerType type;
	private String name;
	private String image = "/app/images/switchControl/shed.jpg";
	private boolean open;

	public SwitchGroupOrShedItem() {
	}
	public SwitchGroupOrShedItem(Shed shed) {
		this.id = shed.getId();
		this.name = shed.getName();
		this.type = SwitchControllerType.SHED;
	}
	public SwitchGroupOrShedItem(SwitchGroups grp) {
		this.id = grp.getId();
		this.name = grp.getName();
		this.type = SwitchControllerType.SHED;
	}
	public SwitchGroupOrShedItem(Integer id, SwitchControllerType type, String name) {
		this.id = id;
		this.type = type;
		this.name = name;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SwitchControllerType getType() {
		return type;
	}

	public void setType(SwitchControllerType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
