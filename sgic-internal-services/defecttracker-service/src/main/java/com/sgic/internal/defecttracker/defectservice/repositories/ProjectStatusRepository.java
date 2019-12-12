package com.sgic.internal.defecttracker.defectservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sgic.internal.defecttracker.defectservice.entities.ProjectStatus;

public interface ProjectStatusRepository extends JpaRepository<ProjectStatus, Long>{

}
