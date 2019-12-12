//package com.sgic.internal.product.controller;
//
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//import com.sgic.internal.product.controller.dto.DashboardConfigDto;
//import com.sgic.internal.product.controller.dto.SeverityDto;
//import com.sgic.internal.product.controller.dto.mapper.DashboardConfigMapper;
//import com.sgic.internal.product.entities.DashboardConfig;
//import com.sgic.internal.product.services.DashboardConfigService;
//
//@RestController
//@CrossOrigin(origins = "*", allowedHeaders = "*")
//public class DashboardConfigController<ResultObject> {
//
//    @SuppressWarnings("unused")
//	@Autowired
//	private DashboardConfigService dashboardConfigService;
//	
//    @Autowired
//    private DashboardConfigMapper<ResultObject> dashboardConfigMapper;
//	
//	@PostMapping(value = "/createdashboardconfig")
//	public ResultObject savedashbordconfog( @RequestBody  DashboardConfig dashboardConfig) {
//		System.out.println(dashboardConfig.getDashboardList().get(0).length());
//		DashboardConfig obj=new DashboardConfig();
//		obj.setConfigId(dashboardConfig.getConfigId());
//		obj.setRoleName(dashboardConfig.getRoleName());
//		obj.setDashboardList(dashboardConfig.getDashboardList());
//		dashboardConfigService.createDashboardConfig(dashboardConfig);
////		 dashboardConfigMapper.savedashboardconfig(dashboardConfigDto);
//		return null;
//	}
//	
//	
//	@GetMapping("/Config")
//	public List<DashboardConfigDto> getAllDashboardConfig() {	
//		return dashboardConfigMapper.getAllDashboardConfig();
//	}
//	
////	@PostMapping(value = "/createdashboardconfig")
////	public ResultObject savedashbordconfog( @RequestBody  DashboardConfigDto dashboardConfigDto) {
////		return dashboardConfigMapper.savedashboardconfig(dashboardConfigDto);
////		
////	}
//	
//	@GetMapping("/getbyrolename/{roleName}")
//	public List<DashboardConfig> getRoleName(@PathVariable (name = "roleName") String roleName){
//		return dashboardConfigService.getByRoleName(roleName);
//	}
//	
//	@GetMapping("/getbyusername/{userName}")
//	public List<DashboardConfig> getUserName(@PathVariable (name = "userName") String userName){
//		return dashboardConfigService.getByUserName(userName);
//	}
//	
//	@PutMapping("/updatedashboardconfig/{configId}")
//	public ResponseEntity<String> updateDashboardConfig(@RequestBody DashboardConfig dashboardConfig) {
//		if (dashboardConfigService.updateDashboardConfig(dashboardConfig) != null) {
//			return new ResponseEntity<>("Sucessfully Updated Dashboard Config", HttpStatus.OK);
//		}
//		return new ResponseEntity<>("Update FAILED!!!", HttpStatus.BAD_REQUEST);
//	}
//	
//}
