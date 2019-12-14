package com.sgic.internal.product.services;

import java.util.List;
import com.sgic.internal.product.entities.DashboardConfiguration;

public interface DashboardConfigurationService {

	public DashboardConfiguration saveDashboardConfiguration(DashboardConfiguration dashboardConfiguration);
	
	public List<DashboardConfiguration> getAllDashboardConfiguration();
	
	public DashboardConfiguration getByDashboardConfigurationId(Long dashboardConfigurationId);
	
	public List<DashboardConfiguration> getByRoleName(String roleName);
	
	public List<DashboardConfiguration> getByUserName(String userName);
	
	public DashboardConfiguration updateDashboardConfiguration(DashboardConfiguration dashboardConfiguration);
}
