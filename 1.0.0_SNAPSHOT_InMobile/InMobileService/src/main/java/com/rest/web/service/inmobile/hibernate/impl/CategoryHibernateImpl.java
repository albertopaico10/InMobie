package com.rest.web.service.inmobile.hibernate.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.web.service.inmobile.hibernate.CategoryHibernate;
import com.rest.web.service.inmobile.hibernate.bean.Category;

@Repository
public class CategoryHibernateImpl implements CategoryHibernate {
	
	@Autowired
	SessionFactory sessionfactory;
	
	public List<Category> listAllCategory() throws Exception {
		String query="from Category where status = 1 ";
		System.out.println("query : "+query);
		Session session=sessionfactory.openSession();
		
		List<Category> listCategory=session.createQuery(query).list();
		System.out.println("Cantidad de filas : "+listCategory.size());
		
		session.close();	
		return listCategory;
	}

}
