package com.sgic.internal.defecttracker.defectservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sgic.internal.defecttracker.defectservice.entities.ProjectPrivilege;

public interface ProjectPrivilegeRepository extends JpaRepository<ProjectPrivilege, Long> {

	ProjectPrivilege findProjectPrivilegeByPrivilegeName(String privilegeName);

	ProjectPrivilege findProjectPrivilegeById(Long id);
}
