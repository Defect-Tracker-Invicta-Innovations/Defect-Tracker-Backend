package com.sgic.internal.defecttracker.defectservice.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.internal.defecttracker.defectservice.entities.ModuleAllocation;
import com.sgic.internal.defecttracker.defectservice.repositories.ModuleAllocationRepository;
import com.sgic.internal.defecttracker.defectservice.services.ModuleAllocationService;

@Service
public class ModuleAllocationServiceImpl implements ModuleAllocationService{

	@Autowired
	private ModuleAllocationRepository moduleAllocationRepository;
	
	@Override
	public ModuleAllocation createModuleAllocation(ModuleAllocation moduleAllocation) {
		return moduleAllocationRepository.save(moduleAllocation);
	}

	@Override
	public List<ModuleAllocation> getAllModuleAllocation() {
		return moduleAllocationRepository.findAll();
	}

	@Override
	public Iterable<ModuleAllocation> list() {
		return moduleAllocationRepository.findAll();
	}
	
	@Override
	public ModuleAllocation deleteResourceById(Long resourceId) {
		 moduleAllocationRepository.deleteById(resourceId);;
		return null;
	}

}
