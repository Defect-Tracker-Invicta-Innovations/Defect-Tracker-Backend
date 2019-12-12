package com.sgic.internal.defecttracker.defectservice.repositories;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sgic.internal.defecttracker.defectservice.entities.Defect;
import com.sgic.internal.defecttracker.defectservice.entities.Module;


public interface DefectRepository extends JpaRepository<Defect, Long >{

Defect getByDefectId(Long defectId);

@Query(value ="FROM Defect WHERE defect_abbr =:defectAbbr") 
List<Defect> getByDefectAbbr(String defectAbbr);

@Query(value ="FROM Defect WHERE project_id =:projectId") 
List<Defect>getByProjectId(@Param("projectId")String projectId); 

@Query(value ="FROM Defect WHERE module_id =:moduleId") 
List<Defect>getByModuleId(@Param("moduleId")String moduleId);


@Query(value ="FROM Defect WHERE date_and_time =:dateAndTime") 
List<Defect>getByDefectDate(@Param("dateAndTime")Date dateAndTime);


@Query(value ="FROM Defect WHERE available_in =:availableIn") 
List<Defect>getByAvailableIn(@Param("availableIn")String availableIn);

//@Modifying
//@Query("UPDATE Defect d SET d.statusId = :status_id WHERE d.defect_id = :defectId")
//int updateStatusId(@Param("defectId") Long defectId, @Param("statusId") int statusId);

@Query(value ="FROM Defect WHERE found_in =:foundIn") 
List<Defect>getByFoundIn(@Param("foundIn")String foundIn);

@Query(value ="FROM Defect WHERE fixed_in =:fixedIn") 
List<Defect>getByFixedIn(@Param("fixedIn")String fixedIn);


List<Defect> findDefectByModule(Module module);

@Query(value ="SELECT d FROM Defect d WHERE status =:status")
List<Defect> getByStatus(@Param("status")String status);

@Query(value ="SELECT d FROM Defect d WHERE priority =:priority")
List<Defect> getByPriority(@Param("priority")String priority);

@Query(value ="SELECT d FROM Defect d WHERE severity =:severity")
List<Defect> getBySeverity(@Param("severity")String severity);

@Query(value ="SELECT d FROM Defect d WHERE type =:type")
List<Defect> getByType(@Param("type")String type);


@Query(value = "SELECT COUNT(status) FROM Defect WHERE project_id=:projectId AND status =:status")
Long countByStatus(String status, String projectId );

//@Query("SELECT COUNT(*) FROM Defect d WHERE d.status=:rejected")
//Long countRejectedDefect(@Param("rejected") String defectId);


//For Severity Index Start
@Query("SELECT COUNT(severity) FROM Defect WHERE severity='Low'")
int countBySeverity();

@Query("SELECT COUNT(severity) FROM Defect WHERE severity='Medium'")
int countBySeverityMedium();

@Query("SELECT COUNT(severity) FROM Defect WHERE severity='High'")
int countBySeverityhigh();

@Query("SELECT COUNT(status) FROM Defect WHERE status='Rejected' ")
int countByStatusRejected();

public long count();

@Query("SELECT highWeight FROM SeverityWeight")
int getHighWeight();

@Query("SELECT mediumWeight FROM SeverityWeight")
int getMediumWeight();

@Query("SELECT lowWeight FROM SeverityWeight")
int getLowWeight();
//For Severity Index End

@Query("SELECT COUNT(severity) FROM Defect WHERE status='Rejected' AND severity = 'low'")
int countByStatusRejectedlow();

@Query("SELECT COUNT(severity) FROM Defect WHERE status='Rejected' AND severity = 'High'")
int countByStatusRejectedHigh();

@Query("SELECT COUNT(severity) FROM Defect WHERE status='Rejected' AND severity = 'medium'")
int countByStatusRejectedmedium();

@Query("SELECT COUNT(priority) FROM Defect WHERE priority='Medium'")
int countByPriorityMedium();

@Query("SELECT COUNT(priority) FROM Defect WHERE status='Rejected' AND priority = 'medium'")
int countByPriorityStatusRejectedmedium();

@Query("SELECT COUNT(priority) FROM Defect WHERE priority='High'")
int countByPriorityHigh();

@Query("SELECT COUNT(priority) FROM Defect WHERE status='Rejected' AND priority = 'High'")
int countByPriorityStatusRejectedhigh();

@Query("SELECT COUNT(priority) FROM Defect WHERE priority='low'")
int countByPriorityLow();

@Query("SELECT COUNT(priority) FROM Defect WHERE status='Rejected' AND priority = 'low'")
int countByPriorityStatusRejectedlow();
}


