package com.sgic.internal.defecttracker.defectservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.defecttracker.defectservice.entities.QAPrivilege;

public interface QAPrivilegeRepository extends JpaRepository<QAPrivilege, Long>{
	
	
	QAPrivilege findQAPrivilegeByPrivilegeName(String privilegeName);
	
	QAPrivilege findQAPrivilegeById(Long id);
	
}
