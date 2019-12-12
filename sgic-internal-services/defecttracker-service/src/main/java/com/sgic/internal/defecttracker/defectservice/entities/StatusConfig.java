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
@Table(schema = "defectservices", name = "status")
public class StatusConfig {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long statusId;

	// create relationship with project //
	@OneToOne
	@JoinColumn(name = "projectid", nullable = false)
	private Project project;

	// create the priority type in array list
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private ArrayList<String> statusList;

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public ArrayList<String> getStatusList() {
		return statusList;
	}

	public void setStatusList(ArrayList<String> statusList) {
		this.statusList = statusList;
	}
	
}
