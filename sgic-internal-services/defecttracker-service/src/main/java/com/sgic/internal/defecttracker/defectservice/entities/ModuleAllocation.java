package com.sgic.internal.defecttracker.defectservice.entities;

import java.util.ArrayList;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "module_allocation")
public class ModuleAllocation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long moduleallocationId;
	
	@ManyToOne
	@JoinColumn(name = "projectroleId",nullable = false)
	private ProjectRoleAllocation projectRoleAllocation;
	
	@ManyToOne
	@JoinColumn(name = "moduleId",nullable = false)
	private Module module;
	

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

	public ProjectRoleAllocation getProjectRoleAllocation() {
		return projectRoleAllocation;
	}

	public void setProjectRoleAllocation(ProjectRoleAllocation projectRoleAllocation) {
		this.projectRoleAllocation = projectRoleAllocation;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	
//	public SubModule getSubModule() {
//		return subModule;
//	}
//
//	public void setSubModule(SubModule subModule) {
//		this.subModule = subModule;
//	}
}
