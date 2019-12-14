package com.sgic.internal.defecttracker.defectservice.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sgic.internal.defecttracker.defectservice.entities.ResourceAllocation;
import com.sgic.internal.defecttracker.defectservice.repositories.ResourceAllocationRepository;
import com.sgic.internal.defecttracker.defectservice.services.ResourceAllocationService;

@Service
public class ResourceAllocationServiceImpl implements ResourceAllocationService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ResourceAllocationRepository resourceAllocationRepository;

	@Autowired
	private static Logger logger = LogManager.getLogger(ResourceAllocationRepository.class);

	@SuppressWarnings("unused")
	@Override
//	<---Resource Allocation Save method's implementation as well as update the bench as true in employee service--->
	public ResponseEntity<String> saveresource(ResourceAllocation resourceAllocation) {
		try {

			System.out.println("ccccccccccccccccccccccc" + resourceAllocation.getAvailability());
			Long eid = resourceAllocation.getEmpId();
			int availability = resourceAllocation.getAvailability();
			System.out.println("Employee id" + eid);
			System.out.println("Availability" + availability);

			boolean isExist = resourceAllocationRepository.findResourceAllocationByempId(eid) != null;
			System.out.println("isExists------->" + isExist);

			boolean isNotExceed = resourceAllocationRepository.AvailabileSum(eid) == null
					|| resourceAllocationRepository.AvailabileSum(eid) < 100;
			System.out.println("Availability Resource " + resourceAllocationRepository.AvailabileSum(eid));
			int total = 0;
			System.out.println("isNotExceed" + isNotExceed);
			if (resourceAllocationRepository.AvailabileSum(eid) == null) {
				int availablenow = 0;
				total = availability + availablenow;
				System.out.println("total " + total);

			} else {
				total = availability + resourceAllocationRepository.AvailabileSum(eid).intValue();
				System.out.println("total " + total);

			}
			// System.out.println("resourceAllocationRepository.AvailabileSum(eid).intValue()
			// " +resourceAllocationRepository.AvailabileSum(eid));

			if (total < 100 || total == 100) {
				if (isNotExceed) {

					resourceAllocationRepository.save(resourceAllocation);
					logger.error("Successfully Saved ");

//				<-----     Update Availablity    ------>

					HttpHeaders headers1 = new HttpHeaders();
					headers1.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
					if (isExist) {
						int x = resourceAllocation
								.setAvailability(resourceAllocationRepository.AvailabileSum(eid).intValue());
						System.out.println("Availability--> " + resourceAllocation.getAvailability());
						System.out.println("x-->" + x);
					}
					HttpEntity<Object> response = new HttpEntity<Object>(resourceAllocation, headers1);

					restTemplate.exchange("http://localhost:8084/employeeservice/update/availability/" + eid,
							HttpMethod.PUT, response, String.class);
					logger.info("ResourceAllocationServiceImpl-->successfully update availability");

					// <----- Update Bench ----->
					String url = "http://localhost:8084/employeeservice/getempolyeebyid/" + eid;
					String resp = restTemplate.getForObject(url, String.class);

					HttpHeaders headers = new HttpHeaders();

					headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
					headers.setContentType(MediaType.APPLICATION_JSON);
					HttpEntity<String> respo = new HttpEntity<String>(resp, headers);

					ResponseEntity<String> obj = restTemplate.exchange(
							"http://localhost:8084/employeeservice/update/benchtrue/" + eid, HttpMethod.PUT, respo,
							String.class);
					logger.info("ResourceAllocationServiceImpl-->successfully updates Bench");

					return new ResponseEntity<>("Successfully Saved", HttpStatus.OK);
				} else {
					logger.error("Already Exceeds 100%");
					return new ResponseEntity<>("Already Exceeds 100%", HttpStatus.OK);
				}

			} else {
				logger.error("Caanot allocate more than 100%");
				return new ResponseEntity<>("Caanot allocate more than 100%", HttpStatus.OK);
			}
		} catch (Exception ex) {
			logger.error("Resource Allocation Imp Error :-> " + ex.getMessage());
		}
		return null;

	}

	@Override
//	<---Resource Allocation Get List method's implementation--->
	public List<ResourceAllocation> gettAllResource() {
		try {
			logger.info("ResourceAllocationServiceImpl-->successfully listed Resource");
			return resourceAllocationRepository.findAll();
		} catch (Exception ex) {
			logger.error("Resource Allocation Imp Error :-> " + ex.getMessage());
		}
		return null;

	}

	@Override
//	<---Resource Allocation Get By Id  method's implementation--->
	public ResourceAllocation findResourceAllocationByresourceId(Long resourceId) {
		try {
			logger.info("ResourceAllocationServiceImpl-->successfully Get Resource By Id");
			return resourceAllocationRepository.findResourceAllocationByresourceId(resourceId);
		} catch (Exception ex) {
			logger.error("Resource Allocation Imp Error :-> " + ex.getMessage());
		}
		return null;

	}

	@Override
//	<---Resource Allocation List Resource Allocation By Id method's implementation--->
	public List<ResourceAllocation> getresourceById() {
		try {
			logger.info("ResourceAllocationServiceImpl-->successfully Resource by Resource Id");
			return resourceAllocationRepository.getAllresourceId();
		} catch (Exception ex) {
			logger.error("Resource Allocation Imp Error :-> " + ex.getMessage());
		}
		return null;

	}

	@Override
//	<---Resource Allocation List Resource Save  method's implementation--->
	public void saveResourceTable(List<ResourceAllocation> resourceAllocation) {

		try {
			int size = resourceAllocation.size();
			int counter = 0;
			List<ResourceAllocation> temp = new ArrayList<>();

			for (ResourceAllocation emp : resourceAllocation) {
				logger.info("ResourceAllocationServiceImpl-->successfully Resource ---Get -- By --List");
				temp.add(emp);

				if ((counter + 1) % 500 == 0 || (counter + 1) == size) {
					logger.info("ResourceAllocationServiceImpl-->successfully Resource ---Get -- By --List Saved");
					resourceAllocationRepository.saveAll(resourceAllocation);
					temp.clear();
				}
				counter++;
			}
		} catch (Exception ex) {
			logger.error("Resource Allocation Imp Error :-> " + ex.getMessage());
		}

	}

	@Override
//	<---Resource Allocation Delete  method's implementation as well as update the bench as false in employee service--->
	public ResponseEntity<String> deleteResourceById(Long resourceId) {
		try {

			ResourceAllocation resourceAllocationq = resourceAllocationRepository
					.findResourceAllocationByresourceId(resourceId);

			Long eid = resourceAllocationq.getEmpId();

			System.out.println("Employee id" + eid);

			String url = "http://localhost:8084/employeeservice/getempolyeebyid/" + eid;
			String resp = restTemplate.getForObject(url, String.class);

			System.out.println("resp " + resp);

			HttpHeaders headers = new HttpHeaders();

			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> respo = new HttpEntity<String>(resp, headers);

			restTemplate.exchange("http://localhost:8084/employeeservice/update/benchfalse/" + eid, HttpMethod.PUT,
					respo, String.class);

			logger.info("ResourceAllocationServiceImpl-->successfully Updated Bench");

			resourceAllocationRepository.deleteById(resourceId);

			logger.info("ResourceAllocationServiceImpl-->successfully Deleted Resource");

			return null;

		} catch (

		Exception ex) {
			logger.error("Resource Allocation Imp Error :-> " + ex.getMessage());
		}

		return null;

	}

	@Override
	public List<ResourceAllocation> getByEmployee(Long empId) {
		return resourceAllocationRepository.findResourceAllocationByempId(empId);
	}

	@Override
	public List<ResourceAllocation> getByprojectId(String projectId) {
//		return resourceAllocationRepository.findResourceAllocationByprojectId(projectId);
		List<ResourceAllocation> resourceAllocationq = resourceAllocationRepository
				.findResourceAllocationByprojectId(projectId);
//		List<String> col = new ArrayList<>();
		List<ResourceAllocation> resp = null;
		for (ResourceAllocation res : resourceAllocationq) {
			System.out.println("resourceId " + res.getResourceId());
			String url = "http://localhost:8081/defectservices/getRoleByResourceId/" + res.getResourceId();
			resp = restTemplate.getForObject(url, List.class);

			System.out.println("resp " + resp);
		}
		// System.out.println("resout" +resp);
		return resp;

	}
}
