package com.rest.web.service.inmobile.hibernate.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.web.service.inmobile.hibernate.ProviderHibernate;
import com.rest.web.service.inmobile.hibernate.bean.Provider;

@Repository
public class ProviderHibernateImpl implements ProviderHibernate {
	
	@Autowired
	SessionFactory sessionfactory;

	public void saveProvider(Provider objProvider) throws Exception {
		System.out.println("Grabar Proveedor");
		Session session = sessionfactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(objProvider);
		System.out.println("Last ID : "+objProvider.getId());
		transaction.commit();
		session.close();
	}
	
}
