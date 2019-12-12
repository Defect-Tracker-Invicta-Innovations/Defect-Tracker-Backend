//package com.sgic.internal.product.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//import com.sgic.internal.product.controller.dto.DashboardDto;
//import com.sgic.internal.product.controller.dto.mapper.DashboardMapper;
//import com.sgic.internal.product.entities.Dashboard;
//
//@RestController
//@CrossOrigin(origins = "*", allowedHeaders = "*")
//public class DashboardController {
//
//	@Autowired
//	private DashboardMapper dasboardMapper;
//	
//	@PostMapping(value = "/createdashboard")
//	public Dashboard savedashbord(@RequestBody DashboardDto dashboardDto) {
//		return dasboardMapper.savedashboard(dashboardDto);
//	}
//
//	@GetMapping(value = "/getAllDashborad")
//	public List<DashboardDto> getAllDashboardInfo(){
//		return dasboardMapper.getAllDashboard();
//	}
//	
//}
