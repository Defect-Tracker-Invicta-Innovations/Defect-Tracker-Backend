package com.sgic.internal.defecttracker.defectservice.services;

import java.util.List;

import com.sgic.internal.defecttracker.defectservice.entities.SubModule;

public interface SubModuleService {

	public SubModule createSubModule(SubModule subModule);

	public boolean isSubModuleAlreadyExists(String subModuleId);

	public List<SubModule> getallDetails();

	public void deleteSubModuleById(String subModuleId);

	public SubModule updateSubModule(String subModuleId, SubModule subModule);

	public SubModule getBySubModuleId(String subModuleId);
	
	public List<SubModule> getByabbre(String abbre);

	public List<SubModule> getBysubModuleName(String subModuleName);
}
