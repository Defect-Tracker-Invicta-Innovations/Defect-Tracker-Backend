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
@Table(schema = "defectservices",name = "priority")
public class PriorityConfig {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long priorityId;

	// create relationship with project //
	@OneToOne
	@JoinColumn(name = "projectId", nullable = false)
	private Project project;
	
	// create the priority type in array list
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private ArrayList<String> priorityList;

	public Long getPriorityId() {
		return priorityId;
	}

	public void setPriorityId(Long priorityId) {
		this.priorityId = priorityId;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public ArrayList<String> getPriorityList() {
		return priorityList;
	}

	public void setPriorityList(ArrayList<String> priorityList) {
		this.priorityList = priorityList;
	}

	
}
