package com.sgic.internal.defecttracker.defectservice.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defectservice.entities.PMPrivilege;
import com.sgic.internal.defecttracker.defectservice.repositories.PMPrivilegeRepository;
import com.sgic.internal.defecttracker.defectservice.services.PMPrivilegeService;

@Service
public class PMPrivilegeServiceImpl implements PMPrivilegeService{

	@Autowired
	private PMPrivilegeRepository pmPrivilegeRepository;
	
	@Override
	public PMPrivilege createPMPrivilege(PMPrivilege pmPrivilege) {
		return pmPrivilegeRepository.save(pmPrivilege);
	}

	@Override
	public List<PMPrivilege> getallPMPrivilege() {
		return pmPrivilegeRepository.findAll();
	}

	@Override
	public PMPrivilege getByPrivilegeName(String privilegeName) {
		return pmPrivilegeRepository.findPMPrivilegeByPrivilegeName(privilegeName);
	}

	@Override
	public PMPrivilege updatePMPrivilege(PMPrivilege pmPrivilege, Long id) {
		boolean isExit = pmPrivilegeRepository.findPMPrivilegeById(id) != null;
		if(isExit) {
			pmPrivilege.setId(id);
			return pmPrivilegeRepository.save(pmPrivilege);
		}else {
			
		}
		return null;
	}

	@Override
	public void deletePMPrivilege(Long id) {
		// TODO Auto-generated method stub
		pmPrivilegeRepository.deleteById(id);
		
	}

}
