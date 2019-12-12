//package com.sgic.internal.product.controller;
//
//import java.util.List;
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
//import com.sgic.internal.product.controller.dto.PriorityDto;
//import com.sgic.internal.product.controller.dto.mapper.PriorityMapper;
//import com.sgic.internal.product.services.impl.PriorityServiceImpl;
//
//@CrossOrigin(origins = "*",allowedHeaders = "*")
//@RestController
//public class PriorityController {
//	
//private static Logger logger = LogManager.getLogger(PriorityServiceImpl.class);
//	
//	@Autowired
//	private PriorityMapper defectPriorityMapper;
//	
//	// Author : ----- :: Create Defect Priority
//	@PostMapping(value = "/defectpriority")
//	public ResponseEntity<Object> createDefectPriority(@RequestBody PriorityDto defectPriorityDto){
//		if(defectPriorityMapper.createDefectPriority(defectPriorityDto)) {
//			return new ResponseEntity<>("Defect Priority Added Successfully", HttpStatus.OK);
//		}
//		else {
//			return new ResponseEntity<>("Defect Priority Added Successfully", HttpStatus.OK);
//		}
//	}
//	
//	// Author : ----- :: Get All Defect Priority
//	@GetMapping(value = "/defectpriorities")
//	public List<PriorityDto> getAllDefectPriorities() {
//		logger.info("Defect Priorities Listed");
//		return defectPriorityMapper.getAllDefectPriority();
//	}
//	
//	// Author : ----- :: Get Defect Priority By Id
//	@GetMapping(value = "/defectpriority/{id}")
//	public PriorityDto getDefectPriorityById(@PathVariable Long id) {
//		logger.info("Defect Priority Get By Id Listed");
//		return defectPriorityMapper.getDefectPriorityById(id);
//	}
//	
//	// Author : ----- :: Update Defect Priority
//	@PutMapping(value = "/defectpriority/{id}")
//	public ResponseEntity<Object> updateDefectPriority(@RequestBody PriorityDto defectPriorityDto, @PathVariable Long id) {
//		defectPriorityMapper.updateDefectPriority(id, defectPriorityDto);
//		logger.info("Defect Priority Updated");
//		return new ResponseEntity<>("Defect Priority Updated Successfully", HttpStatus.OK);
//	}
//	
//	// Author : ----- :: Delete Defect Priority
//	@DeleteMapping(value = "/defectpriority/{id}")
//	public ResponseEntity<Object> deleteDefectPriority(@PathVariable Long id, @RequestBody PriorityDto defectPriorityDto) {
//		defectPriorityMapper.deleteDefectPriority(id);
//		logger.info("Defect Priority Deleted");
//		return new ResponseEntity<>("Defect Priority Deleted Successfully", HttpStatus.OK);
//	}
//	
//}
