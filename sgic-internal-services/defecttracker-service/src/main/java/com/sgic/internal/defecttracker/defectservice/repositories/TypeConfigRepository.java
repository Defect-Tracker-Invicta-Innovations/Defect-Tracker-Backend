package com.sgic.internal.defecttracker.defectservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.defecttracker.defectservice.entities.TypeConfig;

public interface TypeConfigRepository extends JpaRepository<TypeConfig, Long> {

	TypeConfig getByTypeId(Long typeId);

}
