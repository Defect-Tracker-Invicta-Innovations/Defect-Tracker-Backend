package com.sgic.internal.product.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.internal.product.entities.PrivilegeDetail;
import com.sgic.internal.product.repositories.PrivilegeDetailRepository;
import com.sgic.internal.product.services.PrivilegeDetailService;

@Service
public class PrivilegeDetailServiceImpl implements PrivilegeDetailService {

	@SuppressWarnings("unused")
	@Autowired
	private PrivilegeDetailRepository privilegeDetailRepository;
	
	@Override
	public PrivilegeDetail getPrivilegeDetailById(Long id) {
		return privilegeDetailRepository.findPrivilegeDetailByid(id);
	}

	@Override
	public PrivilegeDetail savePrivilegeDetail(PrivilegeDetail privilegeDetail) {
		return privilegeDetailRepository.save(privilegeDetail);
	}

	@Override
	public List<PrivilegeDetail> getAllPrivilegeDetail() {
		return privilegeDetailRepository.findAll();
	}

	@Override
	public void deletePrivilegeDetailById(Long id) {
		privilegeDetailRepository.deleteById(id);
	}

	@Override
	public PrivilegeDetail updatePrivilegeDetail(PrivilegeDetail privilegeDetail) {
         Long id = privilegeDetail.getId();
		
		boolean isExist = ((PrivilegeDetailRepository) privilegeDetailRepository).findPrivilegeDetailByid(id) != null;
		if (isExist) {
			return privilegeDetailRepository.save(privilegeDetail);
		} else {
			
		}
		return null;
	} 
	
}
