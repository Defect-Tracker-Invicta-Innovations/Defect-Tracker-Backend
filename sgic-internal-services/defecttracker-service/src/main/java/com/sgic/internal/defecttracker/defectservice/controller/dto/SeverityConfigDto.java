package com.sgic.internal.defecttracker.defectservice.controller.dto;

import java.util.ArrayList;

public class SeverityConfigDto {
	
	private Long severityId;
	private String projectId;
	private ArrayList<String> severityList;
	
	public Long getSeverityId() {
		return severityId;
	}
	public void setSeverityId(Long severityId) {
		this.severityId = severityId;
	}
	public ArrayList<String> getSeverityList() {
		return severityList;
	}
	public void setSeverityList(ArrayList<String> severityList) {
		this.severityList = severityList;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
	
}
