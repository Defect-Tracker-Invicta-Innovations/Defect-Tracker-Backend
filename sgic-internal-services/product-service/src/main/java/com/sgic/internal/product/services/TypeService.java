package com.sgic.internal.product.services;

import java.util.List;

import com.sgic.internal.product.entities.DefectType;

public interface TypeService {
	public Object createDefectType(DefectType defectType); // Create defect type
	public boolean isDefectTypeAlreadyExists(Long id); // Check defect type is already exists
	DefectType findDefectTypeById(long id); // Get defect type by id
	List<DefectType> findAllDefectType(); // List all defect types
	Boolean deleteDefectTypeById(long id); // Delete defect type
	public int getDefectTypeCount(); // Count defect type
}
