package com.sgic.internal.defecttracker.defectservice.services;

import java.util.List;

import com.sgic.internal.defecttracker.defectservice.entities.HRPrivilege;


public interface HRPrivilegeService {

	public HRPrivilege createHRPrivilege(HRPrivilege hrPrivilege);

	List<HRPrivilege> getallHRPrivilege();

	public HRPrivilege getByPrivilegeName(String privilegeName);

	public HRPrivilege updateHRPrivilege(HRPrivilege hrPrivilege, Long id);
	
	public void deleteHRPrivilege(Long id);
}
