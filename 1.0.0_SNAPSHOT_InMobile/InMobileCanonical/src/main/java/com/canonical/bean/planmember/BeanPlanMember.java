package com.canonical.bean.planmember;

import com.canonical.bean.AbstractClass;

public class BeanPlanMember extends AbstractClass {
	private int id;
	private int status;
	private String valuePlanMenber;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getValuePlanMenber() {
		return valuePlanMenber;
	}
	public void setValuePlanMenber(String valuePlanMenber) {
		this.valuePlanMenber = valuePlanMenber;
	}	
}
