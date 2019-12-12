package com.sgic.internal.product.services;

import java.util.List;

import com.sgic.internal.product.entities.Dashboard;

public interface DashboardService {

	public Dashboard createDashboard(Dashboard dashboard);
	
	List<Dashboard> getAllDashboard();
}
