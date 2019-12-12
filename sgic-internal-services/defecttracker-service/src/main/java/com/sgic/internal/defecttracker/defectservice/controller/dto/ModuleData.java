package com.sgic.internal.defecttracker.defectservice.controller.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sgic.internal.defecttracker.defectservice.entities.SubModule;

@Component
public class ModuleData {
	private String moduleId;
	private String moduleName;
	private String projectid;
	private String projectName;
//	private String subModuleId;
//	private String subModuleName;
	private List<SubModule> subModule;
	
	public ModuleData(String moduleId, String moduleName, String projectid, String projectName ) {
		super();
		this.moduleId = moduleId;
		this.moduleName = moduleName;
		this.projectid = projectid;
		this.projectName =  projectName;
	}

	public ModuleData() {
	}

	// getters setters for module DTO
	public String getModuleId() {
		return moduleId;
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

	// getter setter for submodule id
//	public String getSubModuleId() {
//		return subModuleId;
//	}
//
//	public void setSubModuleId(String subModuleId) {
//		this.subModuleId = subModuleId;
//	}
//
//	public String getSubModuleName() {
//		return subModuleName;
//	}
//
//	public void setSubModuleName(String subModuleName) {
//		this.subModuleName = subModuleName;
//	}

//	// getters setters for project id
	public String getProjectid() {
		return projectid;
	}

	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<SubModule> getSubModule() {
		return subModule;
	}

	public void setSubModule(List<SubModule> subModule) {
		this.subModule = subModule;
	}
	
}
