package com.rest.web.service.inmobile.hibernate.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.web.service.inmobile.hibernate.PresentationHibernate;
import com.rest.web.service.inmobile.hibernate.bean.Presentation;

@Repository
public class PresentationHibernateImpl implements PresentationHibernate {
	
	@Autowired
	SessionFactory sessionfactory;
	
	public List<Presentation> listAllPresentation() throws Exception {
		String query="from Presentation where status = 1 ";
		System.out.println("query : "+query);
		Session session=sessionfactory.openSession();
		
		List<Presentation> listPresentation=session.createQuery(query).list();
		System.out.println("Cantidad de filas : "+listPresentation.size());
		
		session.close();	
		return listPresentation;
	}

}
