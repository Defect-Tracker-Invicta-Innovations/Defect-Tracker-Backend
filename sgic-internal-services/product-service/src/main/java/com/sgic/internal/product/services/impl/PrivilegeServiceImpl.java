package com.sgic.internal.product.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.product.entities.Privilege;
import com.sgic.internal.product.repositories.PrivilegeRepository;
import com.sgic.internal.product.services.PrivilegeService;

@Service
public class PrivilegeServiceImpl implements PrivilegeService{

	@Autowired
	private PrivilegeRepository privilegeRepository;
	
	@Override
	public Privilege getPrivilegeById(String privilageId) {
		return privilegeRepository.findPrivilegeByprivilegeId(privilageId);
	}

	@Override
	public Privilege savePrivilege(Privilege privilege) {
		return privilegeRepository.save(privilege);
	}

	@Override
	public List<Privilege> getAllPrivilege() {
		return privilegeRepository.findAll();
	}

	@Override
	public void deletePrivilegeById(String privilageId) {
	   privilegeRepository.deleteById(privilageId);
	}

	@Override
	public Privilege updatePrivilege(Privilege privilege) {
		String privilageId = privilege.getPrivilegeId();
		
		boolean isExist = ((PrivilegeRepository) privilegeRepository).findById(privilageId) != null;
		if (isExist) {
			return privilegeRepository.save(privilege);
		} else {
			
		}
		return null;
	}

}
