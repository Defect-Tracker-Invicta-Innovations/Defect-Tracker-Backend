package com.sgic.internal.defecttracker.defectservice.services;

import java.util.List;

import com.sgic.internal.defecttracker.defectservice.entities.StatusConfig;

public interface StatusConfigService {
	
			// Get StatusConfig By Id
			public StatusConfig getByStatusId(Long statusId);

			// Save StatusConfig
			public StatusConfig saveStatus(StatusConfig statusConfig);

			// List all StatusConfig
			public List<StatusConfig> getAllStatus();

			// Delete StatusConfig
			public StatusConfig deleteStatusById(Long statusId);

			// Update StatusConfig
			public StatusConfig updateStatus(StatusConfig statusConfig);

}
