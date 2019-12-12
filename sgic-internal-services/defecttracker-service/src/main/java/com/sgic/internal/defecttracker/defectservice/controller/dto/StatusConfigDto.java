package com.sgic.internal.defecttracker.defectservice.controller.dto;

import java.util.ArrayList;

public class StatusConfigDto {
	
	private Long statusId;
	private String projectId;
	private ArrayList<String> statusList;
	
	public Long getStatusId() {
		return statusId;
	}
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}
	public ArrayList<String> getStatusList() {
		return statusList;
	}
	public void setStatusList(ArrayList<String> statusList) {
		this.statusList = statusList;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
		
}
