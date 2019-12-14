package com.sgic.internal.product.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eureka.common.api.enums.RestApiResponseStatus;
import com.eureka.common.api.response.BasicResponse;
import com.eureka.common.dto.mapper.Mapper;
import com.sgic.internal.product.controller.dto.DefectTypeDto;
import com.sgic.internal.product.entities.DefectType;
import com.sgic.internal.product.services.DefectTypeService;
import com.sgic.internal.product.services.impl.DefectTypeServiceImpl;
import com.sgic.internal.product.util.AppConstants;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1")
public class DefectTypeController {
	private static Logger logger = LogManager.getLogger(DefectTypeServiceImpl.class);

	@Autowired
	private DefectTypeService defectTypeService;

	@Autowired
	private Mapper mapper;

	@PostMapping(AppConstants.DEFECT_TYPE_URL)
	public ResponseEntity<Object> createDefectType(@RequestBody DefectTypeDto defectTypeDto) {
		if (defectTypeService.isDefectTypeAlreadyExists(defectTypeDto.getDefectType())) {
			logger.debug("Defect Type already exists: createDefectType(), defectType: {}");
			return new ResponseEntity<>(
					new BasicResponse<>(RestApiResponseStatus.VALIDATION_FAILURE, "Defect Type already exists!!!"),
					HttpStatus.BAD_REQUEST);
		}
		DefectType defectType = mapper.map(defectTypeDto, DefectType.class);
		defectTypeService.createDefectType(defectType);
		return new ResponseEntity<>(
				new BasicResponse<>(RestApiResponseStatus.CREATED, "Defect Type Created successfully!!!"),
				HttpStatus.OK);
	}

	@GetMapping(AppConstants.DEFECT_TYPES_URL)
	public ResponseEntity<List<DefectTypeDto>> getAllDefectTypes() {
		List<DefectType> defectType = defectTypeService.findAllDefectType();
		return new ResponseEntity<>(mapper.map(defectType, DefectTypeDto.class), HttpStatus.OK);
	}

	@GetMapping(AppConstants.DEFECT_TYPE_URL_WITH_ID)
	public ResponseEntity<DefectTypeDto> getDefectTypeById(@PathVariable("defectTypeId") Long defectTypeId) {
		DefectType defectType = defectTypeService.findDefectTypeById(defectTypeId);
		return new ResponseEntity<>(mapper.map(defectType, DefectTypeDto.class), HttpStatus.OK);
	}

	@DeleteMapping(AppConstants.DEFECT_TYPE_URL_WITH_ID)
	public ResponseEntity<String> deleteDefectType(@PathVariable("defectTypeId") Long defectTypeId) {
		defectTypeService.deleteDefectTypeById(defectTypeId);
		return new ResponseEntity<String>("Sucessfully deleted", HttpStatus.OK);

	}

	@PutMapping(AppConstants.DEFECT_TYPE_URL_WITH_ID)
	public ResponseEntity<Object> updateDefectType(@RequestBody DefectTypeDto defectTypeDto) {
		DefectType defectType = mapper.map(defectTypeDto, DefectType.class);
		defectTypeService.updateDefectType(defectType);
		logger.info("Defect Type Updated successfully: updateDefectType()");
		return new ResponseEntity<>(new BasicResponse<>(RestApiResponseStatus.UPDATED, "Updated successfully!!!"),
				HttpStatus.OK);

	}	
	
	@GetMapping(AppConstants.DEFECT_TYPE_COUNT_URL)
	public ResponseEntity<Integer> getDefectTypeCount() {
		Integer NoOfDefects = defectTypeService.getDefectTypeCount();
		return new ResponseEntity<Integer>(NoOfDefects, HttpStatus.OK);
	}
}