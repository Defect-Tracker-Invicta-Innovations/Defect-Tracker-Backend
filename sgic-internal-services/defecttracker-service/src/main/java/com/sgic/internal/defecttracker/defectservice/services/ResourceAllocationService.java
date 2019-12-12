package com.sgic.internal.defecttracker.defectservice.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sgic.internal.defecttracker.defectservice.entities.ResourceAllocation;

public interface ResourceAllocationService {

//	<--Save Resource Allocation Method--->
	public ResponseEntity<String> saveresource(ResourceAllocation resourceAllocation);

//	<---Resource Allocation List Method--->
	public List<ResourceAllocation> gettAllResource();

//	<---Get Resource Allocation By Resource Allocation Id--->
	public ResourceAllocation findResourceAllocationByresourceId(Long resourceId);

//	<---List Resource Allocation By Resource Allocation By Id--->
	public List<ResourceAllocation> getresourceById();

//    <---save Resource Allocation Bulk Date--->
	void saveResourceTable(List<ResourceAllocation> resourceAllocation);
	
//  <--- Resource Allocation Delete  Method--->
	public ResponseEntity<String> deleteResourceById(Long resourceId);
	
	public List<ResourceAllocation> getByEmployee(Long empId);
	
	public List<ResourceAllocation> getByprojectId(String projectId);
	

}
