package com.sgic.internal.defecttracker.defectservice.services;

import java.util.List;

import com.sgic.internal.defecttracker.defectservice.entities.TypeConfig;

public interface TypeConfigService {
	
			// Get TypeConfig By Id
			public TypeConfig getByTypeId(Long typeId);

			// Save TypeConfig
			public TypeConfig saveType(TypeConfig typeConfig);

			// List all TypeConfig
			public List<TypeConfig> getAllType();

			// Delete TypeConfig
			public TypeConfig deleteTypeById(Long typeId);

			// Update TypeConfig
			public TypeConfig updateType(TypeConfig typeConfig);

}
