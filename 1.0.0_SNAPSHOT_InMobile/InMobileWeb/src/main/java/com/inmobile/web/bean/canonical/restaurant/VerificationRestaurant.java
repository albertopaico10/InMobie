package com.inmobile.web.bean.canonical.restaurant;

import java.util.List;

import com.inmobile.web.bean.canonical.planmember.PlanMember;

public class VerificationRestaurant {
	public CheckRestaurantActive beanCheckRestaurantActive;
	public List<PlanMember> listPlanMenber;
	private String codeResponse;
	private String messagesResponse;
	private String description;
	
	public CheckRestaurantActive getBeanCheckRestaurantActive() {
		return beanCheckRestaurantActive;
	}
	public void setBeanCheckRestaurantActive(
			CheckRestaurantActive beanCheckRestaurantActive) {
		this.beanCheckRestaurantActive = beanCheckRestaurantActive;
	}
	public List<PlanMember> getListPlanMenber() {
		return listPlanMenber;
	}
	public void setListPlanMenber(List<PlanMember> listPlanMenber) {
		this.listPlanMenber = listPlanMenber;
	}
	public String getCodeResponse() {
		return codeResponse;
	}
	public void setCodeResponse(String codeResponse) {
		this.codeResponse = codeResponse;
	}
	public String getMessagesResponse() {
		return messagesResponse;
	}
	public void setMessagesResponse(String messagesResponse) {
		this.messagesResponse = messagesResponse;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
