package com.sgic.internal.defecttracker.defectservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.defecttracker.defectservice.entities.ModuleAssign;

public interface ModuleAssignRepository extends JpaRepository<ModuleAssign, Long> {

}
