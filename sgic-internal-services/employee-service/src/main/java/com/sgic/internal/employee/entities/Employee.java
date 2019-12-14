package com.sgic.internal.employee.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.springframework.lang.Nullable;

import com.sgic.internal.employee.util.AppConstants;


@Entity
@Table(schema = AppConstants.SCHEMA, name = AppConstants.TABLENAME_EMPLOYEE)
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// Initialize Variable for Attribute of Employee
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	@NotEmpty
	private String employeeId;

	@NotEmpty
	@Size(min = 2, max = 30)
	@Pattern(regexp = AppConstants.SPECIAL_CHARACTER, message = AppConstants.MESSAGE)
	private String firstName;

	@NotEmpty
	@Size(min = 2, max = 30)
	@Pattern(regexp = AppConstants.SPECIAL_CHARACTER, message = AppConstants.MESSAGE)
	private String lastName;

	@NotEmpty
	@Size(min = 2, max = 50)
	@Email
	@Column(unique = true)
	private String email;

	@Nullable
	private int availability;

	@Nullable
	private boolean bench = false;

	@Nullable
	private String profilePicturePath;

	// Getter & Setter method for Employee Entity

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}

	public boolean isBench() {
		return bench;
	}

	public void setBench(boolean bench) {
		this.bench = bench;
	}

	public String getProfilePicturePath() {
		return profilePicturePath;
	}

	public void setProfilePicturePath(String profilePicturePath) {
		this.profilePicturePath = profilePicturePath;
	}

	// Designation with Designation Entity Relationship
	@ManyToOne
	@JoinColumn(name = "designationId", nullable = false)
	private Designation designation;

//	Designation Object Getter Setter
	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

}
