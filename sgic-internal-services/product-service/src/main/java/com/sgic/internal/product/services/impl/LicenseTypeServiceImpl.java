package com.sgic.internal.product.services.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.product.entities.LicenseType;
import com.sgic.internal.product.repositories.LicenseTypeRepository;
import com.sgic.internal.product.services.LicenseTypeService;

@Service
public class LicenseTypeServiceImpl implements LicenseTypeService {
	@Autowired
	LicenseTypeRepository licenseTypeRepository;

	private static Logger logger = LogManager.getLogger(LicenseTypeRepository.class);

	@Override
	public LicenseType saveLicenseType(LicenseType licenseType) {
		try {
			logger.debug("License Type Service Implementation --> saveLicenseType()");
			return licenseTypeRepository.save(licenseType);
		} catch (Exception e) {
			logger.error("License Type Service Implementation --> saveLicenseType()", e.getMessage());
		}
		return licenseType;
	}

	@Override
	public List<LicenseType> getAllLicenseType() {
		try {
			logger.debug("License Type Service Implementation--> getAllLicenseType()");
			return licenseTypeRepository.findAll();
		} catch (Exception e) {
			logger.error("License Type Service Implementation --> getAllLicenseType()", e.getMessage());
		}
		return null;
	}

	@Override
	public LicenseType updateLicenseType(LicenseType licenseType) {
		try {
			Long licenseTypeId = licenseType.getId();
			boolean isExist = licenseTypeRepository.findById(licenseTypeId) != null;
			if (isExist) {
				logger.info("license Type Service Implementation -> License Type updates Successfully");
				return licenseTypeRepository.save(licenseType);
			} else {
				logger.info("license Type Service Implementation -> license Type Id is Not Found");
			}

		} catch (Exception ex) {
			logger.error("license Type Service Implementation -> Error" + ex.getMessage());
		}

		return licenseType;
	}

	@Override
	public boolean isLicenseTypeAlreadyExist(String licenseType) {
		try {
			logger.debug("License Type Service Implementation--> isLicenseTypeAlreadyExist()");
			return licenseTypeRepository.existsByLicenseType(licenseType);
		} catch (Exception e) {
			logger.error("License Type Service Implementation --> isLicenseTypeAlreadyExist()", e.getMessage());
		}
		return false;
	}

}
