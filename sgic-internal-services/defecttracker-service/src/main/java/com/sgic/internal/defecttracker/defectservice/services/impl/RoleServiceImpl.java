package com.sgic.internal.defecttracker.defectservice.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defectservice.entities.Role;
import com.sgic.internal.defecttracker.defectservice.repositories.RoleRepository;
import com.sgic.internal.defecttracker.defectservice.services.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public List<Role> getAllRole() {
		return roleRepository.findAll();
	}

}
