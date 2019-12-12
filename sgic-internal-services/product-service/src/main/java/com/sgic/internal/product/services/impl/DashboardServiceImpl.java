package com.sgic.internal.product.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.product.entities.Dashboard;
import com.sgic.internal.product.repositories.DashboardRepository;
import com.sgic.internal.product.services.DashboardService;

@Service
public class DashboardServiceImpl implements DashboardService {

	@Autowired
	private DashboardRepository dashboardRepository;
	
	@Override
	public Dashboard createDashboard(Dashboard dashboard) {
		return dashboardRepository.save(dashboard);
	}

	@Override
	public List<Dashboard> getAllDashboard() {
		return dashboardRepository.findAll();
	}

}
