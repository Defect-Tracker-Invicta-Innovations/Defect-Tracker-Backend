package com.sgic.internal.defecttracker.defectservice.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defectservice.entities.TypeConfig;
import com.sgic.internal.defecttracker.defectservice.repositories.TypeConfigRepository;
import com.sgic.internal.defecttracker.defectservice.services.TypeConfigService;

@Service
public class TypeConfigServiceImpl implements TypeConfigService {
	
	@Autowired
	private TypeConfigRepository typeConfigRepository;

	@Override
	public TypeConfig saveType(TypeConfig typeConfig) {
		// TODO Auto-generated method stub
		return typeConfigRepository.save(typeConfig);
	}

	@Override
	public List<TypeConfig> getAllType() {
		// TODO Auto-generated method stub
		return typeConfigRepository.findAll();
	}

	@Override
	public TypeConfig deleteTypeById(Long typeId) {
		// TODO Auto-generated method stub
		typeConfigRepository.deleteById(typeId);;
		return null;
	}

	@Override
	public TypeConfig updateType(TypeConfig typeConfig) {
		// TODO Auto-generated method stub
		Long typeId = typeConfig.getTypeId();
		
		boolean isExist = ((TypeConfigRepository) typeConfigRepository).findById(typeId) != null;
		if (isExist) {
			return typeConfigRepository.save(typeConfig);
		} else {
			
		}
		return null;
	}

	@Override
	public TypeConfig getByTypeId(Long typeId) {
		// TODO Auto-generated method stub
		return typeConfigRepository.getByTypeId(typeId);
	}

}
