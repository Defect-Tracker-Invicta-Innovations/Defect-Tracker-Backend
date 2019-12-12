package com.sgic.internal.defecttracker.defectservice.services;

import java.util.List;

import com.sgic.internal.defecttracker.defectservice.entities.SeverityConfig;

public interface SeverityConfigService {
	
		// Get SeverityConfig By Id
		public SeverityConfig getBySeverityId(Long severityId);

		// Save SeverityConfig
		public SeverityConfig saveSeverity(SeverityConfig severityConfig);

		// List all SeverityConfig
		public List<SeverityConfig> getAllSeverity();

		// Delete SeverityConfig
		public SeverityConfig deleteSeverityById(Long severityId);

		// Update SeverityConfig
		public SeverityConfig updateSeverity(SeverityConfig severityConfig);

}
