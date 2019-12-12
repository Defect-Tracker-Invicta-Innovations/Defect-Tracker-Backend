//package com.sgic.internal.product.controller;
//
//import java.util.List;
//
//import javax.validation.Valid;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.sgic.internal.product.controller.dto.RoleDto;
//import com.sgic.internal.product.controller.dto.SeverityDto;
//import com.sgic.internal.product.controller.dto.mapper.RoleMapper;
//import com.sgic.internal.product.controller.dto.mapper.SeverityMapper;
//import com.sgic.internal.product.entities.Role;
//import com.sgic.internal.product.services.RoleService;
//
//@CrossOrigin(origins = "*",allowedHeaders = "*")
//@RestController
//public class RoleController {
//	
//	@Autowired
//	private RoleService roleService;
//	private RoleMapper roleMapper;
//	private static Logger logger = LogManager.getLogger(RoleMapper.class);
//
////	@PostMapping("/createRole")
////	public Role saveRole(@RequestBody Role role) {
////		return roleService.saveRole(role);	
////	}
//	
//	// Save All Role
//	@PostMapping("/Role")
//	public ResponseEntity<String> saveRole(@Valid @RequestBody RoleDto roleDto) {
//		if (roleMapper.saveRole(roleDto) != null) {
//			logger.info("Role Controller -> Role Created Successful");
//			return new ResponseEntity<>("Role added succesfully", HttpStatus.OK);
//		}
//		logger.info("Role Controller -> Role creation FAILED!!!");
//		return new ResponseEntity<>("SAVE FAILED!", HttpStatus.BAD_REQUEST);
//	}
//	
//	@GetMapping("/getAllRoleInfos")
//	public List<Role> getAllroleInfo(){
//		return roleService.getAllRoleInfo();	
//	}
//	
//	@GetMapping("/getroleById/{roleId}") 
//	public ResponseEntity<Role> getRoleById(@PathVariable(name = "roleId") Long roleId) {
//			return new ResponseEntity<>(roleService.getRoleById(roleId),HttpStatus.OK);
//	}
//}
