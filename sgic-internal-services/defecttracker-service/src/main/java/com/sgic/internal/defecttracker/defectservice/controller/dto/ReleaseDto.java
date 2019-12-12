package com.sgic.internal.defecttracker.defectservice.controller.dto;

public class ReleaseDto {
	
	private Long releaseId;
	private String releaseName;
	
	public String getReleaseName() {
		return releaseName;
	}
	public void setReleaseName(String releaseName) {
		this.releaseName = releaseName;
	}
	public Long getReleaseId() {
		return releaseId;
	}
	public void setReleaseId(Long releaseId) {
		this.releaseId = releaseId;
	}
	
	

}
