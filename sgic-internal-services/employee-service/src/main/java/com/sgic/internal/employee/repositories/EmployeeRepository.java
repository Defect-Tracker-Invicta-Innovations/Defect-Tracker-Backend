//package com.sgic.internal.employee.repositories;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.transaction.annotation.Transactional;
//
//// import form Employee Entity 
//import com.sgic.internal.employee.entities.Employee;
//
//public interface EmployeeRepository extends JpaRepository<Employee, Long> {
//
//	// Find Employee By ID Method
//	Employee findEmployeeByEmpId(Long empId);
//
//	// Find Employee By Email
//	Employee findEmployeeByEmail(String email);
//
//	// Find Employee By Designation
//	@Query(value = "from Employee where designationid = :designationid")
//	List<Employee> findByDesignation(Long designationid);
//
//	// Find Employee By Name
//	@Query(value = "from Employee where name = :name")
//	List<Employee> findByName(String name);
//
//	// Find Employee By DesignationId
//	@Query("SELECT COUNT(designationid) FROM Employee WHERE designationid=:designationid")
//	Long getDeveloperCount(Long designationid);
//
//	// Find Employee By Designation Name
//	@Query("SELECT designationid FROM Designation WHERE designationname=:designationName")
//	Long findByDesignationName(String designationName);
//
//	// Find Employee By Bench
//	@Transactional
//	@Modifying(clearAutomatically = true)
//	@Query("UPDATE Employee e SET e.bench=true where e.empId = :empId")
//	void updateBenchTrue(@Param("empId") Long empId);
//
//	@Transactional
//	@Modifying(clearAutomatically = true)
//	@Query("UPDATE Employee e SET e.bench=false where e.empId = :empId")
//	void updateBenchFalse(@Param("empId") Long empId);
//
//	// Find Employee By Availability
//	@Transactional
//	@Modifying(clearAutomatically = true)
//	@Query("UPDATE Employee e SET e.availability=:availablenow where e.empId = :empId")
//	void updateAvailability(@Param("availablenow") int availablenow, @Param("empId") Long empId);
//
//	boolean existsByEmail(String email);
//
//	boolean existsByEmployeeId(String employeeid);
//
//}