//package com.sgic.internal.defecttracker.defectservice.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.eureka.common.api.enums.RestApiResponseStatus;
//import com.eureka.common.api.response.ApiResponse;
//import com.sgic.internal.defecttracker.defectservice.controller.dto.ModuleAssignDto;
//import com.sgic.internal.defecttracker.defectservice.controller.dto.converter.ModuleAssignConverter;
//import com.sgic.internal.defecttracker.defectservice.entities.ModuleAssign;
//import com.sgic.internal.defecttracker.defectservice.repositories.ModuleAssignRepository;
//
//@CrossOrigin
//@RestController
//public class ModuleAssignController {
//	
//	@Autowired
//	ModuleAssignRepository moduleAssignRepository;
//	
//	@PostMapping(value = "/assignmodule")
//	public ResponseEntity<Object> createModule(@RequestBody ModuleAssignDto moduleAssignDto) {
//		ModuleAssign moduleAssign = ModuleAssignConverter.moduleAssignDtoToModuleAssign(moduleAssignDto);
//		System.out.println(moduleAssignDto.getSubModuleId());
//		moduleAssignRepository.save(moduleAssign);
//		return new ResponseEntity<Object>(new ApiResponse(RestApiResponseStatus.OK), HttpStatus.OK);
//
//	}
//	
////	@GetMapping(value = "/GetAllModuleAssignee")
////	public ResponseEntity<Object> getallmoduleassign(@RequestBody ModuleAssign moduleAssign) {
////		ModuleAssignDto moduleAssignDto = ModuleAssignConverter.ModuleAssignToModuleAssignDTO(moduleAssign);
////		moduleAssignRepository.findAll();
////		return new ResponseEntity<Object>(new ApiResponse(RestApiResponseStatus.OK), HttpStatus.OK);
////	}
//}
