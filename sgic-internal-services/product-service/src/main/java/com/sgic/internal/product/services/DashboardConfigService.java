package com.sgic.internal.product.services;

import java.util.List;
import com.sgic.internal.product.entities.DashboardConfig;

public interface DashboardConfigService {

	public DashboardConfig createDashboardConfig(DashboardConfig dashboardConfig);
	
	List<DashboardConfig> getAllDashboardConfig();
	
	List<DashboardConfig> getByRoleName(String roleName);
	
	List<DashboardConfig> getByUserName(String userName);
	
	public DashboardConfig updateDashboardConfig(DashboardConfig dashboardConfig);
}
