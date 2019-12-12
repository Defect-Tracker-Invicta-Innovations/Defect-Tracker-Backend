package com.sgic.internal.defecttracker.defectservice.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defectservice.entities.DeveloperPrivilege;
import com.sgic.internal.defecttracker.defectservice.repositories.DeveloperPrivilegeRepository;
import com.sgic.internal.defecttracker.defectservice.services.DeveloperPrivilegeService;

@Service
public class DeveloperPrivilegeServiceImpl implements DeveloperPrivilegeService {

	@Autowired
	private DeveloperPrivilegeRepository developerPrivilegeRepository;
	
	@Override
	public DeveloperPrivilege createDeveloperPrivilege(DeveloperPrivilege developerPrivilege) {
		return developerPrivilegeRepository.save(developerPrivilege);
	}

	@Override
	public List<DeveloperPrivilege> getallDeveloperPrivilege() {
		return developerPrivilegeRepository.findAll();
	}

	@Override
	public DeveloperPrivilege getByPrivilegeName(String privilegeName) {
		return developerPrivilegeRepository.findDeveloperPrivilegeByPrivilegeName(privilegeName);
	}

	@Override
	public DeveloperPrivilege updateDeveloperPrivilege(DeveloperPrivilege developerPrivilege, Long id) {
		boolean isExit = developerPrivilegeRepository.findDeveloperPrivilegeById(id) != null;
		if(isExit) {
			developerPrivilege.setId(id);
			return developerPrivilegeRepository.save(developerPrivilege);
		}else {
			
		}
		return null;
	}

	@Override
	public void deleteDeveloperPrivilege(Long id) {
		// TODO Auto-generated method stub
		developerPrivilegeRepository.deleteById(id);
		
	}

}
