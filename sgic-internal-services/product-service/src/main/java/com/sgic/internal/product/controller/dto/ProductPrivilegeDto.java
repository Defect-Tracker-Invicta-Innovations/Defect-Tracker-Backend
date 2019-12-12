package com.sgic.internal.product.controller.dto;


public class ProductPrivilegeDto {
	private Long id;
	private String privilegeId;
	private String privilegeName;
	private boolean privilegeStatus;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public boolean isPrivilegeStatus() {
		return privilegeStatus;
	}
	public void setPrivilegeStatus(boolean privilegeStatus) {
		this.privilegeStatus = privilegeStatus;
	}
	public String getPrivilegeId() {
		return privilegeId;
	}
	public void setPrivilegeId(String privilegeId) {
		this.privilegeId = privilegeId;
	}
	public String getPrivilegeName() {
		return privilegeName;
	}
	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}
	
	
	
	
}
