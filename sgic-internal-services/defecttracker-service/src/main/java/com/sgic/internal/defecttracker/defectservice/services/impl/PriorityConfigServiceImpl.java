package com.sgic.internal.defecttracker.defectservice.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defectservice.entities.PriorityConfig;
import com.sgic.internal.defecttracker.defectservice.repositories.PriorityConfigRepository;
import com.sgic.internal.defecttracker.defectservice.services.PriorityConfigService;

@Service
public class PriorityConfigServiceImpl implements PriorityConfigService {
	
	@Autowired
	PriorityConfigRepository priorityConfigRepository;

	

	@Override
	public PriorityConfig savePriority(PriorityConfig priorityConfig) {
		// TODO Auto-generated method stub
		return priorityConfigRepository.save(priorityConfig);
	}

	@Override
	public List<PriorityConfig> getAllPriority() {
		// TODO Auto-generated method stub
		return priorityConfigRepository.findAll();
	}

	@Override
	public PriorityConfig deletePriorityById(Long priorityId) {
		// TODO Auto-generated method stub
		priorityConfigRepository.deleteById(priorityId);
		return null;
	}

	@Override
	public PriorityConfig updatePriority(PriorityConfig priorityConfig) {
		// TODO Auto-generated method stub
		Long priorityId = priorityConfig.getPriorityId();
		
		boolean isExist = ((PriorityConfigRepository) priorityConfigRepository).findById(priorityId) != null;
		if (isExist) {
			return priorityConfigRepository.save(priorityConfig);
		} else {
			
		}
		return null;
	}

	@Override
	public PriorityConfig getByPriorityId(Long priorityId) {
		// TODO Auto-generated method stub
		return priorityConfigRepository.getByPriorityId(priorityId);
	}

}
