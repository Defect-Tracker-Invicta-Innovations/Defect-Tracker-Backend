//package com.sgic.internal.product.controller;
//
//import java.util.List;
//
//import javax.validation.Valid;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.eureka.common.api.enums.RestApiResponseStatus;
//import com.eureka.common.api.response.ApiResponse;
//import com.sgic.internal.product.services.impl.DefectTypeServiceImpl;
//
//@CrossOrigin(origins = "*",allowedHeaders = "*")
//@RestController
//public class DefectTypeController {
//	private static Logger logger = LogManager.getLogger(DefectTypeServiceImpl.class);
//
//	@Autowired
//	private TypeMapper defectTypeMapper;
//
//@PostMapping(value = "/defect-types")
//public ResponseEntity<Object> createDefectType(@RequestBody DefectTypeDto defectTypeDto) {
////	if (defectTypeService.isDefectTypeAlreadyExists(defectTypeDto.getName())) {
////		logger.debug("Defect Type already exists: createDefectType(), name: {}");
////		return new ResponseEntity<>(new BasicResponse<>(
////				RestApiResponseStatus.VALIDATION_FAILURE, "Defect Type already exists!!!"),HttpStatus.BAD_REQUEST);
////	}
//	DefectType defectType = mapper.map(defectTypeDto, DefectType.class);
//	defectTypeService.createDefectType(defectType);
//	return new ResponseEntity<>(
//			new BasicResponse<>(RestApiResponseStatus.CREATED ,"Defect Type Created successfully!!!"),
//			HttpStatus.OK);
//}
//
//
////	// Create Defect Type
////	@PostMapping(value = "/defecttype")
////	public ResponseEntity<Object> createDefectType(@RequestBody TypeDto defectTypeDto) {
////		if (defectTypeMapper.createDefectType(defectTypeDto)) {
////			logger.info("Defect Type created");
////			return new ResponseEntity<>(new ApiResponse(RestApiResponseStatus.OK), HttpStatus.OK);
////		} else {
////			logger.error("Defect Type Create Fail");
////			return new ResponseEntity<>("Defect Type Added Failure", HttpStatus.BAD_REQUEST);
////		}
////	}
////
////	// Get All Defect Types
////	@GetMapping(value = "/defecttypes")
////	public List<TypeDto> getAllDefectType() {
////		logger.info("Defect Types Listed");
////		return defectTypeMapper.getAllDefectType();
////	}
////
////	// Get Defect Type By Id
////	
////	@GetMapping(value = "/defecttype/{id}")
////	public TypeDto getDefectById(@PathVariable Long id) {
////		logger.info("Defect Type Get By Id Listed");
////		return defectTypeMapper.getDefectTypeById(id);
////	}
////
////	// Delete Defect Type	
////	
////	@DeleteMapping("/defecttype/{id}")
////	public ResponseEntity<Object> deleteDefectType(@PathVariable Long id, @RequestBody TypeDto defectTypeDto) {
////		defectTypeMapper.deleteDefectType(id);
////		logger.info("Defect Type Deleted");
////		return new ResponseEntity<>("Defect Type Deleted Successfully", HttpStatus.OK);
////	}
////
////	// Defect Type Updated
////	@PutMapping(value = "/defecttype/{id}")
////	public ResponseEntity<Object> updateDefectType(@RequestBody TypeDto defectTypeDto, @PathVariable Long id) {
////		defectTypeMapper.updateDefectType(id, defectTypeDto);
////		logger.info("Defect Type Updated");
////		return new ResponseEntity<>(new ApiResponse(RestApiResponseStatus.OK), HttpStatus.OK);
////	}
////	
////	// Count Defect Type 
////	@GetMapping("/countdefecttype")
////	public int getDefectTypeCount() {
////		logger.info("Defect Type Counted");
////		return defectTypeMapper.getDefectTypeCount();
////	}
////}
