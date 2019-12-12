package com.sgic.internal.defecttracker.defectservice.services.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sgic.internal.defecttracker.defectservice.entities.Defect;
import com.sgic.internal.defecttracker.defectservice.repositories.DefectRepository;
import com.sgic.internal.defecttracker.defectservice.services.DefectService;

@Service
public class DefectServiceImpl implements DefectService {
	@Autowired
	private DefectRepository defectRepository;
	
	private static Logger logger = LogManager.getLogger(DefectRepository.class);

	//create defects
	@Override
	public Defect createDefect(Defect defect) {
	    logger.info("DefectService started -> SaveAllDefects");
		return defectRepository.save(defect);
	}

	//get defects by id
	@Override
	public Defect getByDefectId(Long defectId) {
		logger.info("DefectService started -> GetAllDefectById");
		return defectRepository.getByDefectId(defectId);
	}
	
	//update defects
	@Override
	public Defect updateDefect(Defect defect) {
	
		logger.info("DefectService started -> updateDefect");
		Long defectId=defect.getDefectId();
		logger.info("DefectService started -> getDefectId");
		boolean isExist = defectRepository.getByDefectId(defectId)!= null;
		if (isExist) {
			logger.info("DefectService started -> Updateed By DefectId");
			return defectRepository.save(defect);
		} else {
			logger.info("DefectService started -> DefectId Not Found");
		}
		return null;
	}
	
	//delete defects
	@Override
	public Defect deleteDefect(Long defectId) {
	     logger.info("DefectService started -> DeleteDefectById");
		 defectRepository.deleteById(defectId);
		 return null;
	}

	//get all defects
	@Override
	public List<Defect> getAllDefects() {
	    logger.info("DefectService started -> ListAllDefects");
		return defectRepository.findAll() ;
	}

	//get all defects by particular project id
	@Override
	public List<Defect> getProjectById(String projectId) {
		logger.info("DefectService started -> getProjectById");
		return defectRepository.getByProjectId(projectId);
	}

	//get all defects by particular module id
	@Override
	public List<Defect> getModuleById(String moduleId) {
		logger.info("DefectService started -> getModuleById");
		return defectRepository.getByModuleId(moduleId);
	}

	//check whether the defect is already exists or not
	@Override
	public boolean isDefectAlreadyExist(Long defectId) {
		logger.info("DefectService started -> isDefectAlreadyExist");
		return defectRepository.existsById(defectId);
	}

	//get all defects by on particular date
	@Override
	public List<Defect> getDefectByDate(Date dateAndTime) {
		logger.info("DefectService started -> getDefectByDate");
		return defectRepository.getByDefectDate(dateAndTime);
	}

	//get all available defects
	@Override
	public List<Defect> getDefectByAvailableIn(String availableIn) {
		logger.info("DefectService started -> getDefectByAvailableIn");
		return defectRepository.getByAvailableIn(availableIn);
	}

	//get all found in defects
	@Override
	public List<Defect> getDefectByFoundIn(String foundIn) {
		logger.info("DefectService started -> getDefectByFoundIn");
		return defectRepository.getByFoundIn(foundIn);
	}

	//get all fixed in defects
	@Override
	public List<Defect> getDefectByFixedIn(String fixedIn) {
		logger.info("DefectService started -> getDefectByfixedIn");
		return defectRepository.getByFixedIn(fixedIn);
	}

	//get all defects by status
	@Override
	public List<Defect> getDefectByStatus(String status) {
		logger.info("DefectService started -> getDefectByStatus");
		return defectRepository.getByStatus(status);
	}

	//get all defects by priority
	@Override
	public List<Defect> getDefectByPriority(String priority) {
		logger.info("DefectService started -> getDefectByPriority");
		return defectRepository.getByPriority(priority);
	}

	//get all defects by severity
	@Override
	public List<Defect> getDefectBySeverity(String severity) {
		logger.info("DefectService started -> getDefectBySeverity");
		return defectRepository.getBySeverity(severity);
	}

	//get all defects by type
	@Override
	public List<Defect> getDefectByType(String type) {
		logger.info("DefectService started -> getDefectByType");
		return defectRepository.getByType(type);
	}

	//defect remarkable defects
	@Override
	public Long countDefect() {
		Long totCount = defectRepository.count();
		System.out.println("total count " +totCount);
		Long totRejCount = defectRepository.countByStatus("rejected", null);
		System.out.println("rejected count " +totRejCount);
		Long ratio =(( totCount-totRejCount)*100)/totCount;
		System.out.println("ratio " +ratio);
		return ratio;
	}

	//count defect density
	@Override
	public double countDefectDensity() {
		
		double kloc= 5000;
		double defectCount=defectRepository.count();
		System.out.println("Total count :"+defectCount);
		double defectDen=defectCount *(1000/kloc);
		System.out.println("Ratio :"+defectDen);
		return defectDen;
	}

	//Hari matrix
	@Override
	public Long getStatusNew( String status,String projectId) {
		Long totNew = defectRepository.countByStatus(status,  projectId);
		return totNew;
	}

	@Override
	public Long getStatusOpen(String status,String projectId) {
		Long totOpen = defectRepository.countByStatus(status,  projectId);
		return totOpen;
	}

	@Override
	public Long getStatusClose(String status,String projectId) {
		Long totClose= defectRepository.countByStatus(status,  projectId);
		return totClose;
	}

	@Override
	public Long getStatusRejected(String status,String projectId) {
		Long totRej= defectRepository.countByStatus(status,  projectId);
		return totRej;
	}

	@Override
	public Long getStatusDefered(String status,String projectId) {
		Long totDefered= defectRepository.countByStatus(status,  projectId);
		return totDefered;
	}

	@Override
	public Long getStatusReOpen(String status,String projectId) {
		Long totReOpen= defectRepository.countByStatus(status,  projectId);
		return totReOpen;
	}

	@Override
	public Long getStatusFixed(String status,String projectId) {
		Long totFixed= defectRepository.countByStatus(status,  projectId);
		return totFixed;
	}

	@Override
	public long countTotalDefect() {
		Long totCount = defectRepository.count();
		System.out.println("total count " + totCount);
		Long totRejCount = defectRepository.countByStatus("rejected", null);
		System.out.println("rejected count " + totRejCount);
		Long TotalCount = (totCount - totRejCount);

		return TotalCount;
	}

	@Override
	public List<Defect> getByDefectAbbre(String defectAbbr) {
		return defectRepository.getByDefectAbbr(defectAbbr);
	}

	
}
