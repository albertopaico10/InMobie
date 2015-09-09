package com.rest.web.service.inmobile.hibernate.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.web.service.inmobile.hibernate.SchedulerRestaurantHibernate;
import com.rest.web.service.inmobile.hibernate.bean.SchedulerRestaurant;

@Repository
public class SchedulerRestaurantHibernateImpl implements SchedulerRestaurantHibernate{

	@Autowired
	SessionFactory sessionfactory;
	
	public void saveSchedulerRestaurant(SchedulerRestaurant beanScheduler)throws Exception {
		System.out.println("Grabar Restaurant");
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.saveOrUpdate(beanScheduler);
		System.out.println("Last ID : "+beanScheduler.getId());
		
		transaction.commit();
		session.close();
		
	}

}
