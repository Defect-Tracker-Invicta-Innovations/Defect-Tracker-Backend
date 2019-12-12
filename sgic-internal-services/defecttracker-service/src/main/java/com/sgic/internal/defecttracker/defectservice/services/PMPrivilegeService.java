package com.sgic.internal.defecttracker.defectservice.services;

import java.util.List;
import com.sgic.internal.defecttracker.defectservice.entities.PMPrivilege;

public interface PMPrivilegeService {

	public PMPrivilege createPMPrivilege(PMPrivilege pmPrivilege);

	List<PMPrivilege> getallPMPrivilege();

	public PMPrivilege getByPrivilegeName(String privilegeName);

	public PMPrivilege updatePMPrivilege(PMPrivilege pmPrivilege, Long id);
	
	public void deletePMPrivilege(Long id);
}
