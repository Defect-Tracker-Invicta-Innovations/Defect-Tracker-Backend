package com.sgic.internal.defecttracker.defectservice.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sgic.internal.defecttracker.defectservice.entities.ProjectStatus;
import com.sgic.internal.defecttracker.defectservice.repositories.ProjectStatusRepository;
import com.sgic.internal.defecttracker.defectservice.services.ProjectStatusService;

@Repository
public class ProjectStatusServiceImpl implements ProjectStatusService{


	@Autowired
	private ProjectStatusRepository projectStatusRepository;

	@Override
	public ProjectStatus createProjectStatus(ProjectStatus projectStatus) {
		return projectStatusRepository.save(projectStatus);
	}

	@Override
	public List<ProjectStatus> getAllProjectStatus() {
		return projectStatusRepository.findAll();
	}
	
	

}
