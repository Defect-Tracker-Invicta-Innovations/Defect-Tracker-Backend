package com.sgic.internal.defecttracker.defectservice.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defectservice.entities.ProjectPrivilege;
import com.sgic.internal.defecttracker.defectservice.repositories.ProjectPrivilegeRepository;
import com.sgic.internal.defecttracker.defectservice.services.ProjectPrivilegeService;

@Service
public class ProjectPrivilegeServiceImpl implements ProjectPrivilegeService{

	@Autowired
	private ProjectPrivilegeRepository projectPrivilegeRepository;
	
	@Override
	public ProjectPrivilege createProjectPrivilege(ProjectPrivilege projectPrivilege) {
		return projectPrivilegeRepository.save(projectPrivilege);
	}

	@Override
	public List<ProjectPrivilege> getallProjectPrivilege() {
		return projectPrivilegeRepository.findAll();
	}

	@Override
	public ProjectPrivilege getByPrivilegeName(String privilegeName) {
		return projectPrivilegeRepository.findProjectPrivilegeByPrivilegeName(privilegeName);
	}

	@Override
	public ProjectPrivilege updateProjectPrivilege(ProjectPrivilege projectPrivilege, Long id) {
		boolean isExit = projectPrivilegeRepository.findProjectPrivilegeById(id) != null;
		if(isExit) {
			projectPrivilege.setId(id);
			return projectPrivilegeRepository.save(projectPrivilege);
		}else {
			
		}
		return null;
	}

	@Override
	public void deleteProjectPrivilege(Long id) {
		// TODO Auto-generated method stub
		projectPrivilegeRepository.deleteById(id);
		
	}

}
