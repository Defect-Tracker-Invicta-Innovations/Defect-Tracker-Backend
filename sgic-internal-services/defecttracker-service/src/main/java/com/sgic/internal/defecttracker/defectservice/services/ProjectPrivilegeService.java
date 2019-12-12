package com.sgic.internal.defecttracker.defectservice.services;

import java.util.List;
import com.sgic.internal.defecttracker.defectservice.entities.ProjectPrivilege;

public interface ProjectPrivilegeService {

	public ProjectPrivilege createProjectPrivilege(ProjectPrivilege projectPrivilege);

	List<ProjectPrivilege> getallProjectPrivilege();

	public ProjectPrivilege getByPrivilegeName(String privilegeName);

	public ProjectPrivilege updateProjectPrivilege(ProjectPrivilege projectPrivilege, Long id);
	
	public void deleteProjectPrivilege(Long id);
}
