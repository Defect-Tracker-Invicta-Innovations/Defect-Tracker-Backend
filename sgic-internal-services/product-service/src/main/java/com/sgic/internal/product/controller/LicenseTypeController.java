package com.sgic.internal.product.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eureka.common.api.enums.RestApiResponseStatus;
import com.eureka.common.api.response.BasicResponse;
import com.eureka.common.dto.mapper.Mapper;
import com.sgic.internal.product.controller.dto.LicenseTypeDto;
import com.sgic.internal.product.entities.LicenseType;
import com.sgic.internal.product.services.LicenseTypeService;
import com.sgic.internal.product.util.AppConstants;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1")
public class LicenseTypeController {
	@Autowired
	private LicenseTypeService licenseTypeService;

	@Autowired
	private Mapper mapper;

	private static Logger logger = LogManager.getLogger(LicenseTypeController.class);

	@PostMapping(AppConstants.LICENSE_TYPE_URL)
	public ResponseEntity<Object> createLicenseType(@Valid @RequestBody LicenseTypeDto licenseTypeDto) {
		System.out.println(licenseTypeDto.getLicenseType());
		if (licenseTypeService.isLicenseTypeAlreadyExist(licenseTypeDto.getLicenseType())) {
			logger.debug("License Type is already exists: createLicenseType(), licenseType: {}");
			return new ResponseEntity<>(
					new BasicResponse<>(RestApiResponseStatus.VALIDATION_FAILURE, "License Type is already exists!!!"),
					HttpStatus.BAD_REQUEST);
		}
		LicenseType licenseType = mapper.map(licenseTypeDto, LicenseType.class);
		licenseTypeService.saveLicenseType(licenseType);
		return new ResponseEntity<>(
				new BasicResponse<>(RestApiResponseStatus.CREATED, "License Type is Created successfully!!!"),
				HttpStatus.OK);
	}

	@GetMapping(AppConstants.LICENSE_TYPES_URL)
	public ResponseEntity<List<LicenseTypeDto>> getAllLicenseType() {
		List<LicenseType> licenseType = licenseTypeService.getAllLicenseType();
		return new ResponseEntity<>(mapper.map(licenseType, LicenseTypeDto.class), HttpStatus.OK);
	}

	@PutMapping(AppConstants.LICENSE_TYPE_URL_WITH_ID)
	public ResponseEntity<Object> updateLicenseType(@RequestBody LicenseTypeDto licenseTypeDto) {
		LicenseType licenseType = mapper.map(licenseTypeDto, LicenseType.class);
		licenseTypeService.saveLicenseType(licenseType);
		logger.info("License Type Updated successfully: updateLicenseType()");
		return new ResponseEntity<>(new BasicResponse<>(RestApiResponseStatus.UPDATED, "Updated successfully!!!"),
				HttpStatus.OK);

	}
}
