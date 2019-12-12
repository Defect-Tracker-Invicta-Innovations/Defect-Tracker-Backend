//package com.sgic.internal.defecttracker.defectservice.controller;
//
//import org.apache.log4j.BasicConfigurator;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.eureka.common.api.enums.RestApiResponseStatus;
//import com.eureka.common.api.response.ApiResponse;
//import com.sgic.internal.defecttracker.defectservice.controller.dto.DefectConfigDto;
//
//import com.sgic.internal.defecttracker.defectservice.controller.dto.mapper.DefectConfigMapper;
//
//
//@RestController
//public class DefectConfigController {
//	
//	@Autowired DefectConfigMapper defectConfigMapper;
//	
//	//create defect configurations
//	@PostMapping(value = "/defectconfig")
//	public ResponseEntity<Object> createDefectConfig(@RequestBody DefectConfigDto defectConfigDto) {
//		BasicConfigurator.configure();
//		if (defectConfigMapper.createDefectConfig(defectConfigDto)) {
//			return new ResponseEntity<>(new ApiResponse(RestApiResponseStatus.OK), HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>("Defect Config Added Failure", HttpStatus.BAD_REQUEST);
//		}
//	}
//	
//	//get all defect configurations
//	@GetMapping(value = "/defectconfig/{id}")
//	public DefectConfigDto getDefectConfigById(@PathVariable Long id) {
//		BasicConfigurator.configure();
//		return defectConfigMapper.getDefectConfigById(id);
//	}
//
//}
