package com.sgic.internal.defecttracker.defectservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sgic.internal.defecttracker.defectservice.entities.ProjectStatus;
import com.sgic.internal.defecttracker.defectservice.services.ProjectStatusService;

@CrossOrigin
@RestController
public class ProjectStatusController {
	
	@Autowired
	private ProjectStatusService projectStatusService;
	
	@PostMapping("/saveprostatus")
	public ProjectStatus saveprojectStatus(@RequestBody ProjectStatus projectStatus) {
		return projectStatusService.createProjectStatus(projectStatus);
	}
	
	@GetMapping("/getallprostatus")
	public List<ProjectStatus> getallprojectstatus(){
		return projectStatusService.getAllProjectStatus();
	}
}
