package com.flower.intellij.strategy.message;

/**
 * @author wanli zhou
 * @created 2018-02-27 11:23 AM.
 */
public class SwitchHandlerMessage {
	private Integer location;
	private String deviceId;

	public SwitchHandlerMessage(Integer location, String deviceId) {
		this.location = location;
		this.deviceId = deviceId;
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

	@Override
	public String toString() {
		return "SwitchHandlerMessage{" +
			"location=" + location +
			", deviceId='" + deviceId + '\'' +
			'}';
	}
}
