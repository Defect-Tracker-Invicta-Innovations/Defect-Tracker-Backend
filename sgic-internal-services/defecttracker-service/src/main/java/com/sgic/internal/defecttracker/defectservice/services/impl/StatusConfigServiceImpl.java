package com.sgic.internal.defecttracker.defectservice.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defectservice.entities.StatusConfig;
import com.sgic.internal.defecttracker.defectservice.repositories.StatusConfigRepository;
import com.sgic.internal.defecttracker.defectservice.services.StatusConfigService;

@Service
public class StatusConfigServiceImpl implements StatusConfigService {
	
	@Autowired
	private StatusConfigRepository statusConfigRepository;

	@Override
	public StatusConfig saveStatus(StatusConfig statusConfig) {
		// TODO Auto-generated method stub
		return statusConfigRepository.save(statusConfig);
		
	}

	@Override
	public List<StatusConfig> getAllStatus() {
		// TODO Auto-generated method stub
		return statusConfigRepository.findAll();
	}

	@Override
	public StatusConfig deleteStatusById(Long statusId) {
		// TODO Auto-generated method stub
		statusConfigRepository.deleteById(statusId);
		return null;
	}

	@Override
	public StatusConfig updateStatus(StatusConfig statusConfig) {
		// TODO Auto-generated method stub
		Long statusId = statusConfig.getStatusId();
		
		boolean isExist = ((StatusConfigRepository) statusConfigRepository).findById(statusId) != null;
		if (isExist) {
			return statusConfigRepository.save(statusConfig);
		} else {
			
		}
		return null;
	}


	@Override
	public StatusConfig getByStatusId(Long statusId) {
		// TODO Auto-generated method stub
		return statusConfigRepository.getByStatusId(statusId);
	}

}
