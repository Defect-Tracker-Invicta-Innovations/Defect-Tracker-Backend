package com.sgic.internal.employee.services;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.sgic.internal.employee.entities.Employee;

public interface EmployeeService {

	// Method for Save Employee Entity
	public Employee saveEmployee(Employee employee);

	// Method for Employee List
	public List<Employee> findByEmployeeOrderByEmployeeIdDesc(Long id);

	// Method for Getting One Employee Record by ID
	public Employee getById(Long id);

	public boolean isEmailAlreadyExist(String email);

	public boolean isEmployeeIdAlreadyExist(String employeeId);

	// Method for Update Employee
	public Employee updateEmployee(Employee employee);

	// Method for Delete One Employee Record
	public void deleteEmployeeById(Long id);

	// Method for UpdateBenchTrue Employee
	public void updateBenchTrue(Long id, Employee employee);

	// Method for UpdateBenchFalse Employee
	public void updateBenchFalse(Long id, Employee employee);

	// Method for UpdateAvailability Employee
	public void updateAvailability(Employee employee);

	// Excel import method
	public void store(MultipartFile file);

}