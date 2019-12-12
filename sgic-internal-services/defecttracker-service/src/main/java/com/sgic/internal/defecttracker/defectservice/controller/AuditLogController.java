//package com.sgic.internal.defecttracker.defectservice.controller;
//
//import java.util.List;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.eureka.common.api.enums.RestApiResponseStatus;
//import com.eureka.common.api.response.ApiResponse;
//import com.sgic.internal.defecttracker.defectservice.controller.dto.AuditLogData;
//import com.sgic.internal.defecttracker.defectservice.controller.dto.mapper.AuditLogMapper;
//import com.sgic.internal.defecttracker.defectservice.entities.AuditLog;
//import com.sgic.internal.defecttracker.defectservice.services.impl.AuditLogServiceImpl;
//
//@CrossOrigin
//@RestController
//public class AuditLogController {
//
//	private static final Logger LOG = LoggerFactory.getLogger(AuditLogServiceImpl.class);
//
//	@Autowired
//	private AuditLogMapper auditLogMapper;
//
//	//create audits logs for defects
//	@PostMapping(value = "/audit")
//	public ResponseEntity<Object> createAuditLog(@RequestBody AuditLogData auditLogData) {
//		LOG.info("starting creating auditLog");
//		auditLogMapper.createAuditLog(auditLogData);
//		LOG.info("Audit saved");
//
//		return new ResponseEntity<>(new ApiResponse(RestApiResponseStatus.OK), HttpStatus.OK);
//	}
//
//	//get all audit logs by defect id
//	@GetMapping(value = "/auditLog/{defectId}")
//	public List<AuditLog> getListAuditLog(@PathVariable Long defectId) {
//
//		LOG.info("auditlog getting");
//		return auditLogMapper.getAuditLogById(defectId);
//	}
//
//	//get all audit logs 
//	@GetMapping(value = "/auditLogAll")
//	public List<AuditLogData> getAllAudits() {
//
//		LOG.info("auditlog getting by id");
//		return auditLogMapper.getAllById();
//
//	}
//
//}