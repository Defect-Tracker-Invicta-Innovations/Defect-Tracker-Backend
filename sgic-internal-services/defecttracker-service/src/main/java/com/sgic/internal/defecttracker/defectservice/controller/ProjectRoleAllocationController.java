//package com.sgic.internal.defecttracker.defectservice.controller;
//
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.List;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//import com.fasterxml.jackson.core.JsonParseException;
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.sgic.internal.defecttracker.defectservice.controller.dto.ProjectRoleAllocationDto;
//import com.sgic.internal.defecttracker.defectservice.controller.dto.UserDto;
//import com.sgic.internal.defecttracker.defectservice.controller.dto.mapper.ProjectRoleAllocationMapper;
//import com.sgic.internal.defecttracker.defectservice.entities.ProjectRoleAllocation;
//
//@CrossOrigin
//@RestController
//public class ProjectRoleAllocationController {
//
//	@Autowired
//	private RestTemplate restTemplate;
//
//	@Autowired
//	private ProjectRoleAllocationMapper projectRoleAllocationMapper;
//
//	private static Logger logger = LogManager.getLogger(ProjectRoleAllocationMapper.class);
//
//// <----This APIs Is -- Save Single Object--->
//	@PostMapping(value = "/saverole")
//	public ProjectRoleAllocation createRole(@RequestBody ProjectRoleAllocationDto projectRoleAllocationDto) {
//		try {
//			logger.info("Role Controller :--> Successfully Saved");
//			projectRoleAllocationMapper.saveRole(projectRoleAllocationDto);
//		} catch (Exception ex) {
//			logger.error("Role Controller :--> error" + ex.getMessage());
//		}
//		return null;
//
//	}
//
//	@GetMapping(value = "/getAllRole")
//	public ResponseEntity<List<ProjectRoleAllocationDto>> getAllRole() {
//		logger.info("Project Role Allocation Controller -> GetProjectRole");
//		return new ResponseEntity<>(projectRoleAllocationMapper.getAllRole(), HttpStatus.OK);
//	}
//
//	@GetMapping("/getprojectrolebyid/{projectroleId}")
//	public ResponseEntity<ProjectRoleAllocationDto> getProjectRoleAllocationById(
//			@PathVariable(name = "projectroleId") Long projectroleId) {
//		try {
//			return new ResponseEntity<>(projectRoleAllocationMapper.getByprojectroleId(projectroleId), HttpStatus.OK);
//
//		} catch (Exception ex) {
//
//		}
//		return null;
//
//	}
//
//	@GetMapping(value = "/saveuser")
//	public ResponseEntity<?> getAllRoleEmail() throws JsonParseException, JsonMappingException, IOException {
//		try {
//
//			String url = "http://localhost:8081/defectservices/getAllRole";
//			String resp = restTemplate.getForObject(url, String.class);
//
//			System.out.println("resp" + resp);
//
//			ObjectMapper objectMapper = new ObjectMapper();
//			List<ProjectRoleAllocationDto> list = objectMapper.readValue(resp,
//					new TypeReference<List<ProjectRoleAllocationDto>>() {
//					});
//			System.out.println("list " + list);
//
//			for (ProjectRoleAllocationDto entry : list) {
//				
////				if(entry.isBench()) {
//					
//				UserDto user = new UserDto();
//				user.setName(entry.getName());
//				user.setUsername(entry.getFirstname());
//				user.setEmail(entry.getEmail());
//				user.setPassword(entry.getPassword());
//				user.setRole(entry.getRoleName());
//				user.setLastname(entry.getName());
//				
//
//				System.out.println("userList " + user);
////
//				System.out.println("passowrdbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb" + user.getPassword());
//
//				HttpHeaders headers = new HttpHeaders();
//				headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//				HttpEntity<UserDto> entity = new HttpEntity<UserDto>(user, headers);
//				System.out.println("yes");
//				ResponseEntity<?> obj = restTemplate.exchange("http://localhost:8085/loginservice/api/auth/signup",
//						HttpMethod.POST, entity, UserDto.class);
//
//				System.out.println("obj" + obj);
//				}
//
////			}
//			return null;
//		} catch (Exception ex) {
//			logger.error("Check Your Error");
//			System.out.println("Something went Wrong" + ex.getCause());
//		}
//		return null;
//	}
//
//	//Role Deallocation
//	@DeleteMapping("/deletebyid/{projectroleId}")
//	public ResponseEntity<String> deleteEmployeeByprojectId(@PathVariable("projectroleId") Long projectroleId) {
//		try {
//			logger.info("Project Allocation Controller :-> DeleteEmployeeById");
//			projectRoleAllocationMapper.deleteByProjectId(projectroleId);
//// ProjectRoleAllocationRepository.deleteById(projectroleId);
//			return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
//		} catch (Exception ex) {
//			logger.error("Project Allocation Controller :-> Error " + ex.getMessage());
//		}
//		return null;
//	}
//	
////	<--- Get RoleByResourceId  -->
//	@GetMapping("/getRoleByResourceId/{resourceId}")
//	public ResponseEntity<List<ProjectRoleAllocationDto>> getRoleByProject(
//			@PathVariable(name = "resourceId") Long resourceId) {
//		logger.info("Project Role Allocation Controller -> GetProjectRole");
//		return new ResponseEntity<>(projectRoleAllocationMapper.getRoleByProject(resourceId), HttpStatus.OK);
//	}
//
//}