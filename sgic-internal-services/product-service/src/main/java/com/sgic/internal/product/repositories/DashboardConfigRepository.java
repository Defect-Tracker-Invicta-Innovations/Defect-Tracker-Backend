package com.sgic.internal.product.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.product.entities.DashboardConfig;

public interface DashboardConfigRepository extends JpaRepository<DashboardConfig, Long> {

	List<DashboardConfig> findDashboardConfigByroleName(String roleName);
	
	List<DashboardConfig> findDashboardConfigByuserName(String username);
	
    DashboardConfig findDashboardConfigByconfigId(Long configId);
}
