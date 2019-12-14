package com.sgic.internal.product.services.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sgic.internal.product.entities.DefectType;
import com.sgic.internal.product.repositories.DefectTypeRepository;
import com.sgic.internal.product.services.DefectTypeService;

@Service
public class DefectTypeServiceImpl implements DefectTypeService{

	@Autowired
	private DefectTypeRepository defectTypeRepository;
	
	@SuppressWarnings("unused")
	private static Logger logger = LogManager.getLogger(DefectTypeServiceImpl.class);

	public static<T> List<T> reverseList(List<T> list)
	{
		List<T> reverse = new ArrayList<>(list);
		Collections.reverse(reverse);
		return reverse;
	}
	
	// Create defect type service implementation
	@Override
	public DefectType createDefectType(DefectType defectType) {
		try {
			logger.debug("Defect Type Service Implementation --> createDefectType()");
			return defectTypeRepository.save(defectType);
		} catch (Exception e) {
			logger.info("Defect Type Service Implementation --> createDefectType()", e.getMessage());
		}
		return null;
	}

	// Defect type exists implementation
	@Override
	@Transactional(readOnly = true)
	public boolean isDefectTypeAlreadyExists(String defectType) {
		try {
			logger.debug("Defect Type Service Implementation --> isDefectTypeAlreadyExists()");
			return defectTypeRepository.existsByDefectType(defectType);
		} catch (Exception e) {
			logger.info("Defect Type Service Implementation --> isDefectTypeAlreadyExists()", e.getMessage());
		}
		return true;
	}

	// List all defect types implementation
	@Override
	public List<DefectType> findAllDefectType() {
		try {
			logger.debug("Defect Type Service Implementation --> findAllDefectType()");
			List<DefectType> defectTypes = defectTypeRepository.findAll();
			return reverseList(defectTypes);
		} catch (Exception e) {
			logger.info("Defect Type Service Implementation --> findAllDefectType()", e.getMessage());
		}
		return null;
	}

	// Delete defect type implementation
	@Override
	public Boolean deleteDefectTypeById(long id) {
		try {
			logger.debug("Defect Type Service Implementation --> deleteDefectTypeById()");
			defectTypeRepository.deleteById(id);
		} catch (Exception e) {
			logger.info("Defect Type Service Implementation --> deleteDefectTypeById()", e.getMessage());
		}
		return true;		
	}

	// Find defect type by id implementation
	@Override
	public DefectType findDefectTypeById(long id) {
		try {
			logger.debug("Defect Type Service Implementation --> findDefectTypeById()");
			return defectTypeRepository.findById(id).orElse(null);
		} catch (Exception e) {
			logger.info("Defect Type Service Implementation --> findDefectTypeById()", e.getMessage());
		}
		return null;
	}

	@Override
	public int getDefectTypeCount() {
		try {
			logger.debug("Defect Type Service Implementation --> getDefectTypeCount()");
			return (int) defectTypeRepository.count();
		} catch (Exception e) {
			logger.info("Defect Type Service Implementation --> getDefectTypeCount()", e.getMessage());
		}
		return 1;
		
		
	}

}
