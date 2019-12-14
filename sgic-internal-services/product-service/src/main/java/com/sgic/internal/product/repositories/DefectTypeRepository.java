package com.sgic.internal.product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.product.entities.DefectType;

public interface DefectTypeRepository extends JpaRepository<DefectType, Long> {
	
	boolean existsByDefectType(String defectType);
}
