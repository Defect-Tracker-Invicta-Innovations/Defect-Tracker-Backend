package com.sgic.internal.defecttracker.defectservice.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defectservice.entities.HRPrivilege;
import com.sgic.internal.defecttracker.defectservice.repositories.HRPrivilegeRepository;
import com.sgic.internal.defecttracker.defectservice.services.HRPrivilegeService;

@Service
public class HRPrivilegeServiceImpl implements HRPrivilegeService {

	@Autowired
	private HRPrivilegeRepository hrPrivilegeRepository;
	
	
	@Override
	public HRPrivilege createHRPrivilege(HRPrivilege hrPrivilege) {
		return hrPrivilegeRepository.save(hrPrivilege);
	}

	@Override
	public List<HRPrivilege> getallHRPrivilege() {
		return hrPrivilegeRepository.findAll();
	}

	@Override
	public HRPrivilege getByPrivilegeName(String privilegeName) {
		return hrPrivilegeRepository.findHRPrivilegeByPrivilegeName(privilegeName);
	}

	@Override
	public HRPrivilege updateHRPrivilege(HRPrivilege hrPrivilege, Long id) {
		boolean isExit = hrPrivilegeRepository.findHRPrivilegeById(id) != null;
		if(isExit) {
			hrPrivilege.setId(id);
			return hrPrivilegeRepository.save(hrPrivilege);
		}else {
			
		}
		return null;
	}

	@Override
	public void deleteHRPrivilege(Long id) {
		// TODO Auto-generated method stub
		hrPrivilegeRepository.deleteById(id);
		
	}

}
