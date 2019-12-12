package com.sgic.internal.defecttracker.defectservice.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "projecttype")
public class ProjectType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long projecttypeId;
	
	private String projecttypeName;

	public Long getProjecttypeId() {
		return projecttypeId;
	}

	public void setProjecttypeId(Long projecttypeId) {
		this.projecttypeId = projecttypeId;
	}

	public String getProjecttypeName() {
		return projecttypeName;
	}

	public void setProjecttypeName(String projecttypeName) {
		this.projecttypeName = projecttypeName;
	}
	
	
}
