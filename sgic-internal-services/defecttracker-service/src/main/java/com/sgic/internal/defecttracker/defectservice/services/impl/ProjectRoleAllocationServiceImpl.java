package com.sgic.internal.defecttracker.defectservice.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defectservice.entities.ProjectRoleAllocation;
import com.sgic.internal.defecttracker.defectservice.repositories.ModuleAllocationRepository;
import com.sgic.internal.defecttracker.defectservice.repositories.ModuleRepository;
import com.sgic.internal.defecttracker.defectservice.repositories.ProjectRoleAllocationRepository;
import com.sgic.internal.defecttracker.defectservice.services.ProjectRoleAllocationService;

@Service
public class ProjectRoleAllocationServiceImpl implements ProjectRoleAllocationService {

	@Autowired
	private ProjectRoleAllocationRepository projectRoleAllocationRepository;

	@Autowired
	private ModuleAllocationRepository moduleAllocationRepository;

	@Override
	public ProjectRoleAllocation createroleAllocation(ProjectRoleAllocation projectRoleAllocation) {
		return projectRoleAllocationRepository.save(projectRoleAllocation);
	}

	@Override
	public List<ProjectRoleAllocation> getAllRoleAllocation() {
		return projectRoleAllocationRepository.findAll();
	}

	@Override
	public ProjectRoleAllocation getByprojectRoleId(Long projectroleId) {
		return projectRoleAllocationRepository.findProjectRoleAllocationByprojectroleId(projectroleId);
	}

	@Override
	public ProjectRoleAllocation deleteProjectByprojectId(Long projectroleId) {
		moduleAllocationRepository.deleteByProjectId(projectroleId);
		System.out.println("projectID" + projectroleId);
		projectRoleAllocationRepository.deleteByProjectId(projectroleId);
		return null;

	}

	@Override
	public List<ProjectRoleAllocation> getroleByProject(Long projectroleId) {
		return projectRoleAllocationRepository.getResourceById(projectroleId);
	}

}
