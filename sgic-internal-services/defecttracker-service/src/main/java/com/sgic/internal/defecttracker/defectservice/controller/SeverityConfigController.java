//package com.sgic.internal.defecttracker.defectservice.controller;
//
//import java.util.List;
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
//import com.sgic.internal.defecttracker.defectservice.controller.dto.SeverityConfigDto;
//import com.sgic.internal.defecttracker.defectservice.controller.dto.mapper.SeverityConfigDtoMapper;
//import com.sgic.internal.defecttracker.defectservice.entities.SeverityConfig;
//import com.sgic.internal.defecttracker.defectservice.repositories.SeverityConfigRepository;
//import com.sgic.internal.defecttracker.defectservice.services.SeverityConfigService;
//
//@CrossOrigin
//@RestController
//public class SeverityConfigController {
//	
//	private static Logger logger = LogManager.getLogger(SeverityConfigRepository.class);
//	
//	@Autowired
//	public SeverityConfigService severityConfigService;
//
//	@Autowired
//	public SeverityConfigDtoMapper severityConfigDtoMapper;
//
//	
//	// Post Mapping For Create a SeverityConfig
//	@PostMapping(value = "/severityConfig")
//    public SeverityConfig createSeverityConfig(@RequestBody SeverityConfigDto severityConfigDto) {
//		return severityConfigDtoMapper.createSeverityConfig(severityConfigDto);
//	}
//	
//	// Get Mapping for SeverityConfigAll
//	@GetMapping(value = "/severityConfigs")
//	public ResponseEntity<List<SeverityConfigDto>> listSeverityConfigInfo() {
//		logger.info("SeverityConfig are listed ");
//		return new ResponseEntity<>(severityConfigDtoMapper.getAllSeverityConfig(), HttpStatus.OK);
//
//	}
//
//	// Get Mapping For Get SeverityConfig By Id
//	@GetMapping("/severityConfig/{severityId}")
//	public ResponseEntity<SeverityConfigDto> getSeverityConfigById(@PathVariable(name="severityId") Long severityId) {
//		logger.info("SeverityConfig get by Id ");
//		return new ResponseEntity<>(severityConfigDtoMapper.getBySeverityConfigId(severityId), HttpStatus.OK);
//	}
//
//	// Delete Mapping For SeverityConfig
//	@DeleteMapping("severityConfig/{severityId}")
//	public void  deleteSeverityConfigById(@PathVariable Long severityId) {
//		logger.info("SeverityConfig are delete by Id ");
//		severityConfigDtoMapper.deleteSeverityConfigById(severityId);
//	}
//
//
//	// Put Mapping For SeverityConfig
//	@PutMapping("/severityConfig/{severityId}")
//	public ResponseEntity<String> updateSeverityConfig(@PathVariable(name = "severityId") Long severityId,
//			@RequestBody SeverityConfigDto severityConfigDto) {
//		logger.info("SeverityConfigController -> updatedSeverityConfig");
//		if (severityConfigDtoMapper.updateSeverityConfig(severityId, severityConfigDto) != null)
//			;
//		{
//			return new ResponseEntity<>("ok", HttpStatus.OK);
//		}
//	}
//
//
//}
