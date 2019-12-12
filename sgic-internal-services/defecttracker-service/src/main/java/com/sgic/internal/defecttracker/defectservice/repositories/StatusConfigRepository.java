package com.sgic.internal.defecttracker.defectservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.defecttracker.defectservice.entities.StatusConfig;

public interface StatusConfigRepository extends JpaRepository<StatusConfig, Long> {

	StatusConfig getByStatusId(Long statusId);

}
