package com.rest.web.service.inmobile.hibernate.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.rest.web.service.inmobile.hibernate.UserHibernate;
import com.rest.web.service.inmobile.hibernate.bean.User;

@ContextConfiguration(locations = {"/dispatcher-servlet.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class UserHibernateImplTest {
	
	@Autowired
	private UserHibernate userHibernate;
	
	@Test
	public void UserBeanLast()throws Exception{
		int idUser=userHibernate.findLastUser();
		System.out.println("Ultimo Valor : "+idUser);
	}
	
	@Test
	public void ExistEmail()throws Exception{
		boolean userDB=userHibernate.existEmail("alberto_j10@hotmail.com");
		Assert.assertEquals(true, userDB);
	}
}
