package com.rest.web.service.inmobile.hibernate;

import java.util.List;

import com.rest.web.service.inmobile.hibernate.bean.PlanMember;

public interface PlanMemberHibernate {

	public List<PlanMember> listAllPlanMember()throws Exception;
	
}
