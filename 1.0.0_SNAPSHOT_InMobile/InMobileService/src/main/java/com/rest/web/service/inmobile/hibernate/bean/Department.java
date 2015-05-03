package com.rest.web.service.inmobile.hibernate.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_departments database table.
 * 
 */
@Entity
@Table(name="tb_departments")
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int countryId;

	private String departmentName;

	public Department() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCountryId() {
		return this.countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}