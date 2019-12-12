package com.sgic.internal.defecttracker.defectservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.defecttracker.defectservice.entities.SeverityCount;



public interface DashboardRepository extends JpaRepository<SeverityCount,Long>{

}
