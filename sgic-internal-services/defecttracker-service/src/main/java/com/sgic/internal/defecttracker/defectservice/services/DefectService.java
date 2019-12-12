package com.sgic.internal.defecttracker.defectservice.services;


import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defectservice.entities.Defect;

@Service
public interface DefectService {

	public Defect createDefect(Defect defect);   
	public Defect getByDefectId(Long defectId);
	public List<Defect> getByDefectAbbre(String defectAbbr);
	public Defect updateDefect(Defect defect);
	public Defect deleteDefect(Long defectId);   
	public List<Defect> getAllDefects(); 
	
	public List<Defect> getProjectById (String projectId); 
	public List<Defect> getModuleById (String moduleId); 
	public List<Defect> getDefectByAvailableIn (String availableIn);
	public List<Defect> getDefectByFoundIn (String foundIn);
	public List<Defect> getDefectByFixedIn (String fixedIn);
	
	public List<Defect> getDefectByDate (Date dateAndTime);
	public boolean isDefectAlreadyExist(Long defectId);
	public List<Defect> getDefectByStatus(String status); 
	public List<Defect> getDefectByPriority(String priority);
	public List<Defect> getDefectBySeverity(String severity);
	public List<Defect> getDefectByType(String type);
	
	public Long countDefect();
	public double countDefectDensity();
	public long countTotalDefect();
	
	 //Hari
	public Long getStatusNew( String projectId,String status); 
	public Long getStatusOpen(String projectId,String status);
	public Long getStatusClose(String projectId,String status);
	public Long getStatusRejected(String projectId,String status);
	public Long getStatusDefered(String projectId,String status);
	public Long getStatusReOpen(String projectId,String status);
	public Long getStatusFixed(String projectId,String status);
	     	
}
