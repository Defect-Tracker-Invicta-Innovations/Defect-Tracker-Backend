package com.sgic.internal.defecttracker.defectservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.defecttracker.defectservice.entities.SeverityConfig;

public interface SeverityConfigRepository extends JpaRepository<SeverityConfig, Long> {

	SeverityConfig getBySeverityId(Long severityId);

}
