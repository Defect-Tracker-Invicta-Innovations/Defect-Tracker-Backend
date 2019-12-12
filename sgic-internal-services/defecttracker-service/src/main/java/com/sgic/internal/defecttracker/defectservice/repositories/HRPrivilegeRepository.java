package com.sgic.internal.defecttracker.defectservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.defecttracker.defectservice.entities.HRPrivilege;



public interface HRPrivilegeRepository extends JpaRepository<HRPrivilege, Long> {
	
HRPrivilege	findHRPrivilegeByPrivilegeName(String privilegeName);

	HRPrivilege findHRPrivilegeById(Long id);

}
