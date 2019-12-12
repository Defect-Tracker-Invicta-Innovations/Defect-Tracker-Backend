package com.sgic.internal.defecttracker.defectservice.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "projectststus")
public class ProjectStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long projectstatusId;
	
	private String projectstatusName;

	public Long getProjectstatusId() {
		return projectstatusId;
	}

	public void setProjectstatusId(Long projectstatusId) {
		this.projectstatusId = projectstatusId;
	}

	public String getProjectstatusName() {
		return projectstatusName;
	}

	public void setProjectstatusName(String projectstatusName) {
		this.projectstatusName = projectstatusName;
	}
	
	
	
}
