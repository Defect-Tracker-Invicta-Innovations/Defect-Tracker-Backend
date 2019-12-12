package com.sgic.internal.defecttracker.defectservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sgic.internal.defecttracker.defectservice.entities.DeveloperPrivilege;

public interface DeveloperPrivilegeRepository extends JpaRepository<DeveloperPrivilege, Long> {

	DeveloperPrivilege findDeveloperPrivilegeByPrivilegeName(String privilegeName);

	DeveloperPrivilege findDeveloperPrivilegeById(Long id);
}
