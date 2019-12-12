package com.sgic.internal.defecttracker.defectservice.entities;

import java.util.List;

import javax.persistence.Convert;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.eureka.common.dto.mapper.Mapper;

@Entity
@Table(name = "module_assign")
public class ModuleAssign {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "moduleId", nullable = false)
	private Module module;
	
	private String projectId;
	
	@Convert(converter = Mapper.class)
	private List<String> submoduleId;

	public ModuleAssign() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public List<String> getSubmoduleId() {
		return submoduleId;
	}

	public void setSubmoduleId(List<String> submoduleId) {
		this.submoduleId = submoduleId;
	}

	public ModuleAssign(Long id, Module module, String projectId, List<String> submoduleId) {
		super();
		this.id = id;
		this.module = module;
		this.projectId = projectId;
		this.submoduleId = submoduleId;
	}
	@Embedded
	@ManyToOne
	@JoinColumn(name = "projectrole_id", nullable = false)
	private ProjectRoleAllocation projectRoleAllocation;

	public ProjectRoleAllocation getProjectRoleAllocation() {
		return projectRoleAllocation;
	}

	public void setProjectRoleAllocation(ProjectRoleAllocation projectRoleAllocation) {
		this.projectRoleAllocation = projectRoleAllocation;
	}

}
