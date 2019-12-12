package com.sgic.internal.defecttracker.defectservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.sgic.internal.defecttracker.defectservice.entities.ProjectRoleAllocation;

public interface ProjectRoleAllocationRepository extends JpaRepository<ProjectRoleAllocation, Long> {

	ProjectRoleAllocation findProjectRoleAllocationByprojectroleId(Long projectroleId);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM ProjectRoleAllocation WHERE projectrole_id =:projectroleId")
	void deleteByProjectId(@Param("projectroleId") Long projectroleId);

	@Transactional
	@Modifying
	@Query(value = "from ProjectRoleAllocation where resource_id=:resourceId")
	List<ProjectRoleAllocation> getResourceById(@Param("resourceId") Long resourceId);
}
