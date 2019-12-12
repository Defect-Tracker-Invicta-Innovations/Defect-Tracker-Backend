package com.sgic.internal.defecttracker.defectservice.services;

import java.util.List;
import com.sgic.internal.defecttracker.defectservice.entities.ProjectType;

public interface ProjectTypeService {

	public ProjectType createprojectType(ProjectType projectType);
	
	public List<ProjectType> getallprojectType();
	
}
