package com.sgic.internal.defecttracker.defectservice.controller.dto;

import java.util.List;

public class ModuleAssignDto {
	private Long id;
	private String projectId;
	private List<String> submoduleId;
	private String submoduleName;
	private String moduleId;
	private String moduleName;
	private Long projectroleId;
	
	public Long getProjectroleId() {
		return projectroleId;
	}
	public void setProjectroleId(Long projectroleId) {
		this.projectroleId = projectroleId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getSubmoduleName() {
		return submoduleName;
	}
	public void setSubmoduleName(String submoduleName) {
		this.submoduleName = submoduleName;
	}
	public String getModuleId() {
		return moduleId;
	}
	public List<String> getSubModuleId() {
		return submoduleId;
	}
	
	public List<String> getSubmoduleId() {
		return submoduleId;
	}
	public void setSubmoduleId(List<String> submoduleId) {
		this.submoduleId = submoduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
}
