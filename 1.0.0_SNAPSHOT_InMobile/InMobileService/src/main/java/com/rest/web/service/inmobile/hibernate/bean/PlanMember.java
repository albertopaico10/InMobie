package com.rest.web.service.inmobile.hibernate.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_planmenber database table.
 * 
 */
@Entity
@Table(name="tb_planmenber")
public class PlanMember implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	private int status;

	private String valuePlanMenber;

	public PlanMember() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getValuePlanMenber() {
		return this.valuePlanMenber;
	}

	public void setValuePlanMenber(String valuePlanMenber) {
		this.valuePlanMenber = valuePlanMenber;
	}

}