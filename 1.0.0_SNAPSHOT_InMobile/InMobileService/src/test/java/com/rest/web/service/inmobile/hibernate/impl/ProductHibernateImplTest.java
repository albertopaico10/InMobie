package com.rest.web.service.inmobile.hibernate.impl;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.rest.web.service.inmobile.hibernate.ProductHibernate;
import com.rest.web.service.inmobile.hibernate.bean.Product;

@ContextConfiguration(locations = {"/dispatcher-servlet.xml","/thread-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class ProductHibernateImplTest {

	@Autowired
	private ProductHibernate productHibernate;
	
	@Test
	public void insertProduct()throws Exception{
		System.out.println("Entre al test");
		Product beanProduct=new Product();
		beanProduct.setNameProduct("Pan Arabe desc");
		beanProduct.setDescriptionProduct("Rico Pan arabe");
		beanProduct.setCostProduct(new BigDecimal(9));
		beanProduct.setIdCategory(1);
		beanProduct.setIdPresentation(1);
		beanProduct.setStatus(1);
		beanProduct.setTotalStock(20);
		productHibernate.saveOrUpdateProduct(beanProduct);
	}
}
