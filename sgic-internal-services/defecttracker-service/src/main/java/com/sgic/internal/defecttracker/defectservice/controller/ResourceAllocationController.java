//package com.sgic.internal.defecttracker.defectservice.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//import com.sgic.internal.defecttracker.defectservice.controller.dto.ResourceAllocationDto;
//import com.sgic.internal.defecttracker.defectservice.controller.dto.mapper.ResourceAllocationDtoMapper;
//import com.sgic.internal.defecttracker.defectservice.entities.Employee;
//import com.sgic.internal.defecttracker.defectservice.entities.Project;
//import com.sgic.internal.defecttracker.defectservice.entities.ResourceAllocation;
//import com.sgic.internal.defecttracker.defectservice.entities.ResourceAllocationList;
//import com.sgic.internal.defecttracker.defectservice.repositories.ResourceAllocationRepository;
//import com.sgic.internal.defecttracker.defectservice.services.ResourceAllocationService;
//
//@SuppressWarnings("unused")
//@RestController
//@CrossOrigin(origins = "*", allowedHeaders = "*") // <-- Integration With FrondEnd (React)-->
//public class ResourceAllocationController {
//
//	@Autowired
//	private ResourceAllocationDtoMapper resourceAllocationDtoMapper;
//
//	@Autowired
//	private ResourceAllocationService resourceAllocationService;
//
//	private static Logger logger = LogManager.getLogger(ResourceAllocationDtoMapper.class);
//
//	// Save Single Object
//	@PostMapping(value = "/saveresource")
//	public ResponseEntity<String> createResource(@RequestBody ResourceAllocationDto resourceAllocationDto) {
//		try {
//			logger.info("Resource Controller :--> Successfully Saved");
//			resourceAllocationDtoMapper.saveResource(resourceAllocationDto);
//			
//		} catch (Exception ex) {
//			logger.error("Resource Controller :--> error" + ex.getMessage());
//		}
//		return null;
//
//	}
//
//	// Save all resource List
//	@PostMapping(value = "/saveresourceTable")
//	public void createResourceTable(@RequestBody List<ResourceAllocationDto> resourceAllocationDto) {
//		try {
//			logger.info("Resource Controller :--> Successfully Saved Bulk Data");
//
//			resourceAllocationDtoMapper.saveResourceTable(resourceAllocationDto);
//		} catch (Exception ex) {
//			logger.error("Resource Controller :--> error" + ex.getMessage());
//		}
//
//	}
//
//	// Get All Resources
//	@GetMapping("/GetAllresources")
//	public List<Employee> getEmployeeList() {
//		try {
//			logger.info("Resource Controller :--> Successfully Get Resource List");
//			RestTemplate restTemplate = new RestTemplate();
//			ResponseEntity<List<Employee>> response = restTemplate.exchange(
//					"http://localhost:8084/employeeservice/getallemployee", HttpMethod.GET, null,
//					new ParameterizedTypeReference<List<Employee>>() {
//					});
//			List<Employee> employee = response.getBody();
//			return employee;
//
//		} catch (Exception ex) {
//			logger.error("Resource Controller :--> error" + ex.getMessage());
//		}
//		return null;
//
//	}
//
//	// Get Resource By Resource Id
//	@GetMapping("/getresourcebyId/{resourceId}")
//	public ResponseEntity<ResourceAllocationDto> getResourceById(@PathVariable(name = "resourceId") Long resourceId) {
//		try {
//			logger.info("Employee Controller -> GetEmployeeById");
//			return new ResponseEntity<>(resourceAllocationDtoMapper.findResourceAllocationByresourceId(resourceId),
//					HttpStatus.OK);
//		} catch (Exception ex) {
//			logger.error("Resource Controller :--> error" + ex.getMessage());
//		}
//		return null;
//	}
//
//	// Get all Resources By Resource
//	@RequestMapping("/resourceObj/{resourceId}")
//	public ResourceAllocationList getResourceAllocationObj(@PathVariable("resourceId") Long resourceId) {
//		ResourceAllocationList resourceAllocationList = new ResourceAllocationList();
//		ResourceAllocation resourceAllocation = resourceAllocationService
//				.findResourceAllocationByresourceId(resourceId);
//		resourceAllocationList.setResourceId(resourceAllocation.getResourceId());
//		resourceAllocationList.setEmpId(resourceAllocation.getEmpId());
//
//		// Used Rest Template For Get EMPLOYEE SERVICE EMPLOYEE API
//		RestTemplate restTemplate = new RestTemplate();
//		ResponseEntity<Employee> response = restTemplate.exchange(
//				"http://localhost:8084/employeeservice/getempolyeebyid/" + resourceAllocation.getEmpId(),
//				HttpMethod.GET, null, new ParameterizedTypeReference<Employee>() {
//				});
//
//		Employee employee = response.getBody();
//		return resourceAllocationList;
//
//	}
//
//	// Get Resource +Project+ Employee List
//	@GetMapping("/getallresource")
//	public List<ResourceAllocationList> getAllSubClassList() {
//		try {
//			RestTemplate restTemplate = new RestTemplate();
//			List<ResourceAllocation> resourceList = resourceAllocationService.getresourceById();
//			int length = resourceList.size();
//			System.out.println(length);
//			// Used To Check ResorceAllocation Table's EmployeeId List + Employee Service
//			// EMPLOYEE List And Save Another List (resourceAllocationList)
//			List<ResourceAllocationList> retrievedresource = new ArrayList<ResourceAllocationList>();
//			for (int i = 0; i < length; i++) {
//				logger.info("Resource Controller :--> loop started");
//				ResourceAllocationList resourceAllocationList = new ResourceAllocationList();
//				Long resourceId = Long.parseLong(String.valueOf(resourceList.get(i)));
//				ResourceAllocation resourceallocation = resourceAllocationService
//						.findResourceAllocationByresourceId(resourceId);
//				resourceAllocationList.setResourceId(resourceallocation.getResourceId());
//				resourceAllocationList.setEmpId(resourceallocation.getEmpId());
//				resourceAllocationList.setProjectId(resourceallocation.getProject().getProjectId());
//				resourceAllocationList.setProjectName(resourceallocation.getProject().getProjectName());
//
//				ResponseEntity<Employee> response = restTemplate.exchange(
//						// <--Get EMPLOYEE SERVICE EMPLOYEE LIST BY EMPLOYEE ID-->
//						"http://localhost:8084/employeeservice/getempolyeebyid/" + resourceallocation.getEmpId(),
//						HttpMethod.GET, null, new ParameterizedTypeReference<Employee>() {
//						});
//				Employee employee = response.getBody();
//				// Saved Employee Variable In resourceAllocationList and Get All EmployeeList in
//				// responceBody
//				resourceAllocationList.setEmpId(employee.getEmpId());
//				resourceAllocationList.setEmployeeid(employee.getEmployeeid());
//				resourceAllocationList.setFirstname(employee.getFirstname());
//				resourceAllocationList.setName(employee.getName());
//				resourceAllocationList.setEmail(employee.getEmail());
//				resourceAllocationList.setAvailability(employee.getAvailability());
//				resourceAllocationList.setBench(employee.isBench());
//				resourceAllocationList.setDesignationid(employee.getDesignationid());
//				resourceAllocationList.setDesignationname(employee.getDesignationname());
//				retrievedresource.add(resourceAllocationList);
//				// System.out.println(employee.getEmployeeid());
//
//			}
//			return retrievedresource;
//		} catch (Exception ex) {
//
//			logger.error("Resource Controller :--> error" + ex.getMessage());
//		}
//		return null;
//	}
//
//	// Delete resources
//	@DeleteMapping("/resource/{resourceId}")
//	public ResponseEntity<String> deleteResourceByResourceId(
//			@PathVariable("resourceId") Long resourceId) {
//		try {
//			logger.info("Resource Allocation Controller -> Deleted");
//			System.out.println(resourceId);
//			resourceAllocationDtoMapper.deleteResourceByresourceId(resourceId);
//			return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
//		} catch (Exception ex) {
//			logger.error("Resource Controller :--> error" + ex.getMessage());
//		}
//		return null;
//
//	}
//
//	
//	@GetMapping("/getemployee/{empId}") 
//	public List<ResourceAllocationDto> getByEmployee(@PathVariable(name = "empId") Long empId) {
//		try {
//			return resourceAllocationDtoMapper.getResourceAllocationByEmployee(empId);
//		} catch (Exception ex) {
//		}
//		return null;
//
//	}
//	
//	@GetMapping("/getprojectbyresource/{projectId}") 
//	public List<ResourceAllocationDto> getByprojectId(@PathVariable(name = "projectId") String projectId) {
//		try {
//			return resourceAllocationDtoMapper.getResourceAllocationByprojectId(projectId);
//			
//		} catch (Exception ex) {
//		}
//		return null;
//	}
//
//}
