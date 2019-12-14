package com.sgic.internal.defecttracker.defectservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.sgic.internal.defecttracker.defectservice.entities.ModuleAllocation;

public interface ModuleAllocationRepository extends JpaRepository<ModuleAllocation, Long> {

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM ModuleAllocation WHERE projectrole_id =:projectroleId")
	void deleteByProjectId(@Param("projectroleId") Long projectroleId);
	
}
