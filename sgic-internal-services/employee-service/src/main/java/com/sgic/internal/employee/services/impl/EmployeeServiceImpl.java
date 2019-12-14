package com.sgic.internal.employee.services.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;

import com.sgic.internal.employee.entities.Employee;

import com.sgic.internal.employee.repositories.EmployeeRepository;
import com.sgic.internal.employee.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	private static Logger logger = LogManager.getLogger(EmployeeRepository.class);

	@Override
	public Employee saveEmployee(Employee employee) {
		try {
			logger.debug("Employee Service Imp:--> Save Employee Details method");
			return employeeRepository.save(employee);
		} catch (Exception ex) {
			logger.error("Employee Service Imp:--> Error" + ex.getMessage());
		}
		return employee;
	}

	@Transactional(readOnly = true)
	public boolean isEmailAlreadyExist(String email) {
		try {
			logger.debug("Employee Service Imp:--> Existing Email Address method");
			return employeeRepository.existsByEmail(email);
		} catch (Exception ex) {
			logger.error("Employee Service Imp:--> Error" + ex.getMessage());
		}
		return false;
	}

	@Transactional(readOnly = true)
	public boolean isEmployeeIdAlreadyExist(String employeeId) {
		try {
			logger.debug("Employee Service Imp:--> Existing Employee Id method");
			return employeeRepository.existsByEmployeeId(employeeId);
		} catch (Exception ex) {
			logger.error("Employee Service Imp:--> Error" + ex.getMessage());
		}
		return false;
	}

	@Override
	public List<Employee> findByEmployeeOrderByEmployeeIdDesc(Long id) {
		try {
			logger.debug("Employee Service Imp:--> Get All Employee Details Method");
			return employeeRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
		} catch (Exception ex) {
			logger.error("Employee Service Imp:--> Error" + ex.getMessage());
		}
		return null;
	}

	@Override
	public Employee getById(Long id) {
		try {
			logger.debug("Employee Service Imp:-->Get By Employee ID Method");
			return employeeRepository.findEmployeeById(id);
		} catch (Exception ex) {
			logger.error("Employee Service Imp:--> Error" + ex.getMessage());
		}
		return null;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		try {
			Long id = employee.getId();
			boolean isExist = employeeRepository.findById(id) != null;
			if (isExist) {
				logger.debug("Employee update Successfully");
				return employeeRepository.save(employee);
			} else {
				logger.debug("Employee Id is Not Found");
			}

		} catch (Exception ex) {
			logger.error("Employee Service Imp:--> Error" + ex.getMessage());
		}
		return employee;
	}

	@Override
	public void deleteEmployeeById(Long id) {
		try {
			logger.info("Delete Employee Details Method");
			employeeRepository.deleteById(id);
		} catch (Exception ex) {
			logger.error("Employee Service Imp:--> Error" + ex.getMessage());
		}

	}

	@Override
	public void updateBenchTrue(Long id, Employee employee) {
		try {
			Long id1 = employee.getId();
			boolean bench = employee.isBench();
			boolean isExist = employeeRepository.findById(id1) != null;
			if (isExist) {
				logger.info("Employee update Successfully");
				employeeRepository.updateBenchTrue(id);
			} else {
				logger.info("Employee Id is Not Found");
			}

		} catch (Exception ex) {
			logger.error("Employee Service Imp:--> Error" + ex.getMessage());
		}

	}

	@Override
	public void updateBenchFalse(Long id, Employee employee) {
		try {
			Long id1 = employee.getId();
			boolean bench = employee.isBench();
			boolean isExist = employeeRepository.findById(id1) != null;
			if (isExist) {
				logger.info("Employee update Successfully");
				employeeRepository.updateBenchFalse(id);
			} else {
				logger.info("Employee Id is Not Found");
			}

		} catch (Exception ex) {
			logger.error("Employee Service Imp:--> Error" + ex.getMessage());
		}

	}

	@Override
	@Modifying
	public void updateAvailability(Employee employee) {
		try {
			int availability = employee.getAvailability();
			int availabilitynow = 100 - availability;
			Long id = employee.getId();
			boolean isExist = employeeRepository.findById(id) != null;
			if (isExist) {
				logger.info("Employee availabilty update Successfully");
				employeeRepository.updateAvailability(availabilitynow, id);
			} else {
				logger.info("Employee Id is Not Found");
			}

		} catch (Exception ex) {
			logger.error("Employee Service Imp:--> Error" + ex.getMessage());
		}

	}

}
