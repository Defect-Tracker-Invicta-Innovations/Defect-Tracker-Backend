package com.sgic.internal.defecttracker.defectservice.entities;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(schema = "defectservices",name = "severity")
public class SeverityConfig {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long severityId;

	// create relationship with project //
	@OneToOne
	@JoinColumn(name = "projectid", nullable = false)
	private Project project;
	
	// create the priority type in array list
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private ArrayList<String> severityList;

	public Long getSeverityId() {
		return severityId;
	}

	public void setSeverityId(Long severityId) {
		this.severityId = severityId;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public ArrayList<String> getSeverityList() {
		return severityList;
	}

	public void setSeverityList(ArrayList<String> severityList) {
		this.severityList = severityList;
	}
	
}
