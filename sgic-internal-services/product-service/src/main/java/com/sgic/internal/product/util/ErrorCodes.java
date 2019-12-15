package com.sgic.internal.product.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:ErrorMessages.properties")
public class ErrorCodes {

	@Value("${validation.employee.notExists}")
	private String employeeNotExist;

	@Value("${validation.company.alreadyExist}")
	private String companyAlreadyExist;

	public String getEmployeeNotExist() {
		return employeeNotExist;
	}

	public void setEmployeeNotExist(String employeeNotExist) {
		this.employeeNotExist = employeeNotExist;
	}

	public String getCompanyAlreadyExist() {
		return companyAlreadyExist;
	}

	public void setCompanyAlreadyExist(String companyAlreadyExist) {
		this.companyAlreadyExist = companyAlreadyExist;
	}

	
}
