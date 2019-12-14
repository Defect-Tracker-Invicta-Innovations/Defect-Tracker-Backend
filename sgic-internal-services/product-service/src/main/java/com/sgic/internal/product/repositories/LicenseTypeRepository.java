package com.sgic.internal.product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.product.entities.LicenseType;

public interface LicenseTypeRepository extends JpaRepository<LicenseType, Long> {

	boolean existsByLicenseType(String licenseType);
}
