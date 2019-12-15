package com.sgic.internal.product.controller.dto;

import java.sql.Date;

//DTO for Company Entity 
//Created By:Tyron,24.06.2019
public class CompanyDto {

	private Long id; // Id AUTO INCREMENT
	private String companyName; // Company Name
	private String abbreviation; // Company Short Name
	private String regNo; // Company Registration No
	private String companyAdminName; // Company Admin Name
	private String adminEmail; // Company admin Email
	
	private Long licenseTypeId; // Company License Type ID from CompanyLicenseType Entity
	private String companyLicenseTypeName; //  Company License Type Name from CompanyLicenseType Entity
	
	private int licensePeriod; // Duration of the license Period
	private Date startDate; // License Start Date
	private Date endDate; // License End Date
	private String companyDescription; // Description about the Company

	public CompanyDto(String companyName, String abbreviation, String regNo,
			String companyAdminName, String adminEmail, Long licenseTypeId,String companyLicenseTypeName, int licensePeriod,
			Date startDate, Date endDate, String companyDescription)
	{
		super();
		this.companyName = companyName;
		this.abbreviation = abbreviation;
		this.regNo = regNo;
		this.companyAdminName = companyAdminName;
		this.adminEmail = adminEmail;
		this.licenseTypeId = licenseTypeId;
		this.companyLicenseTypeName = companyLicenseTypeName;
		this.licensePeriod = licensePeriod;
		this.startDate = startDate;
		this.endDate = endDate;
		this.companyDescription = companyDescription;
	}
	
	//Getter and Setter for DTO Attributes
	
	public CompanyDto() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public Long getLicenseTypeId() {
		return licenseTypeId;
	}

	public void setLicenseTypeId(Long licenseTypeId) {
		this.licenseTypeId = licenseTypeId;
	}

	public int getLicensePeriod() {
		return licensePeriod;
	}

	public void setLicensePeriod(int licensePeriod) {
		this.licensePeriod = licensePeriod;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAdminName() {
		return companyAdminName;
	}

	public void setCompanyAdminName(String companyAdminName) {
		this.companyAdminName = companyAdminName;
	}

	public String getCompanyLicenseTypeName() {
		return companyLicenseTypeName;
	}

	public void setCompanyLicenseTypeName(String companyLicenseTypeName) {
		this.companyLicenseTypeName = companyLicenseTypeName;
	}

	public String getCompanyDescription() {
		return companyDescription;
	}

	public void setCompanyDescription(String companyDescription) {
		this.companyDescription = companyDescription;
	}
	
	

}
