package com.flower.intellij.domain;

import javax.persistence.*;

/**
 * @author wanli zhou
 * @created 2017-12-31 8:17 PM.
 */
@Entity
@Table(name = "switches")
public class Switch extends BasePersistable{
	private String name;
	@Enumerated(EnumType.STRING)
	private SwitchStatus status;
	@ManyToOne
	@JoinColumn(name = "shed_id")
	private Shed shed;
	private Integer location;
	@Column(name = "device_id")
	private String deviceId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SwitchStatus getStatus() {
		return status;
	}

	public void setStatus(SwitchStatus status) {
		this.status = status;
	}

	public Shed getShed() {
		return shed;
	}

	public void setShed(Shed shed) {
		this.shed = shed;
	}

	public Integer getLocation() {
		return location;
	}

	public void setLocation(Integer location) {
		this.location = location;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
}
