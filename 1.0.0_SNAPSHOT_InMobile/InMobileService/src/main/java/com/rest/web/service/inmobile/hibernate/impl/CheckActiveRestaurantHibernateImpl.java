package com.rest.web.service.inmobile.hibernate.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.web.service.inmobile.hibernate.CheckActiveRestaurantHibernate;
import com.rest.web.service.inmobile.hibernate.bean.CheckActiveRestaurant;
import com.rest.web.service.inmobile.hibernate.bean.Image;
@Repository
public class CheckActiveRestaurantHibernateImpl implements CheckActiveRestaurantHibernate{

	@Autowired
	SessionFactory sessionfactory;
	
	public int saveCheckActiveRestaurant(CheckActiveRestaurant beanData) throws Exception {
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.saveOrUpdate(beanData);
		System.out.println("Last ID : "+beanData.getId());
		
		transaction.commit();
		session.close();
		return beanData.getId();
	}

	public CheckActiveRestaurant getCheckActiveRestaurant(int idRestaurant) throws Exception {
		CheckActiveRestaurant beanCheck=null;
		String query="from CheckActiveRestaurant where idRestaurant='"+idRestaurant+"'";
		System.out.println("query : "+query);
		Session session=sessionfactory.openSession();
		
		List<CheckActiveRestaurant> listCheckRestaurant=session.createQuery(query).list();
		System.out.println("Cantidad de filas : "+listCheckRestaurant.size());
		
		session.close();
		if(listCheckRestaurant.size()>0){
			beanCheck=listCheckRestaurant.get(0);
		}
		return beanCheck;
	}

}
