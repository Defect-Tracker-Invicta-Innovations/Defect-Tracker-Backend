package com.sgic.internal.defecttracker.defectservice.services;

import java.util.List;
import com.sgic.internal.defecttracker.defectservice.entities.ProjectRoleAllocation;

public interface ProjectRoleAllocationService {

	public ProjectRoleAllocation createroleAllocation(ProjectRoleAllocation projectRoleAllocation);

	public List<ProjectRoleAllocation> getAllRoleAllocation();

	public ProjectRoleAllocation getByprojectRoleId(Long projectroleId);

	public ProjectRoleAllocation deleteProjectByprojectId(Long projectroleId);
	
	public List<ProjectRoleAllocation> getroleByProject(Long resourceId);
}
