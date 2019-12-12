package com.sgic.internal.defecttracker.defectservice.services.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defectservice.entities.QAPrivilege;
import com.sgic.internal.defecttracker.defectservice.repositories.QAPrivilegeRepository;
import com.sgic.internal.defecttracker.defectservice.services.QAPrivilegeService;


@Service
public class QAPrivilegeServiceImpl implements QAPrivilegeService {

	@Autowired
	private QAPrivilegeRepository qaPrivilegeRepositorty;
	@Override
	public QAPrivilege createQAPrivilege(QAPrivilege qaPrivilege) {
		return qaPrivilegeRepositorty.save(qaPrivilege);
	}

	@Override
	public List<QAPrivilege> getallQAPrivilege() {
		return qaPrivilegeRepositorty.findAll();
	}
	
	public QAPrivilege getByPrivilegeName(String privilegeName) {
		try {
			
			return qaPrivilegeRepositorty.findQAPrivilegeByPrivilegeName(privilegeName);
		} catch (Exception ex) {
//			logger.error("Employee Service Imp:--> Error" + ex.getMessage());
		}
		return null;

	}

	@Override
	public QAPrivilege updateQAPrivilege(QAPrivilege qaPrivilege,Long id) {
//		Long id = qaPrivilege.getId();
		boolean isExit = qaPrivilegeRepositorty.findQAPrivilegeById(id) != null;
		if(isExit) {
			qaPrivilege.setId(id);
			return qaPrivilegeRepositorty.save(qaPrivilege);
		}else {
			
		}
		return null;
	}

	@Override
	public void deleteQAprivilege(Long id) {
		qaPrivilegeRepositorty.deleteById(id);
	}


}
