package com.sgic.internal.employee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.sgic.internal.employee.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	// Find Employee By ID Method
		Employee findEmployeeById(Long id);

		// Find Employee By Bench
		@Transactional
		@Modifying(clearAutomatically = true)
		@Query("UPDATE Employee e SET e.bench=true where e.id = :id")
		void updateBenchTrue(@Param("id") Long id);

		@Transactional
		@Modifying(clearAutomatically = true)
		@Query("UPDATE Employee e SET e.bench=false where e.id = :id")
		void updateBenchFalse(@Param("id") Long id);

		// Find Employee By Availability
		@Transactional
		@Modifying(clearAutomatically = true)
		@Query("UPDATE Employee e SET e.availability=:availablenow where e.id = :id")
		void updateAvailability(@Param("availablenow") int availablenow, @Param("id") Long id);

		boolean existsByEmail(String email);

		boolean existsByEmployeeId(String employeeId);

}