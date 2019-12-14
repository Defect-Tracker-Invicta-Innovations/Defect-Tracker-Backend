package com.sgic.internal.employee.services;

import java.util.List;
import com.sgic.internal.employee.entities.Designation;

public interface DesignationService {

	//	Save method for Designation Method
	public Designation savedesignation(Designation designation);

	//	Get List from Designation Table Method
	public List<Designation> getAllDesignation();

	//	Get Designation by Designation Id Method
	public Designation getByDesignationId(Long id);

	//  Delete Designation by Designation Id Method
	public void deleteDesignationBydesignationId(Long id);

}
