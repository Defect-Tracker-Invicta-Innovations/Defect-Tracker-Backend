package com.sgic.internal.defecttracker.defectservice.services;

import java.util.List;
import com.sgic.internal.defecttracker.defectservice.entities.PriorityConfig;

public interface PriorityConfigService {
	
			// Get PriorityConfig By Id
			public PriorityConfig getByPriorityId(Long priorityId);

			// Save PriorityConfig
			public PriorityConfig savePriority(PriorityConfig priorityConfig);

			// List all PriorityConfig
			public List<PriorityConfig> getAllPriority();

			// Delete PriorityConfig
			public PriorityConfig deletePriorityById(Long priorityId);

			// Update PriorityConfig
			public PriorityConfig updatePriority(PriorityConfig priorityConfig);

}
