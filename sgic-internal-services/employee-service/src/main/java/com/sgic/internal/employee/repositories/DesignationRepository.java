package com.sgic.internal.employee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sgic.internal.employee.entities.Designation;

public interface DesignationRepository extends JpaRepository<Designation, Long> {

//	get by Designation Id Method
	public Designation findDesignationById(Long id);

//	delete Designation method
	public void deleteDesignationById(Long id);

}
