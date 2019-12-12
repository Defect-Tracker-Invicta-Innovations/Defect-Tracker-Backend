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
//import com.sgic.internal.defecttracker.defectservice.controller.dto.PriorityConfigDto;
//import com.sgic.internal.defecttracker.defectservice.controller.dto.mapper.PriorityConfigDtoMapper;
//import com.sgic.internal.defecttracker.defectservice.entities.PriorityConfig;
//import com.sgic.internal.defecttracker.defectservice.repositories.SubModuleRepository;
//import com.sgic.internal.defecttracker.defectservice.services.PriorityConfigService;
//
//@CrossOrigin
//@RestController
//public class PriorityConfigController {
//	
//	private static Logger logger = LogManager.getLogger(SubModuleRepository.class);
//	
//	@Autowired
//	public PriorityConfigService priorityConfigService;
//
//	@Autowired
//	public PriorityConfigDtoMapper priorityConfigDtoMapper;
//
//	
//	// Post Mapping For Create a PriorityConfig
//	@PostMapping(value = "/priorityConfig")
//    public PriorityConfig createPriorityConfig(@RequestBody PriorityConfigDto priorityConfigDto) {
////		System.out.println(priorityConfigDto.getPriorityList()+priorityConfigDto.getPriorityId()+priorityConfigDto.);
//		return priorityConfigDtoMapper.createPriorityConfig(priorityConfigDto);
//	}
//	
//	// Get Mapping for PriorityConfigAll
//	@GetMapping(value = "/priorityConfigs")
//	public ResponseEntity<List<PriorityConfigDto>> listPriorityConfigInfo() {
//		logger.info("PriorityConfig are listed ");
//		return new ResponseEntity<>(priorityConfigDtoMapper.getAllPriorityConfig(), HttpStatus.OK);
//
//	}
//
//	// Get Mapping For Get PriorityConfig By Id
//	@GetMapping("/priorityConfig/{priorityId}")
//	public ResponseEntity<PriorityConfigDto> getPriorityConfigById(@PathVariable(name="priorityId") Long priorityId) {
//		logger.info("PriorityConfig get by Id ");
//		return new ResponseEntity<>(priorityConfigDtoMapper.getByPriorityConfigId(priorityId), HttpStatus.OK);
//	}
//
//	// Delete Mapping For PriorityConfig
//	@DeleteMapping("priorityConfig/{priorityId}")
//	public void  deletePriorityConfigById(@PathVariable Long priorityId) {
//		logger.info("PriorityConfig are delete by Id ");
//		priorityConfigDtoMapper.deletePriorityConfigById(priorityId);
//	}
//
//
//	// Put Mapping For PriorityConfig
//	@PutMapping("/priorityConfig/{priorityId}")
//	public ResponseEntity<String> updatePriorityConfig(@PathVariable(name = "priorityId") Long priorityId,
//			@RequestBody PriorityConfigDto priorityConfigDto) {
//		logger.info("PriorityConfigcontroller -> updatedPriorityConfig");
//		if (priorityConfigDtoMapper.updatePriorityConfig(priorityId, priorityConfigDto) != null);
//		{
//			return new ResponseEntity<>("ok", HttpStatus.OK);
//		}
//	}
//
//}
