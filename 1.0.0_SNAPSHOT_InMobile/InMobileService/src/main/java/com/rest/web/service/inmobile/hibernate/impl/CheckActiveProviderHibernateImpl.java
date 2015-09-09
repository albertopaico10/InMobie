package com.rest.web.service.inmobile.hibernate.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.web.service.inmobile.hibernate.CheckActiveProviderHibernate;
import com.rest.web.service.inmobile.hibernate.bean.CheckActiveProvider;
import com.rest.web.service.inmobile.hibernate.bean.CheckActiveRestaurant;
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
	
	public CheckActiveProvider getCheckActiveProvider(int idProvider) throws Exception {
		CheckActiveProvider beanCheck=null;
		String query="from CheckActiveProvider where idProvider='"+idProvider+"'";
		System.out.println("query : "+query);
		Session session=sessionfactory.openSession();
		
		List<CheckActiveProvider> listCheck=session.createQuery(query).list();
		System.out.println("Cantidad de filas : "+listCheck.size());
		
		session.close();
		if(listCheck.size()>0){
			beanCheck=listCheck.get(0);
		}
		return beanCheck;
	}

}
