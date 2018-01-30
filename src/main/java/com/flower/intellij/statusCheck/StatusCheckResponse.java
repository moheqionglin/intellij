package com.flower.intellij.statusCheck;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanli zhou
 * @created 2018-01-26 9:28 PM.
 */
public class StatusCheckResponse {
	private float percent;
	private List<ShedStatusResponse> statusDetails = new ArrayList<>();

	public float getPercent() {
		return percent;
	}

	public void setPercent(float percent) {
		this.percent = percent;
	}

	public List<ShedStatusResponse> getStatusDetails() {
		return statusDetails;
	}

	public void setStatusDetails(List<ShedStatusResponse> statusDetails) {
		this.statusDetails = statusDetails;
	}
}

class ShedStatusResponse {
	private String name ;
	private Integer id;
	List<SwitchStatusResponse> switchDetails = new ArrayList<>();

	public String getName() {
		return name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SwitchStatusResponse> getSwitchDetails() {
		return switchDetails;
	}

	public void setSwitchDetails(List<SwitchStatusResponse> switchDetails) {
		this.switchDetails = switchDetails;
	}
}
class DevIdStatusResponse{
	private Integer id ;
	private String name;
	private String deviceId;
	private boolean isOnline = false;
	private boolean isBreakdown = true;
	private boolean isResponseError = true;


	public boolean isResponseError() {
		return isResponseError;
	}

	public void setResponseError(boolean responseError) {
		isResponseError = responseError;
	}

	public boolean isOnline() {
		return isOnline;
	}

	public void setOnline(boolean online) {
		isOnline = online;
	}

	public boolean isBreakdown() {
		return isBreakdown;
	}

	public void setBreakdown(boolean breakdown) {
		isBreakdown = breakdown;
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

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
}
class SwitchStatusResponse{
	private Integer id ;
	private String name;
	private String deviceId;
	private boolean isOnline = false;
	private boolean isBreakdown = false;
	private boolean isResponseError = false;


	public boolean isResponseError() {
		return isResponseError;
	}

	public void setResponseError(boolean responseError) {
		isResponseError = responseError;
	}

	public boolean isOnline() {
		return isOnline;
	}

	public void setOnline(boolean online) {
		isOnline = online;
	}

	public boolean isBreakdown() {
		return isBreakdown;
	}

	public void setBreakdown(boolean breakdown) {
		isBreakdown = breakdown;
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

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
}
