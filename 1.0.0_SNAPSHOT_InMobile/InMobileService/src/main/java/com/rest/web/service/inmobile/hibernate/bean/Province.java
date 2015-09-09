package com.rest.web.service.inmobile.hibernate.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_province database table.
 * 
 */
@Entity
@Table(name="tb_province")
public class Province implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int departmentId;

	private String provinceName;

	public Province() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getProvinceName() {
		return this.provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

}