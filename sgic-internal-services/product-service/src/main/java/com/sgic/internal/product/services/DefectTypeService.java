package com.sgic.internal.product.services;

import java.util.List;

import com.sgic.internal.product.entities.DefectType;

public interface DefectTypeService {
	
	public DefectType createDefectType(DefectType defectType); // Create defect type

	public boolean isDefectTypeAlreadyExists(String defectType); // Check defect type is already exists

	DefectType findDefectTypeById(long defectTypeId); // Get defect type by id

	List<DefectType> findAllDefectType(); // List all defect types

	Boolean deleteDefectTypeById(long defectTypeId); // Delete defect type
	
	public DefectType updateDefectType(DefectType defectType); // Update Defect Type

	public int getDefectTypeCount(); // Count defect type
}
