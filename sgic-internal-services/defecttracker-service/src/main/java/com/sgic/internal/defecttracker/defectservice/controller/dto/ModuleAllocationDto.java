package com.sgic.internal.defecttracker.defectservice.controller.dto;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sgic.internal.defecttracker.defectservice.entities.SubModule;

public class ModuleAllocationDto {

	private Long moduleallocationId;
	private Long projectroleId;
	private String employeeid;
	private String name;
	private String firstname;
	private String email;
//	private String subModuleId;
//	private String subModuleName;
	private String moduleId;
	private String moduleName;
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private ArrayList<String> subModuleList;
	
	
	public ArrayList<String> getSubModuleList() {
		return subModuleList;
	}
	public void setSubModuleList(ArrayList<String> subModuleList) {
		this.subModuleList = subModuleList;
	}
	public Long getModuleallocationId() {
		return moduleallocationId;
	}
	public void setModuleallocationId(Long moduleallocationId) {
		this.moduleallocationId = moduleallocationId;
	}
	public Long getProjectroleId() {
		return projectroleId;
	}
	public void setProjectroleId(Long projectroleId) {
		this.projectroleId = projectroleId;
	}
	public String getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
//	public String getSubModuleId() {
//		return subModuleId;
//	}
//	public void setSubModuleId(String subModuleId) {
//		this.subModuleId = subModuleId;
//	}
//	public String getSubModuleName() {
//		return subModuleName;
//	}
//	public void setSubModuleName(String subModuleName) {
//		this.subModuleName = subModuleName;
//	}
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
	
}

