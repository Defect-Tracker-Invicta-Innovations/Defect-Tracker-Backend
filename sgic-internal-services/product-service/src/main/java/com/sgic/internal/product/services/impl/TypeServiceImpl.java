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
import com.sgic.internal.product.repositories.TypeRepo;
import com.sgic.internal.product.services.TypeService;

@Service
public class TypeServiceImpl implements TypeService{

	@Autowired
	private TypeRepo typeRepo;
	
	@SuppressWarnings("unused")
	private static Logger logger = LogManager.getLogger(TypeServiceImpl.class);

	public static<T> List<T> reverseList(List<T> list)
	{
		List<T> reverse = new ArrayList<>(list);
		Collections.reverse(reverse);
		return reverse;
	}
	
	// Create defect type service implementation
	@Override
	public Object createDefectType(DefectType defectType) {
		//logger.info("Create Defect Type Service Implementation");
		return typeRepo.save(defectType);
	}

	// Defect type exists implementation
	@Override
	@Transactional(readOnly = true)
	public boolean isDefectTypeAlreadyExists(Long id) {
		//logger.info("Defect Type Exists Service Implementation");
		return typeRepo.existsById(id);
	}

	// List all defect types implementation
	@Override
	public List<DefectType> findAllDefectType() {
		List<DefectType> defectTypes = typeRepo.findAll();
		//logger.info("List All Defect Types Service Implementation");
		return reverseList(defectTypes);
	}

	// Delete defect type implementation
	@Override
	public Boolean deleteDefectTypeById(long id) {
		typeRepo.deleteById(id);
		//logger.info("Delete Defect Type Service Implementation");
		return true;
	}

	// Find defect type by id implementation
	@Override
	public DefectType findDefectTypeById(long id) {
		//logger.info("Get Defect Type By Id Service Implementation");
		return typeRepo.findById(id).orElse(null);
	}

	@Override
	public int getDefectTypeCount() {
		return (int) typeRepo.count();
	}

}
