package com.sgic.internal.defecttracker.defectservice.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defectservice.entities.SeverityConfig;
import com.sgic.internal.defecttracker.defectservice.repositories.SeverityConfigRepository;
import com.sgic.internal.defecttracker.defectservice.services.SeverityConfigService;

@Service
public class SeverityConfigServiceImpl implements SeverityConfigService {
	
	@Autowired
	private SeverityConfigRepository severityConfigRepository;

	@Override
	public SeverityConfig saveSeverity(SeverityConfig severityConfig) {
		// TODO Auto-generated method stub
		return severityConfigRepository.save(severityConfig);
	}

	@Override
	public List<SeverityConfig> getAllSeverity() {
		// TODO Auto-generated method stub
		return severityConfigRepository.findAll();
	}

	@Override
	public SeverityConfig deleteSeverityById(Long severityId) {
		// TODO Auto-generated method stub
		severityConfigRepository.deleteById(severityId);;
		return null;
	}

	@Override
	public SeverityConfig updateSeverity(SeverityConfig severityConfig) {
		// TODO Auto-generated method stub
		Long severityId = severityConfig.getSeverityId();
		
		boolean isExist = ((SeverityConfigRepository) severityConfigRepository).findById(severityId) != null;
		if (isExist) {
			return severityConfigRepository.save(severityConfig);
		} else {
			
		}
		return null;
	}

	@Override
	public SeverityConfig getBySeverityId(Long severityId) {
		// TODO Auto-generated method stub
		return severityConfigRepository.getBySeverityId(severityId);
	}

}
