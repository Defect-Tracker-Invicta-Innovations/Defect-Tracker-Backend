package com.sgic.internal.product.services.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.product.entities.Role;
import com.sgic.internal.product.repositories.RoleRepository;
import com.sgic.internal.product.services.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	private static Logger logger = LogManager.getLogger(RoleRepository.class);
	@Override
	public Role saveRole(Role role) {
		logger.info("service started -> SavePrivilege");
		return roleRepository.save(role);
	}
	
	@Override
	public Role getRoleById(Long roleId) {
		logger.info("service started -> getPrivilegeById");
		return roleRepository.findRoleByroleId(roleId);
	}

	@Override
	public Role deleteRoleById(Long roleId) {
		logger.info("service started -> deleteRoleById");
		roleRepository.deleteById(roleId);
		return null;
	}

	@Override
	public Role updateRole(Role role) {
		logger.info("service started -> UpdateRole");
		Long roleId = role.getRoleId();
		logger.info("service started -> getRoleId");
		boolean isExist = ((RoleRepository) roleRepository).findById(roleId) != null;
		if (isExist) {
			logger.info("service started -> Updated By roleId");
			return roleRepository.save(role);
		} else {
			logger.info("service started -> roleId Not Found");
		}
		return null;
	}

	@Override
	public List<Role> getAllRoleInfo() {
		return roleRepository.findAll();
	}
}
