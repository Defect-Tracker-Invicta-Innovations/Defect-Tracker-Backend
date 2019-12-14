package com.sgic.internal.product.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eureka.common.api.enums.RestApiResponseStatus;
import com.eureka.common.api.response.BasicResponse;
import com.eureka.common.dto.mapper.Mapper;
import com.sgic.internal.product.controller.dto.DashboardConfigurationDto;
import com.sgic.internal.product.controller.dto.LicenseTypeDto;
import com.sgic.internal.product.controller.dto.SeverityDto;
import com.sgic.internal.product.entities.DashboardConfiguration;
import com.sgic.internal.product.entities.LicenseType;
import com.sgic.internal.product.services.DashboardConfigurationService;
import com.sgic.internal.product.util.AppConstants;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1")
public class DashboardConfigurationController<ResultObject> {

    @SuppressWarnings("unused")
	@Autowired
	private DashboardConfigurationService dashboardConfigurationService;
	
    @Autowired
	private Mapper mapper;

	private static Logger logger = LogManager.getLogger(LicenseTypeController.class);
	
	@PostMapping(AppConstants.DASHBOARD_CONFIGURATION_URL)
	public ResponseEntity<DashboardConfiguration> createDashboardConfiguration(@Valid @RequestBody DashboardConfigurationDto dashboardConfigurationDto) {
		DashboardConfiguration dashboardConfiguration = mapper.map(dashboardConfigurationDto, DashboardConfiguration.class);
		dashboardConfigurationService.saveDashboardConfiguration(dashboardConfiguration);
		return new ResponseEntity<>(HttpStatus.OK);
	}
    
//    @Autowired
//    private DashboardConfigMapper<ResultObject> dashboardConfigMapper;
	/*
	@PostMapping(value = "/createdashboardconfig")
	public ResultObject savedashbordconfog( @RequestBody  DashboardConfig dashboardConfig) {
		System.out.println(dashboardConfig.getDashboardList().get(0).length());
		DashboardConfig obj=new DashboardConfig();
		obj.setConfigId(dashboardConfig.getConfigId());
		obj.setRoleName(dashboardConfig.getRoleName());
		obj.setDashboardList(dashboardConfig.getDashboardList());
		dashboardConfigService.createDashboardConfig(dashboardConfig);
//		 dashboardConfigMapper.savedashboardconfig(dashboardConfigDto);
		return null;
	}
	*/

	@GetMapping(AppConstants.DASHBOARD_CONFIGURATIONS_URL)
	public List<DashboardConfiguration> getAllDashboardConfiguration() {	
		return dashboardConfigurationService.getAllDashboardConfiguration();
	}
	/*
//	@PostMapping(value = "/createdashboardconfig")
//	public ResultObject savedashbordconfog( @RequestBody  DashboardConfigDto dashboardConfigDto) {
//		return dashboardConfigMapper.savedashboardconfig(dashboardConfigDto);
//		
//	}
	
	@GetMapping("/getbyrolename/{roleName}")
	public List<DashboardConfig> getRoleName(@PathVariable (name = "roleName") String roleName){
		return dashboardConfigService.getByRoleName(roleName);
	}
	
	@GetMapping("/getbyusername/{userName}")
	public List<DashboardConfig> getUserName(@PathVariable (name = "userName") String userName){
		return dashboardConfigService.getByUserName(userName);
	}
	
	@PutMapping("/updatedashboardconfig/{configId}")
	public ResponseEntity<String> updateDashboardConfig(@RequestBody DashboardConfig dashboardConfig) {
		if (dashboardConfigService.updateDashboardConfig(dashboardConfig) != null) {
			return new ResponseEntity<>("Sucessfully Updated Dashboard Config", HttpStatus.OK);
		}
		return new ResponseEntity<>("Update FAILED!!!", HttpStatus.BAD_REQUEST);
	}
	*/
}
