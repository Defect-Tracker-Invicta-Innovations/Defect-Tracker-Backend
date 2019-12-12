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
//import com.sgic.internal.defecttracker.defectservice.controller.dto.TypeConfigDto;
//import com.sgic.internal.defecttracker.defectservice.controller.dto.mapper.TypeConfigDtoMapper;
//import com.sgic.internal.defecttracker.defectservice.entities.TypeConfig;
//import com.sgic.internal.defecttracker.defectservice.repositories.TypeConfigRepository;
//import com.sgic.internal.defecttracker.defectservice.services.TypeConfigService;
//
//@CrossOrigin
//@RestController
//public class TypeConfigController {
//	
//	private static Logger logger = LogManager.getLogger(TypeConfigRepository.class);
//	
//	@Autowired
//	public TypeConfigService typeConfigService;
//
//	@Autowired
//	public TypeConfigDtoMapper typeConfigDtoMapper;
//
//	
//	// Post Mapping For Create a TypeConfig
//	@PostMapping(value = "/typeConfig")
//    public TypeConfig createTypeConfig(@RequestBody TypeConfigDto typeConfigDto) {
//		return typeConfigDtoMapper.createTypeConfig(typeConfigDto);
//	}
//	
//	// Get Mapping for TypeConfigAll
//	@GetMapping(value = "/typeConfigs")
//	public ResponseEntity<List<TypeConfigDto>> listTypeConfigInfo() {
//		logger.info("TypeConfig are listed ");
//		return new ResponseEntity<>(typeConfigDtoMapper.getAlltypeConfig(), HttpStatus.OK);
//
//	}
//
//	// Get Mapping For Get PriorityConfig By Id
//	@GetMapping("/typeConfig/{typeId}")
//	public ResponseEntity<TypeConfigDto> getTypeConfigById(@PathVariable(name="typeId") Long typeId) {
//		logger.info("TypeConfig get by Id ");
//		return new ResponseEntity<>(typeConfigDtoMapper.getBytypeConfigId(typeId), HttpStatus.OK);
//	}
//
//	// Delete Mapping For TypeConfig
//	@DeleteMapping("typeConfig/{typeId}")
//	public void  deleteTypeConfigById(@PathVariable Long typeId) {
//		logger.info("TypeConfig are delete by Id ");
//		typeConfigDtoMapper.deleteTypeConfigById(typeId);
//	}
//
//
//	// Put Mapping For TypeConfig
//	@PutMapping("/typeConfig/{typeId}")
//	public ResponseEntity<String> updateTypeConfig(@PathVariable(name = "typeId") Long typeId,
//			@RequestBody TypeConfigDto typeConfigDto) {
//		logger.info("TypeConfigController -> updatedPriorityConfig");
//		if (typeConfigDtoMapper.updatetypeConfig(typeId, typeConfigDto) != null)
//			;
//		{
//			return new ResponseEntity<>("ok", HttpStatus.OK);
//		}
//	}
//
//
//}
