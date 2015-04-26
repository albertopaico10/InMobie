package com.rest.web.service.inmobile.hibernate.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.web.service.inmobile.hibernate.UserHibernate;
import com.rest.web.service.inmobile.hibernate.bean.UserDB;

@Service
public class UserHibernateImpl implements UserHibernate {
	
	@Autowired
	SessionFactory sessionfactory;
	
	public void saveUserDataBase(UserDB userBean) throws Exception {
		userBean.setStatus(1);
		sessionfactory.getCurrentSession().saveOrUpdate(userBean);
	}

	public int saveUserResponseId(UserDB userBean) throws Exception {
		userBean.setStatus(1);
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(userBean);
		System.out.println("Last ID : "+userBean.getId());
		
		transaction.commit();
		session.close();
		return 0;
	}
	
	public int findLastUser()throws Exception {
		String query="select max(id) from UserDB where status=1";
		System.out.println("query : "+query);
		Session session=sessionfactory.openSession();
		
		List<Integer> listSpecificById=session.createQuery(query).list();
		System.out.println("Cantidad de filas : "+listSpecificById.size());
		
		session.close();
				
		return listSpecificById.get(0);
	}
	
	public boolean existEmail(String email)throws Exception{
		boolean validateEmail=false;
		String query="from UserDB where status=1 and email='"+email+"'";
		System.out.println("query : "+query);
		Session session=sessionfactory.openSession();
		
		List<UserDB> listSpecificById=session.createQuery(query).list();
		System.out.println("Cantidad de filas : "+listSpecificById.size());
		
		session.close();
		if(listSpecificById.size()>0){
			validateEmail=true;
		}				
		return validateEmail;
	}

}
