package com.sgic.internal.defecttracker.defectservice.services;

import java.util.List;

import com.sgic.internal.defecttracker.defectservice.entities.Module;


public interface ModuleService {

	public Module createModule(Module module);

	public boolean isModuleAlreadyExists(String moduleId);

	public List<Module> getallModuleDetails(String projectid);

	public void deleteById(String moduleId);

	public Module updateModule(String moduleId, Module module);

	Module getByModuleId(String moduleId);

	public List<Module> getBymoduleName(String moduleName);

	// service for get project id
	public List<Module> getByprojectId(String projectid);

	List<Module> getallDetails(String moduleId);
	
	Module getByallModuleId(String moduleId);
	
	public Module moduleUpdate(Module module);

	// List Module Info
	public List<Module> findByModuleOrderByModuleIdDesc(String moduleId);
}
