package com.sgic.internal.employee.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:ErrorMessages.properties")
public class ErrorCodes {

	@Value("${validation.employee.notExists}")
	private String employeeNoExit;
	
	@Value("${validation.email.alreadyExists}")
	private String emailAlreadyExist;

	public String getEmployeeNoExit() {
		return employeeNoExit;
	}

	public void setEmployeeNoExit(String employeeNoExit) {
		this.employeeNoExit = employeeNoExit;
	}

	public String getEmailAlreadyExist() {
		return emailAlreadyExist;
	}

	public void setEmailAlreadyExist(String emailAlreadyExist) {
		this.emailAlreadyExist = emailAlreadyExist;
	}

}
