//package com.sgic.internal.defecttracker.defectservice.controller;
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
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.eureka.common.api.enums.RestApiResponseStatus;
//import com.eureka.common.api.response.ApiResponse;
//import com.sgic.internal.defecttracker.defectservice.controller.dto.ProjectDto;
//import com.sgic.internal.defecttracker.defectservice.controller.dto.mapper.ProjectDtoMapper;
//import com.sgic.internal.defecttracker.defectservice.repositories.ProjectRepository;
//import com.sgic.internal.defecttracker.defectservice.services.ProjectService;
//
//@CrossOrigin(origins = "*", allowedHeaders = "*")
//@RestController
//public class ProjectController {
//
//
//	private static Logger logger = LogManager.getLogger(ProjectRepository.class);
//
//	@Autowired
//	public ProjectDtoMapper projectDtoMapper;
//	
//	@Autowired 
//	private ProjectService projectService;
//	
//	// Post Mapping For Create a Project
//	@PostMapping(value = "/createproject")
//	public ResponseEntity<Object> createProject(@Valid @RequestBody ProjectDto projectDto) {
//		
//		if (projectDtoMapper.getByProjectId(projectDto.getProjectId()) != null) {
////			logger.info("Successfully Saved");
//		} else {
//			projectDtoMapper.saveProjectforMapper(projectDto);
//			logger.info("Project created");
//		}	
//		return new ResponseEntity<>(new ApiResponse(RestApiResponseStatus.OK), HttpStatus.OK);
//	}
//
//	// Get Mapping For Get all Project
//	@GetMapping(value = "/GetAllproject")
//	public ResponseEntity<List<ProjectDto>> listprojectInfo() {
//		logger.info("Project are listed ");
//		return new ResponseEntity<>(projectDtoMapper.getAllProjectForMapper(), HttpStatus.OK);
//	}
//
//	// Get Mapping For Get Project By Id
//	@GetMapping("/getProjectById/{projectId}")
//	public ResponseEntity<ProjectDto> getProjectById(@PathVariable String projectId) {
//		logger.info("Projects are get by id ");
//		return new ResponseEntity<>(projectDtoMapper.getByProjectId(projectId), HttpStatus.OK);
//	}
//	
//	// Delete Mapping For Project
//	@DeleteMapping("deleteById/{projectId}")
//	public void deleteById(@PathVariable String projectId) {
//		logger.info("Projects are delete by id ");
//		projectDtoMapper.deleteById(projectId);
//	}
//	
//	// Put Mapping For Project
//	@PutMapping("/updateProject/{projectid}")
//	public ResponseEntity<String> updateProject(@Valid @PathVariable(name = "projectid") String projectid,
//			@RequestBody ProjectDto projectDto) {
//		logger.info("Projectcontroller -> updatedproject");
//		if (projectDtoMapper.UpdateProject(projectid, projectDto) != null)
//			;
//		{
//			return new ResponseEntity<>("ok", HttpStatus.OK);
//		}
//	}
//
//	// Get Mapping For Project Name
//	@GetMapping("/getName/{name}")
//	public List<ProjectDto> getByprojectName(@PathVariable String name) {
//		logger.info("Projects are get by name ");
//		return projectDtoMapper.getByprojectNameForMapper(name);
//	}
//
//	// Get Mapping For Project Type 
//	@GetMapping("/gettype/{type}")
//	public List<ProjectDto> getBytype(@PathVariable String type) {
//		logger.info("Projects are get by type");
//		return projectDtoMapper.getByProjecttype(type);
//	}
//
//	// Get Mapping For Project Start Date
//	@GetMapping("/getDate/{date}")
//	public List<ProjectDto> getBystartDate(@PathVariable String date) {
//		logger.info("Projects are get by date ");
//		return projectDtoMapper.getBystartDateformapper(date);
//
//	}
//
//	// Get Mapping For Project duration
//	@GetMapping("/getduration/{duration}")
//	public List<ProjectDto> getByduration(@PathVariable Long duration) {
//		logger.info("Projects are get by duration");
//		return projectDtoMapper.getBydurationformapper(duration);
//	}
//
//	// Get Mapping For Project Status
//	@GetMapping("/getstatus/{status}")
//	public List<ProjectDto> getBystatus(@PathVariable String status) {
//		logger.info("Projects are get by status");
//		return projectDtoMapper.getBystatusformapper(status);
//	}
//	
//	@GetMapping("/countproject")
//	public ResponseEntity<Long> getAllProjectCount(){
//		return new ResponseEntity<>(projectService.countProject(),HttpStatus.OK);
//	}
//	
//	// Get Mapping For Get all Project
//		@GetMapping(value = "/getallproject")
//		public ResponseEntity<List<ProjectDto>> sortListProjectInfo(String projectId) {
//			logger.info("Project are listed ");
//			return new ResponseEntity<>(projectDtoMapper.getAllSortProjectInfo(projectId), HttpStatus.OK);
//		}
//}
