package com.rest.web.service.inmobile.hibernate.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.web.service.inmobile.hibernate.CheckActiveProviderHibernate;
import com.rest.web.service.inmobile.hibernate.bean.CheckActiveProvider;
@Repository
public class CheckActiveProviderHibernateImpl implements CheckActiveProviderHibernate {
	@Autowired
	SessionFactory sessionfactory;
	
	public int saveProviderCheckActivation(CheckActiveProvider beanData) throws Exception {
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.saveOrUpdate(beanData);
		System.out.println("Last ID : "+beanData.getId());
		
		transaction.commit();
		session.close();
		return beanData.getId();
	}
	


}
