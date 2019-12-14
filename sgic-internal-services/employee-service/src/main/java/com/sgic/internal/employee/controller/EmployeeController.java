package com.sgic.internal.employee.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.eureka.common.api.enums.RestApiResponseStatus;

import com.eureka.common.api.response.BasicResponse;
import com.eureka.common.api.response.ValidationFailure;
import com.eureka.common.dto.mapper.Mapper;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sgic.internal.employee.dto.EmployeeDTO;

import com.sgic.internal.employee.entities.Employee;
import com.sgic.internal.employee.repositories.EmployeeRepository;
import com.sgic.internal.employee.services.EmployeeService;
import com.sgic.internal.employee.services.FileStorageService;
import com.sgic.internal.employee.util.AppConstants;
import com.sgic.internal.employee.util.ErrorCodes;
import com.sgic.internal.employee.util.ValidationMessages;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeservice;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private FileStorageService fileStorageService;

	@Autowired
	private Mapper mapper;

	@Autowired
	private ErrorCodes errorCodes;

	ObjectMapper objectMapper = new ObjectMapper();

	@RequestMapping(value = AppConstants.EMPLOYEE_API, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> createemployee(@RequestBody EmployeeDTO employeeDto,
			@RequestParam(required = false, value = AppConstants.EMPLOYEE_FILE_PARAM) MultipartFile file)
			throws JsonParseException, JsonMappingException, IOException {
		if (employeeservice.isEmployeeIdAlreadyExist(employeeDto.getEmployeeId())) {
			return new ResponseEntity<>(
					new BasicResponse<>(new ValidationFailure(AppConstants.EMPLOYEE_ID, errorCodes.getEmployeeNoExit()),
							RestApiResponseStatus.VALIDATION_FAILURE, ValidationMessages.ID_EXIST),
					HttpStatus.BAD_REQUEST);
		}

		else if (employeeservice.isEmailAlreadyExist(employeeDto.getEmail())) {
			return new ResponseEntity<>(
					new BasicResponse<>(new ValidationFailure(AppConstants.EMAIL, errorCodes.getEmailAlreadyExist()),
							RestApiResponseStatus.VALIDATION_FAILURE, ValidationMessages.EMAIL_EXIST),
					HttpStatus.BAD_REQUEST);

		}
		Employee employee = mapper.map(employeeDto, Employee.class);
//		String fileName = fileStorageService.storeFile(file);
//		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path(AppConstants.DOWNLOAD_PATH)
//				.path(fileName).toUriString();
//		employee.setProfilePicturePath(fileDownloadUri);
		employeeservice.saveEmployee(employee);
		return new ResponseEntity<>(
				new BasicResponse<>(RestApiResponseStatus.CREATED, ValidationMessages.EMPLOYEE_CREATED), HttpStatus.OK);

	}

	@GetMapping(AppConstants.EMPLOYEES_API)
	public ResponseEntity<List<EmployeeDTO>> getAllEmployees(Long id) {
		List<Employee> employee = employeeservice.findByEmployeeOrderByEmployeeIdDesc(id);
		return new ResponseEntity<>(mapper.map(employee, EmployeeDTO.class), HttpStatus.OK);
	}

	@GetMapping(AppConstants.EMPLOYEE_API_WITH_ID)
	public ResponseEntity<EmployeeDTO> getEmployeeByemployeeId(
			@PathVariable(AppConstants.EMPLOYEE_PATH_VARIABLE) Long id) {
		Employee employee = employeeservice.getById(id);
		return new ResponseEntity<>(mapper.map(employee, EmployeeDTO.class), HttpStatus.OK);
	}

	@PutMapping(AppConstants.EMPLOYEE_API_WITH_ID)
	public ResponseEntity<Object> updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
		Employee employee = mapper.map(employeeDTO, Employee.class);
		employeeservice.updateEmployee(employee);
		return new ResponseEntity<>(
				new BasicResponse<>(RestApiResponseStatus.UPDATED, ValidationMessages.EMPLOYEE_UPDATED), HttpStatus.OK);
	}

	@DeleteMapping(AppConstants.EMPLOYEE_API_WITH_ID)
	public ResponseEntity<Object> deleteEmployee(@PathVariable(AppConstants.EMPLOYEE_PATH_VARIABLE) Long id) {
		try {
			employeeservice.deleteEmployeeById(id);
			return new ResponseEntity<>(
					new BasicResponse<>(RestApiResponseStatus.DELETED, ValidationMessages.EMPLOYEE_DELETED),
					HttpStatus.OK);
		} catch (Exception ex) {

		}
		return null;
	}

	@RequestMapping(value = AppConstants.EMPLOYEE_BENCH_TRUE_API, method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateBenchTrue(@RequestBody EmployeeDTO employeeDTO,
			@PathVariable(AppConstants.EMPLOYEE_PATH_VARIABLE) Long id) {
		Employee employee = mapper.map(employeeDTO, Employee.class);
		employeeservice.updateBenchTrue(id, employee);
		return new ResponseEntity<>(
				new BasicResponse<>(RestApiResponseStatus.UPDATED, ValidationMessages.EMPLOYEE_UPDATED), HttpStatus.OK);
	}

	@RequestMapping(value = AppConstants.EMPLOYEE_BENCH_FALSE_API, method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateBenchFalse(@RequestBody EmployeeDTO employeeDTO,
			@PathVariable(AppConstants.EMPLOYEE_PATH_VARIABLE) Long id) {
		Employee employee = mapper.map(employeeDTO, Employee.class);
		employeeservice.updateBenchFalse(id, employee);
		return new ResponseEntity<>(
				new BasicResponse<>(RestApiResponseStatus.UPDATED, ValidationMessages.EMPLOYEE_UPDATED), HttpStatus.OK);
	}

	@RequestMapping(value = AppConstants.EMPLOYEE_AVAILABILITY_API, method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateAvailability(@RequestBody EmployeeDTO employeeDTO,
			@PathVariable(AppConstants.EMPLOYEE_PATH_VARIABLE) Long id) {
//		Employee employee = mapper.map(employeeDTO, Employee.class);
		int availablenow = employeeDTO.getAvailability();
		employeeRepository.updateAvailability(availablenow,id);
		return new ResponseEntity<>(
				new BasicResponse<>(RestApiResponseStatus.UPDATED, ValidationMessages.EMPLOYEE_UPDATED), HttpStatus.OK);
	}

}
