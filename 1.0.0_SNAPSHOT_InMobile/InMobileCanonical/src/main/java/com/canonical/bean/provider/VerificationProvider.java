package com.canonical.bean.provider;

import java.util.List;

import com.canonical.bean.AbstractClass;
import com.canonical.bean.planmember.BeanPlanMember;

public class VerificationProvider extends AbstractClass {
	private CheckProviderActive beanCheckProviderActive;
	public List<BeanPlanMember> listPlanMenber;
	public CheckProviderActive getBeanCheckProviderActive() {
		return beanCheckProviderActive;
	}
	public void setBeanCheckProviderActive(
			CheckProviderActive beanCheckProviderActive) {
		this.beanCheckProviderActive = beanCheckProviderActive;
	}
	public List<BeanPlanMember> getListPlanMenber() {
		return listPlanMenber;
	}
	public void setListPlanMenber(List<BeanPlanMember> listPlanMenber) {
		this.listPlanMenber = listPlanMenber;
	}
	
}
