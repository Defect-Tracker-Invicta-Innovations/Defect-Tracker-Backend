package com.sgic.internal.product.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(schema = "productservice", name = "defectstatus",  uniqueConstraints = {
		@UniqueConstraint(columnNames = { "name" }) })
public class DefectStatus implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; // Defect Status Id

	@Column(unique=true)
	@Size(min=3,max=15)
	@NotEmpty
	private String name; // Defect Status name
	
	@Size(min=5,max=50)
	@NotEmpty
	
	private String value; // Defect Status value

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
