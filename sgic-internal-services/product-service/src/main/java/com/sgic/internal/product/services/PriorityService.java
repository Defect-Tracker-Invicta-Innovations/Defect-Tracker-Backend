package com.sgic.internal.product.services;

import java.util.List;

import com.sgic.internal.product.entities.DefectPriority;

public interface PriorityService {
	public Object createDefectPriority(DefectPriority defectPriority); // Create Defect Priority
	public boolean isDefectPriorityAlreadyExists(Long id); // Defect Priority already exists
	List<DefectPriority> findAllDefectPriority(); // Get All Defect Priority
	DefectPriority findDefecPriorityById(long id); // Get Defect Priority By Id
	Boolean deleteDefectPriorityById(long id); // Delete Defect Priority 
}
