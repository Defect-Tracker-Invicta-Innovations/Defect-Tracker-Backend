package com.sgic.internal.defecttracker.defectservice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defectservice.entities.DefectConfig;
import com.sgic.internal.defecttracker.defectservice.repositories.DefectConfigRepository;
import com.sgic.internal.defecttracker.defectservice.services.DefectConfigService;

@Service
public class DefectConfigServiceImpl implements DefectConfigService{

	@Autowired
	DefectConfigRepository defectConfigRepository;
	@Override
	public Object createDefectConfig(DefectConfig defectConfig) {
		return defectConfigRepository.save(defectConfig);
	}
	@Override
	public DefectConfig findDefectConfigById(long id) {
		return defectConfigRepository.findById(id).orElse(null);
	}

}
