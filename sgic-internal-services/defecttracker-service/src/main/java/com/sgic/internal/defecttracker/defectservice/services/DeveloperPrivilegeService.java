package com.sgic.internal.defecttracker.defectservice.services;

import java.util.List;
import com.sgic.internal.defecttracker.defectservice.entities.DeveloperPrivilege;

public interface DeveloperPrivilegeService {

	public DeveloperPrivilege createDeveloperPrivilege(DeveloperPrivilege developerPrivilege);

	List<DeveloperPrivilege> getallDeveloperPrivilege();

	public DeveloperPrivilege getByPrivilegeName(String privilegeName);

	public DeveloperPrivilege updateDeveloperPrivilege(DeveloperPrivilege developerPrivilege, Long id);
	
	public void deleteDeveloperPrivilege(Long id);
}
