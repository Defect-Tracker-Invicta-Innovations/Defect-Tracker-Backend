package com.sgic.internal.product.services;

import java.util.List;
import com.sgic.internal.product.entities.Role;

public interface RoleService {
	public Role saveRole(Role role);
	List<Role> getAllRoleInfo();
	public Role getRoleById(Long roleId);
	Role updateRole(Role role);
	Role deleteRoleById(Long roleId);
}
