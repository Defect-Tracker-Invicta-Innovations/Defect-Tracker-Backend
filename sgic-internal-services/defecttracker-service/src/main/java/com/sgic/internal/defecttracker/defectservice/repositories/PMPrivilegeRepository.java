package com.sgic.internal.defecttracker.defectservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sgic.internal.defecttracker.defectservice.entities.PMPrivilege;

public interface PMPrivilegeRepository extends JpaRepository<PMPrivilege, Long> {

	PMPrivilege findPMPrivilegeByPrivilegeName(String privilegeName);

	PMPrivilege findPMPrivilegeById(Long id);
}
