package com.sgic.internal.defecttracker.defectservice.services;

import java.util.List;

import com.sgic.internal.defecttracker.defectservice.entities.ModuleAllocation;

public interface ModuleAllocationService {

	public ModuleAllocation createModuleAllocation(ModuleAllocation moduleAllocation);
	
	List<ModuleAllocation> getAllModuleAllocation();
	
	public Iterable<ModuleAllocation> list();
	
//  <--- Module Deallocation Delete  Method--->
	public ModuleAllocation deleteResourceById(Long resourceId);
}
