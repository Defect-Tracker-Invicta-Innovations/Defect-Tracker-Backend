package com.sgic.internal.defecttracker.defectservice.services;

import java.util.List;

import com.sgic.internal.defecttracker.defectservice.entities.ResourceAllocationList;

public interface ResourceAllocationListService {
	
	public ResourceAllocationList findResourceAllocationByresourceId(Long resourceId);
	public List<ResourceAllocationList> getAllresourceList();
}
