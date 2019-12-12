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
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.eureka.common.api.enums.RestApiResponseStatus;
//import com.eureka.common.api.response.ApiResponse;
//import com.sgic.internal.defecttracker.defectservice.controller.dto.ReleaseDto;
//import com.sgic.internal.defecttracker.defectservice.controller.dto.mapper.ReleaseDtoMapper;
//import com.sgic.internal.defecttracker.defectservice.entities.Release;
//import com.sgic.internal.defecttracker.defectservice.repositories.ProjectRepository;
//import com.sgic.internal.defecttracker.defectservice.services.ReleaseService;
//
//@CrossOrigin(origins = "*", allowedHeaders = "*") // <-- Integration With FrondEnd (React)-->
//@RestController
//public class ReleaseControler {
//	
//	private static Logger logger = LogManager.getLogger(ProjectRepository.class);
//
//	@Autowired
//	private ReleaseDtoMapper releaseDtoMapper;
//	
//	@Autowired 
//	private ReleaseService releaseService;
//	
//	// Post Mapping For Create a Project
//	@PostMapping("/release")
//	public ResponseEntity<Object> createRelease(@Valid @RequestBody ReleaseDto releaseDto) {
//		releaseDtoMapper.saveRelease(releaseDto);
//		logger.info("Release created");
//		return new ResponseEntity<>(new ApiResponse(RestApiResponseStatus.OK), HttpStatus.OK);
//	}
//	
//	// Get All Details in Release Table
//	@GetMapping("/releases")
//	public List<Release> getAllRelease(Release release) {
//		List<Release> releases  = (List<Release>) releaseService.getAllRelease();
//		return releases;
//	}
//
//
//}
