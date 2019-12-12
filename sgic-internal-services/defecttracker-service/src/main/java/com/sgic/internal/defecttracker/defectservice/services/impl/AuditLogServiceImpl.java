package com.sgic.internal.defecttracker.defectservice.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defectservice.entities.AuditLog;
import com.sgic.internal.defecttracker.defectservice.repositories.AuditLogRepository;
import com.sgic.internal.defecttracker.defectservice.services.AuditLogService;

@Service
public class AuditLogServiceImpl implements AuditLogService{

	@Autowired
	private AuditLogRepository auditLogRepository;
	
	//create audits logs for defects
	@Override
	public AuditLog createAuditLog(AuditLog auditLog) {
		AuditLog responseAuditLog = auditLogRepository.save(auditLog);
		return responseAuditLog;
	}

	//get all audit logs by defect id
	@Override
	public List<AuditLog> getAuditLogById(Long defectId) {
		return auditLogRepository.findAudilLogByDefectId(defectId);
	}

	//get all audit logs 
	@Override
	public List<AuditLog> getAllAuditLogs() {
		return auditLogRepository.findAll();
	}

	
}