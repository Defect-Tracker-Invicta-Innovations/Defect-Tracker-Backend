package com.sgic.internal.defecttracker.defectservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sgic.internal.defecttracker.defectservice.entities.Module;
import com.sgic.internal.defecttracker.defectservice.entities.SubModule;

public interface SubModuleRepository extends JpaRepository<SubModule, String> {

	SubModule getBySubModuleId(String subModuleId);

	List<SubModule> findModuleBysubModuleId(Module module);

	@Query(value = "FROM SubModule WHERE sub_module_name= :subModuleName")
	List<SubModule> getBysubModuleName(@Param("subModuleName") String subModuleName);

	List<SubModule> findSubModuleByModule(Module module);
}
