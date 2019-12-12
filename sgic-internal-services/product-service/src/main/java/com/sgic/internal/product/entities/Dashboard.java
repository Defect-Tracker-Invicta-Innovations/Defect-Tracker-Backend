package com.sgic.internal.product.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dashboard")
public class Dashboard {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dashboard_id")
	private Long dashboardId;
	
	@Column(name = "dashboard_name")
	private String dashboardName;

	public Long getDashboardId() {
		return dashboardId;
	}

	public void setDashboardId(Long dashboardId) {
		this.dashboardId = dashboardId;
	}

	public String getDashboardName() {
		return dashboardName;
	}

	public void setDashboardName(String dashboardName) {
		this.dashboardName = dashboardName;
	}
	
	
}
