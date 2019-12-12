//package com.sgic.internal.defecttracker.defectservice.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.sgic.internal.defecttracker.defectservice.controller.dto.RoleDto;
//import com.sgic.internal.defecttracker.defectservice.controller.dto.mapper.RoleMapper;
//
//@CrossOrigin
//@RestController
//public class RoleController {
//
//	@Autowired
//	private RoleMapper roleMapper;
//	
//	@GetMapping("/getAllRoleInfo")
//	public List<RoleDto> getAllroleInfo(){
//		return roleMapper.getAllRole();	
//	}
//}
