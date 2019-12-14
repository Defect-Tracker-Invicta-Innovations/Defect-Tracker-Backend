package com.sgic.internal.product.controller.dto;

public class DefectTypeDto {
	private long id; // Defect type id
	private String defectType; // Defect type name
	private String value; // Defect type value

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDefectType() {
		return defectType;
	}

	public void setDefectType(String defectType) {
		this.defectType = defectType;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
