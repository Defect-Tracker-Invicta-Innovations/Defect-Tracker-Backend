package com.sgic.internal.product.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.product.entities.DashboardConfiguration;

public interface DashboardConfigurationRepository extends JpaRepository<DashboardConfiguration, Long> {

	public DashboardConfiguration findDashboardConfigurationById(Long dashboardConfigurationId);
	
	public List<DashboardConfiguration> findDashboardConfigurationByRoleName(String roleName);
	
	public List<DashboardConfiguration> findDashboardConfigurationByUserName(String userName);
	
}
