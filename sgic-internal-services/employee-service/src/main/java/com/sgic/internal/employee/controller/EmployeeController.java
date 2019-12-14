//package com.sgic.internal.employee.controller;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.Resource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//
//import com.eureka.common.api.enums.RestApiResponseStatus;
//
//import com.eureka.common.api.response.BasicResponse;
//import com.eureka.common.api.response.ValidationFailure;
//import com.eureka.common.dto.mapper.Mapper;
//import com.fasterxml.jackson.core.JsonParseException;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.sgic.internal.employee.dto.EmployeeDTO;
//
//import com.sgic.internal.employee.entities.Designation;
//import com.sgic.internal.employee.entities.Employee;
//import com.sgic.internal.employee.services.EmployeeService;
//import com.sgic.internal.employee.services.FileStorageService;
//import com.sgic.internal.employee.util.AppConstants;
//import com.sgic.internal.employee.util.ErrorCodes;
//import com.sgic.internal.employee.util.ValidationMessages;
//
//@RestController
//@CrossOrigin(origins = "*", allowedHeaders = "*")
//public class EmployeeController {
//
//	@Autowired
//	private EmployeeService employeeservice;
//
//	@Autowired
//	private ErrorCodes errorCodes;
//
//	@Autowired
//	FileStorageService fileStorageService;
//
//	@Autowired
//	Mapper mapper;
//
//	private static Logger logger = LogManager.getLogger(EmployeeController.class);
//
//	ObjectMapper objectMapper = new ObjectMapper();
//
//	@RequestMapping(value = "/employee", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Object> createemployee(@RequestBody EmployeeDTO employeeDto,
//			@RequestParam(required = false, value = AppConstants.EMPLOYEE_FILE_PARAM) MultipartFile file)
//			throws JsonParseException, JsonMappingException, IOException {
//		if (employeeservice.isEmployeeIdAlreadyExist(employeeDto.getEmployeeid())) {
//			return new ResponseEntity<>(
//					new BasicResponse<>(new ValidationFailure(AppConstants.EMAIL, errorCodes.getEmailAlreadyExist()),
//							RestApiResponseStatus.VALIDATION_FAILURE, ValidationMessages.ID_EXIST),
//					HttpStatus.BAD_REQUEST);
//		}
//
//		else if (employeeservice.isEmailAlreadyExist(employeeDto.getEmail())) {
//			return new ResponseEntity<>(
//					new BasicResponse<>(new ValidationFailure(AppConstants.EMAIL, errorCodes.getEmailAlreadyExist()),
//							RestApiResponseStatus.VALIDATION_FAILURE, ValidationMessages.EMAIL_EXIST),
//					HttpStatus.BAD_REQUEST);
//
//		} else {
//			Employee employee = mapper.map(employeeDto, Employee.class);
////			String fileName = fileStorageService.storeFile(file);
////			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
////					.path(AppConstants.DOWNLOAD_PATH).path(fileName).toUriString();
////			employee.setProfilePicPath(fileDownloadUri);
//			Designation designation = new Designation();
//			designation.setDesignationid(employeeDto.getDesignationid());
//			designation.setDesignationname(employeeDto.getDesignationname());
//			employee.setDesignation(designation);
//			employeeservice.saveEmployee(employee);
//			return new ResponseEntity<>(
//					new BasicResponse<>(RestApiResponseStatus.CREATED, ValidationMessages.EMPLOYEE_CREATED),
//					HttpStatus.OK);
//		}
//
//	}
//
////	/* Author:KiishanthS 17-06-2019 */
////	// List Employee
//	@GetMapping(value = "/getallemployee")
//	public List<Employee> sortListEmployeeInfo(Long empId) {
//		return employeeservice.findByEmployeeOrderByEmployeeIdDesc(empId);
//	}
////
////	/* Author:DalistaaA 17-06-2019 */
////	// Get Employee By Employee ID
////	@GetMapping("/getempolyeebyid/{empId}")
////	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(name = "empId") Long empId) {
////		try {
////			logger.info("Employee Controller :-> GetEmployeeById");
////			return new ResponseEntity<>(employeeDTOMapper.getById(empId), HttpStatus.OK);
////
////		} catch (Exception ex) {
////			logger.error("Employee Controller :->" + ex.getMessage());
////
////		}
////		return null;
////
////	}
////
////	/* Author:JothiM 17-06-2019 */
////	// Delete Employee Using Employee ID
////	@DeleteMapping("/deletebyid/{empId}")
////	public ResponseEntity<String> deleteEmployeeByempId(@PathVariable("empId") Long empId) {
////		try {
////			logger.info("Employee Controller :-> DeleteEmployeeById");
////			employeeDTOMapper.deleteByEmployeeId(empId);
////			return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
////		} catch (Exception ex) {
////			logger.error("Employee Controller :-> Error" + ex.getMessage());
////		}
////		return null;
////	}
////
////	/* Author:ThuvarakanT 17-06-2019 */
////	// Get Employee By Email
////	@GetMapping("/getemail/{email}")
////	public ResponseEntity<EmployeeDTO> getEmployeeByEmail(@PathVariable(name = "email") String email) {
////		try {
////			logger.info("Employee Controller:: -> GetEmail");
////			return new ResponseEntity<>(employeeDTOMapper.getByEmployeeEmailforMapper(email), HttpStatus.OK);
////		} catch (Exception ex) {
////			logger.error("Employee Controller:: -> Error" + ex.getMessage());
////		}
////		return null;
////	}
////
////	/* Author:RammiyaN 19-06-2019 */
////	// update Employee Using Employee ID
////	@PutMapping("update/{empId}")
////	public ResponseEntity<String> updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
////		try {
////			logger.info("Employee Controller :-> Update");
////			if (employeeDTOMapper.UpdateEmployee(employeeDTO) != null) {
////				return new ResponseEntity<>("Successfully Updated", HttpStatus.OK);
////			}
////			return new ResponseEntity<>("Failed To Update", HttpStatus.OK);
////		} catch (Exception ex) {
////			logger.error("Employee Controller :-> Error" + ex.getMessage());
////		}
////
////		return null;
////	}
////
////	/* Author:DalistaaA 19-06-2019 */
////	// Get Employee By Designation
////	@GetMapping("/getdesignation/{designationid}")
////	public List<EmployeeDTO> getByDesignation(@PathVariable(name = "designationid") Long designationid) {
////		try {
////			logger.info("Employee Controller :-> GetDesignation");
////			return employeeDTOMapper.getEmployeeByDesignation(designationid);
////		} catch (Exception ex) {
////			logger.error("Employee Controller :-> Error" + ex.getMessage());
////		}
////		return null;
////
////	}
////
////	/* Author:KeerthanaR 23-06-2019 */
////	// Get Employee By Name
////	@GetMapping("/getname/{name}")
////	public List<EmployeeDTO> getByName(@PathVariable(name = "name") String name) {
////		try {
////			logger.info("Employee Controller -> GetName");
////			return employeeDTOMapper.getEmployeeByName(name);
////		} catch (Exception ex) {
////			logger.error("Employee Controller -> error" + ex.getMessage());
////		}
////		return null;
////
////	}
////
////	@GetMapping("/getcount")
////// <----	Employee DataBase Employee Table Row Count Method --->
////	public ResponseEntity<Long> getTotalCount() {
////		try {
////			logger.info("Employee Controller :-> getCount");
////			return new ResponseEntity<>(employeeDTOMapper.getByEmployeeCountforMapper(), HttpStatus.OK);
////		} catch (Exception ex) {
////			logger.error("Employee Controller :-> Error" + ex.getMessage());
////		}
////		return null;
////
////	}
////
////	@PostMapping("/database")
//////	<----Import Excel File For Employee Service Employee Table---> 
////	public String uploadMultipartFile(@RequestParam("uploadfile") MultipartFile file, Model model) {
////		try {
////			System.out.println("controller");
////			employeeservice.store(file);
////			model.addAttribute("message", "File uploaded successfully!");
////		} catch (Exception e) {
////			model.addAttribute("message", "Fail! -> uploaded filename: " + file.getOriginalFilename());
////		}
////		return "File uploaded successfully";
////	}
////
////	@GetMapping("/getdevelopercount")
////	// <----	Employee DataBase Employee Table Row Count Method --->
////		public long getTotalDeveloperCount() {
////			try {
////				logger.info("Employee Controller :-> getCount");
////				long name=employeeRepository.findByDesignationName("Developer");
////				return employeeservice.countDeveloper(name);
////			} catch (Exception ex) {
////				logger.error("Employee Controller :-> Error" + ex.getMessage());
////			}
////			return (Long) null;
////
////		}
////
////
////	@GetMapping("/getTotalQaCount")
////	public long getTotalQaCount() {
////		try {
////			Long name = employeeRepository.findByDesignationName("QA");
////			return employeeservice.countDeveloper(name);
////		} catch (Exception e) {
////		}
////		return (Long) null;
////
////	}
////
////	@GetMapping("/getTotalPmCount")
////	public long getTotalPmCount() {
////		try {
////			Long name = employeeRepository.findByDesignationName("PM");
////			return employeeservice.countDeveloper(name);
////		} catch (Exception e) {
////		}
////		return (Long) null;
////
////	}
////	
////	@GetMapping("/getTotalHRCount")
////	public long getTotalHRCount() {
////		try {
////			Long name = employeeRepository.findByDesignationName("HR");
////			return employeeservice.countDeveloper(name);
////		} catch (Exception e) {
////		}
////		return (Long) null;
////
////	}
////	
////	@GetMapping("/getTotalTecLeadCount")
////	public long getTotalTecLeadCount() {
////		try {
////			Long name = employeeRepository.findByDesignationName("TecLead");
////			return employeeservice.countDeveloper(name);
////		} catch (Exception e) {
////		}
////		return (Long) null;
////
////	}
////	
////	@GetMapping("/getTotalQALeadCount")
////	public long getTotalQALeadCount() {
////		try {
////			Long name = employeeRepository.findByDesignationName("QALead");
////			return employeeservice.countDeveloper(name);
////		} catch (Exception e) {
////		}
////		return (Long) null;
////
////	}
//
//	@RequestMapping(value = AppConstants.DOWNLOAD_URI, method = RequestMethod.GET)
//	public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
//		Resource resource = fileStorageService.loadFileAsResource(fileName);
//		String contentType = null;
//		try {
//			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
//		} catch (IOException ex) {
//			ex.printStackTrace();
//		}
//		if (contentType == null) {
//			contentType = AppConstants.DEFAULT_CONTENT_TYPE;
//		}
//		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
//				.header(HttpHeaders.CONTENT_DISPOSITION,
//						String.format(AppConstants.FILE_DOWNLOAD_HTTP_HEADER, resource.getFilename()))
//				.body(resource);
//	}
//
////// <--------     update bench when allocate resource     ---->
////	@RequestMapping(value = "update/benchtrue/{empId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
////	public ResponseEntity<String> updateBenchTrue(@RequestBody EmployeeDTO employeeDTO,
////			@PathVariable("empId") Long empId) {
////		try {
////			logger.info("Employee Controller :-> Update");
////			// employeeDTOMapper.UpdateBenchTrue(empId,employeeDTO);
////			if (employeeDTOMapper.UpdateBenchTrue(empId, employeeDTO) != null) {
////				return new ResponseEntity<>("Successfully Updated", HttpStatus.OK);
////			}
////			return new ResponseEntity<>("Failed To Update", HttpStatus.OK);
////		} catch (Exception ex) {
////			logger.error("Employee Controller :-> Error" + ex.getMessage());
////		}
////
////		return null;
////	}
////
////// <-------       update bench when deallocate resource      ------>
////	@RequestMapping(value = "update/benchfalse/{empId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
////	public ResponseEntity<String> updateBenchFalse(@RequestBody EmployeeDTO employeeDTO,
////			@PathVariable("empId") Long empId) {
////		try {
////			logger.info("Employee Controller :-> Update");
//////		employeeDTOMapper.UpdateBenchFalse(empId,employeeDTO);
////			if (employeeDTOMapper.UpdateBenchFalse(empId, employeeDTO) != null) {
////				return new ResponseEntity<>("Successfully Updated", HttpStatus.OK);
////			}
////			return new ResponseEntity<>("Failed To Update", HttpStatus.OK);
////		} catch (Exception ex) {
////			logger.error("Employee Controller :-> Error" + ex.getMessage());
////		}
////
////		return null;
////	}
////
////	
////// <-------       update availability when allocate the resource      ------>
////	@RequestMapping(value = "update/availability/{empId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
////	public ResponseEntity<String> updateAvailability(@RequestBody EmployeeDTO employeeDTO,
////			@PathVariable("empId") Long empId) {
////
////		try {
////			logger.info("Employee Controller :-> Update Availability");
////			int availablenow = employeeDTO.getAvailability();
////			System.out.println("availablenow" +availablenow);
////			employeeRepository.updateAvailability(availablenow,empId);
////
//////			if (employeeDTOMapper.UpdateAvailaibility(empId, employeeDTO) != null) {
//////				return new ResponseEntity<>("Successfully Updated Availability", HttpStatus.OK);
//////			}
//////			return new ResponseEntity<>("Failed To Update", HttpStatus.OK);
////		} catch (Exception ex) {
////			logger.error("Employee Controller :-> Error" + ex.getMessage());
////		}
////
////		return null;
////	}
//}
