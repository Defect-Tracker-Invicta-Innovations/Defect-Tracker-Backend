package com.sgic.internal.defecttracker.defectservice.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sgic.internal.defecttracker.defectservice.entities.ProjectType;
import com.sgic.internal.defecttracker.defectservice.repositories.ProjectTypeRepository;
import com.sgic.internal.defecttracker.defectservice.services.ProjectTypeService;

@Repository
public class ProjectTypeServiceImpl implements ProjectTypeService{

	@Autowired
	private ProjectTypeRepository projectTypeRepository;
	
	@Override
	public ProjectType createprojectType(ProjectType projectType) {
		return projectTypeRepository.save(projectType);
	}

	@Override
	public List<ProjectType> getallprojectType() {
		return projectTypeRepository.findAll();
	}

}
