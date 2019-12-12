package com.sgic.internal.defecttracker.defectservice.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.sgic.internal.defecttracker.defectservice.entities.ProjectStatus;

@Service
public interface ProjectStatusService {

	public ProjectStatus createProjectStatus(ProjectStatus projectStatus);
	
	List<ProjectStatus> getAllProjectStatus();
	
}
