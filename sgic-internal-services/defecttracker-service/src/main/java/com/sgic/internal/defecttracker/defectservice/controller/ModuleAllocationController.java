//package com.sgic.internal.defecttracker.defectservice.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//import com.sgic.internal.defecttracker.defectservice.controller.dto.ModuleAllocationDto;
//import com.sgic.internal.defecttracker.defectservice.controller.dto.mapper.ModuleAllocationMapper;
//import com.sgic.internal.defecttracker.defectservice.entities.ModuleAllocation;
//import com.sgic.internal.defecttracker.defectservice.services.ModuleAllocationService;
//
//@CrossOrigin
//@RestController
//public class ModuleAllocationController<ResultObject> {
//
//	@SuppressWarnings("rawtypes")
//	@Autowired
//	private ModuleAllocationMapper moduleAllocationMapper;
//	
//    @SuppressWarnings("unused")
//	@Autowired
//    private ModuleAllocationService moduleAllocationService;
//	
////	<----This APIs Is -- Save Single Object--->
//	@PostMapping(value = "/savemoduleallocation")
//	public ResultObject createModuleAllocation(@RequestBody ModuleAllocation moduleAllocation) {
////		try {
////			
////		} catch (Exception ex) {
////			
////		}
////		moduleAllocationMapper.saveModuleAllocation(moduleAllocationDto)
//		 moduleAllocationService.createModuleAllocation(moduleAllocation);
//		 return null;
//
//	}
//	
//	
//	 @SuppressWarnings("unchecked")
//	@GetMapping("/list")
//	 public ResponseEntity<Iterable<ModuleAllocationDto>> getAllModuleAllocation() {
//			return new ResponseEntity<>(moduleAllocationMapper.getAllModuleAllocation(), HttpStatus.OK);
//		}
//	 
//	// <--Module Deallocation-->	
//		
//		@DeleteMapping(value = "/moduledeallocation/{moduleallocationId}")
//		public ResponseEntity<String> moduleDeallocation(@PathVariable("moduleallocationId") Long moduleallocationId) {
//			try {
////				logger.info("Resource Allocation Controller -> Deleted");
//				System.out.println(moduleallocationId);
//				moduleAllocationMapper.deleteResourceByresourceId(moduleallocationId);
//				return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
//			} catch (Exception ex) {
////				logger.error("Resource Controller :--> error" + ex.getMessage());
//			}
//			return null;
//
//		}
//
//}
