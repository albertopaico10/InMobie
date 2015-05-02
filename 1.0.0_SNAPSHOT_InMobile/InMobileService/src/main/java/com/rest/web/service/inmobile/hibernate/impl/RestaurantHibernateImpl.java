package com.rest.web.service.inmobile.hibernate.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.web.service.inmobile.hibernate.RestaurantHibernate;
import com.rest.web.service.inmobile.hibernate.bean.ClientRestaurant;

@Repository
public class RestaurantHibernateImpl implements RestaurantHibernate {
	
	@Autowired
	SessionFactory sessionfactory;

	public void saveRestaurant(ClientRestaurant beanRequest) throws Exception {
		System.out.println("Grabar Restaurant");
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.saveOrUpdate(beanRequest);
		System.out.println("Last ID : "+beanRequest.getId());
		
		transaction.commit();
		session.close();
	}
	
	
}
