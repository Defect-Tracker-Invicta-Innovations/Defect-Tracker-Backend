package com.sgic.internal.defecttracker.defectservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.internal.defecttracker.defectservice.entities.ProjectType;
import com.sgic.internal.defecttracker.defectservice.services.ProjectTypeService;

@CrossOrigin
@RestController
public class ProjectTypeController {

	@Autowired
	private ProjectTypeService projectTypeService;
	
	@PostMapping("/saveprojecttype")
	public ProjectType saveprojecttype(@RequestBody ProjectType projectType) {
		return projectTypeService.createprojectType(projectType);	
	}
	
	@GetMapping("/getallprojecttype")
	public List<ProjectType> getallprojecttype(){
		return projectTypeService.getallprojectType();	
	}
}
