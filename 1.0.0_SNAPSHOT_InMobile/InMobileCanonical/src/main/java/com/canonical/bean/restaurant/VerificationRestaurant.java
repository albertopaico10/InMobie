package com.canonical.bean.restaurant;

import java.util.List;

import com.canonical.bean.planmember.BeanPlanMember;


public class VerificationRestaurant {
	public CheckRestaurantActive beanCheckRestaurantActive;
	public List<BeanPlanMember> listPlanMenber;
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
	public List<BeanPlanMember> getListPlanMenber() {
		return listPlanMenber;
	}
	public void setListPlanMenber(List<BeanPlanMember> listPlanMenber) {
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
