package com.sgic.internal.product.services.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.product.entities.DashboardConfiguration;
import com.sgic.internal.product.repositories.DashboardConfigurationRepository;
import com.sgic.internal.product.services.DashboardConfigurationService;

@Service
public class DashboardConfigurationServiceImpl implements DashboardConfigurationService{

	@Autowired
	private DashboardConfigurationRepository dashboardConfigurationRepository;

	private static Logger logger = LogManager.getLogger(DashboardConfigurationRepository.class);
	
	@Override
	public DashboardConfiguration saveDashboardConfiguration(DashboardConfiguration dashboardConfiguration) {
		try {
			logger.debug("Dashboard Configuration Service Implementation --> saveDashboardConfiguration()");
			return dashboardConfigurationRepository.save(dashboardConfiguration);
		} catch (Exception e) {
			logger.error("Dashboard Configuration Service Implementation --> saveDashboardConfiguration()", e.getMessage());
		}
		return dashboardConfiguration;
	}
	
	@Override
	public List<DashboardConfiguration> getAllDashboardConfiguration() {
		try {
			logger.debug("Dashboard Configuration Service Implementation--> getAllDashboardConfiguration()");
			return dashboardConfigurationRepository.findAll();
		} catch (Exception e) {
			logger.error("Dashboard Configuration Service Implementation --> getAllDashboardConfiguration()", e.getMessage());
		}
		return null;
	}
	
	@Override
	public DashboardConfiguration getByDashboardConfigurationId(Long dashboardConfigurationId) {
		try {
			logger.debug("Dashboard Configuration Service Implementation--> getByDashboardConfigurationId()");
			return dashboardConfigurationRepository.findDashboardConfigurationById(dashboardConfigurationId);
		} catch (Exception e) {
			logger.error("Dashboard Configuration Service Implementation --> getByDashboardConfigurationId()", e.getMessage());
		}
		return null;
	}
	
	@Override
	public List<DashboardConfiguration> getByRoleName(String roleName) {
		try {
			logger.debug("Dashboard Configuration Service Implementation--> getByRoleName()");
			return dashboardConfigurationRepository.findDashboardConfigurationByRoleName(roleName);
		} catch (Exception e) {
			logger.error("Dashboard Configuration Service Implementation --> getByRoleName()", e.getMessage());
		}
		return null;
	}

	@Override
	public List<DashboardConfiguration> getByUserName(String userName) {
		try {
			logger.debug("Dashboard Configuration Service Implementation--> getByUserName()");
			return dashboardConfigurationRepository.findDashboardConfigurationByUserName(userName);
		} catch (Exception e) {
			logger.error("Dashboard Configuration Service Implementation --> getByUserName()", e.getMessage());
		}
		return null;
	}
	
	@Override
	public DashboardConfiguration updateDashboardConfiguration(DashboardConfiguration dashboardConfiguration) {
		try {
			Long dashboardConfigurationId = dashboardConfiguration.getId();
			boolean isExist = dashboardConfigurationRepository.findById(dashboardConfigurationId) != null;
			if (isExist) {
				logger.info("Dashboard Configuration Service Implementation -> Dashboard Configuration updates Successfully");
				return dashboardConfigurationRepository.save(dashboardConfiguration);
			} else {
				logger.info("Dashboard Configuration Service Implementation -> Dashboard Configuration Id is Not Found");
			}

		} catch (Exception ex) {
			logger.error("Dashboard Configuration Service Implementation -> Error" + ex.getMessage());
		}
		return null;
	}

	
}
