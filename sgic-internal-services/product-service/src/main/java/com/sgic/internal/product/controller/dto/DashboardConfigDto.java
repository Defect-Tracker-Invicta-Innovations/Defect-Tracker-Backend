package com.sgic.internal.product.controller.dto;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DashboardConfigDto {

	private Long configId;
	private String roleName;
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private ArrayList<String> dashboardList;
	private String userName;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getConfigId() {
		return configId;
	}
	public void setConfigId(Long configId) {
		this.configId = configId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public ArrayList<String> getDashboardList() {
		return dashboardList;
	}
	public void setDashboardList(ArrayList<String> dashboardList) {
		this.dashboardList = dashboardList;
	}
	
	
	
}
