package com.sgic.internal.product.services;

import java.util.List;

import com.sgic.internal.product.entities.LicenseType;

public interface LicenseTypeService {

	public LicenseType saveLicenseType(LicenseType licenseType);

	public List<LicenseType> getAllLicenseType();

	public LicenseType updateLicenseType(LicenseType licenseType);
	
	public boolean isLicenseTypeAlreadyExist(String licenseType);
}
