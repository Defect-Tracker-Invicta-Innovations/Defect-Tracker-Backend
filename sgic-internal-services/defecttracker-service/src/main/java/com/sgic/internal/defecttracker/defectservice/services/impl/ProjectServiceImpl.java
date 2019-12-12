package com.sgic.internal.defecttracker.defectservice.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defectservice.entities.Project;
import com.sgic.internal.defecttracker.defectservice.entities.ProjectPrivilegeConfig;
import com.sgic.internal.defecttracker.defectservice.repositories.ProjectPrivilegeConfigRepository;
import com.sgic.internal.defecttracker.defectservice.repositories.ProjectRepository;
import com.sgic.internal.defecttracker.defectservice.services.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private ProjectPrivilegeConfigRepository projectPrivilegeConfigRepository;

	@Override
	public Project createProject(Project project) {
		Project responseProject = projectRepository.save(project);

		Project projObj = new Project();
		projObj.setProjectId(project.getProjectId());
		ProjectPrivilegeConfig projectPrivilegeConfig = new ProjectPrivilegeConfig(projObj);
		projectPrivilegeConfigRepository.save(projectPrivilegeConfig);
		return responseProject;
	}

	@Override
	public boolean isProjectAlreadyExists(String projectid) {
		return projectRepository.existsById(projectid);
	}

	@Override
	public List<Project> getallDetails() {
		return projectRepository.findAll();
	}

	@Override
	public Project getByprojectId(String projectid) {
		return projectRepository.getByprojectId(projectid);
	}

	@Override
	public List<Project> getByprojectName(String name) {
		return projectRepository.getByprojectName(name);
	}

	@Override
	public List<Project> getBytype(String type) {
		return projectRepository.getBytype(type);
	}

	@Override
	public List<Project> getByduration(Long duration) {
		return projectRepository.getByduration(duration);
	}

	@Override
	public List<Project> getBystatus(String status) {
		return projectRepository.getBystatus(status);
	}

	@Override
	public Project updateProject(String projectid, Project project) {
		if (projectRepository.findAll() != null) {
			project.setProjectId(projectid);
			projectRepository.save(project);
		}
		return project;
	}

	@Override
	public void deleteById(String projectid) {
		projectRepository.deleteById(projectid);
	}

	@Override
	public List<Project> getBystartDate(String date) {
		return projectRepository.getBystartDate(date);
	}

	@Override
	public Long countProject() {
		return projectRepository.count();
	}

	@Override
	public List<Project> findByProjectOrderByProjectIdDesc(String projectId) {
		return projectRepository.findAll(Sort.by(Sort.Direction.DESC, "projectId"));
	}

}