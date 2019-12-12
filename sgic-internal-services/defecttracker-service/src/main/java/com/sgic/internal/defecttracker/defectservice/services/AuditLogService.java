package com.sgic.internal.defecttracker.defectservice.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defectservice.entities.AuditLog;

@Service
public interface AuditLogService {
	
	public AuditLog createAuditLog(AuditLog auditLog);
	public List<AuditLog> getAuditLogById(Long defectId);
	public List<AuditLog> getAllAuditLogs();

}