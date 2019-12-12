package com.sgic.internal.product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.product.entities.DefectPriority;

public interface DefectPriorityRepository extends JpaRepository<DefectPriority, Long> {
	
}
