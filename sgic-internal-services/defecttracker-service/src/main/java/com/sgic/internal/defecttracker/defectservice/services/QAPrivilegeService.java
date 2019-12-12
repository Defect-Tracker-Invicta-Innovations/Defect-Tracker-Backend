package com.sgic.internal.defecttracker.defectservice.services;

import java.util.List;

import com.sgic.internal.defecttracker.defectservice.entities.QAPrivilege;

public interface QAPrivilegeService {

	public QAPrivilege createQAPrivilege(QAPrivilege qaPrivilege);
	
	List<QAPrivilege> getallQAPrivilege();
	
	public QAPrivilege getByPrivilegeName(String privilegeName);
	
	public QAPrivilege updateQAPrivilege(QAPrivilege qaPrivilege,Long id);
	
	public void deleteQAprivilege(Long id);
	
}
