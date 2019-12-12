package com.sgic.internal.defecttracker.defectservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sgic.internal.defecttracker.defectservice.entities.DBFile;

@Repository
@Transactional
public interface DBFileRepository extends JpaRepository<DBFile,Long> {


	@Query("SELECT d FROM DBFile d WHERE d.defect.defectId= :defectId")
	List<DBFile> findDBFileByDefectId(@Param("defectId") Long defectId);
}
