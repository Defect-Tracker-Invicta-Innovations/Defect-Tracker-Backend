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
//import com.sgic.internal.defecttracker.defectservice.controller.dto.StatusConfigDto;
//import com.sgic.internal.defecttracker.defectservice.controller.dto.mapper.StatusConfigDtoMapper;
//import com.sgic.internal.defecttracker.defectservice.entities.StatusConfig;
//import com.sgic.internal.defecttracker.defectservice.repositories.StatusConfigRepository;
//import com.sgic.internal.defecttracker.defectservice.services.StatusConfigService;
//
//@CrossOrigin
//@RestController
//public class StatusConfigController {
//	
//	private static Logger logger = LogManager.getLogger(StatusConfigRepository.class);
//	
//	@Autowired
//	public StatusConfigService statusConfigService;
//
//	@Autowired
//	public StatusConfigDtoMapper statusConfigDtoMapper;
//
//	
//	// Post Mapping For Create a StatusConfig
//	@PostMapping(value = "/statusConfig")
//    public StatusConfig createStatusConfig(@RequestBody StatusConfigDto statusConfigDto) {
//		logger.info("StatusConfig are Created ");
//		return statusConfigDtoMapper.createStatusConfig(statusConfigDto);
//	}
//	
//	// Get Mapping for StatusConfigAll
//	@GetMapping(value = "/statusConfigs")
//	public ResponseEntity<List<StatusConfigDto>> listStatusConfigInfo() {
//		logger.info("StatusConfig are listed ");
//		return new ResponseEntity<>(statusConfigDtoMapper.getAllStatusConfig(), HttpStatus.OK);
//
//	}
//
//	// Get Mapping For Get StatusConfig By Id
//	@GetMapping("/statusConfig/{statusId}")
//	public ResponseEntity<StatusConfigDto> getStatusConfigById(@PathVariable(name="statusId") Long statusId) {
//		logger.info("StatusConfig get by Id ");
//		return new ResponseEntity<>(statusConfigDtoMapper.getByStatusConfigId(statusId), HttpStatus.OK);
//	}
//
//	// Delete Mapping For StatusConfig
//	@DeleteMapping("statusConfig/{statusId}")
//	public void  deleteStatusConfigById(@PathVariable Long statusId) {
//		logger.info("StatusConfig are delete by Id ");
//		statusConfigDtoMapper.deleteStatusConfigById(statusId);
//	}
//
//
//	// Put Mapping For StatusConfig
//	@PutMapping("/statusConfig/{statusId}")
//	public ResponseEntity<String> updateStatusConfig(@PathVariable(name = "statusId") Long statusId,
//			@RequestBody StatusConfigDto statusConfigDto) {
//		logger.info("StatusConfigController -> updatedStatusConfig");
//		if (statusConfigDtoMapper.updateStatusConfig(statusId, statusConfigDto) != null)
//			;
//		{
//			return new ResponseEntity<>("ok", HttpStatus.OK);
//		}
//	}
//
//
//}
