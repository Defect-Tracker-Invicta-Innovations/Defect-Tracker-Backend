package com.sgic.internal.defecttracker.defectservice.controller.dto;

import java.util.ArrayList;

public class TypeConfigDto {
	
	private Long typeId;
	private String projectId;
	private ArrayList<String> typeList;
	
	public Long getTypeId() {
		return typeId;
	}
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	public ArrayList<String> getTypeList() {
		return typeList;
	}
	public void setTypeList(ArrayList<String> typeList) {
		this.typeList = typeList;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
	
}
