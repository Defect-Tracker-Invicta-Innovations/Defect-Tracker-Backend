package com.sgic.internal.product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.product.entities.Privilege;

public interface PrivilegeRepository extends JpaRepository<Privilege, String> {

	Privilege findPrivilegeByprivilegeId(String privilageId);

}
