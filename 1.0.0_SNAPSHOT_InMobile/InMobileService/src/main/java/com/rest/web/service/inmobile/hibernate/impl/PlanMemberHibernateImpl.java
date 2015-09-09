package com.rest.web.service.inmobile.hibernate.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.web.service.inmobile.hibernate.PlanMemberHibernate;
import com.rest.web.service.inmobile.hibernate.bean.PlanMember;

@Repository
public class PlanMemberHibernateImpl implements PlanMemberHibernate {

	@Autowired
	SessionFactory sessionfactory;
	
	public List<PlanMember> listAllPlanMember() throws Exception {
		String query="from PlanMember where status = 1 ";
		System.out.println("query : "+query);
		Session session=sessionfactory.openSession();
		
		List<PlanMember> listPlanMember=session.createQuery(query).list();
		System.out.println("Cantidad de filas : "+listPlanMember.size());
		session.close();
		return listPlanMember;
	}

}
