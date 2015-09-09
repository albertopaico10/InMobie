package com.rest.web.service.inmobile.hibernate.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.web.service.inmobile.hibernate.ProductHibernate;
import com.rest.web.service.inmobile.hibernate.bean.Product;

@Repository
public class ProductHibernateImpl implements ProductHibernate {

	@Autowired
	SessionFactory sessionfactory;
	
	public List<Product> listAllProduct() throws Exception {
		String query="from Product where status = 1 ";
		System.out.println("query : "+query);
		Session session=sessionfactory.openSession();
		
		List<Product> listProduct=session.createQuery(query).list();
		System.out.println("Cantidad de filas : "+listProduct.size());
		
		session.close();	
		return listProduct;
	}

	public int saveOrUpdateProduct(Product beanProduct) {
		int idProduct=0;
		try {
			System.out.println("Grabar Producto");

			Session session=sessionfactory.openSession();
			if(session.isOpen()){
				System.out.println("Esta abierta");
			}else{
				System.out.println("No esta abierta");
			}
			Transaction transaction=session.beginTransaction();
			System.out.println("Pase el transaction");
			session.saveOrUpdate(beanProduct);
			System.out.println("Gravo????");
			System.out.println("Last ID : "+beanProduct.getId());
			
			transaction.commit();
			session.close();
			
			idProduct=beanProduct.getId();
		} catch (Exception e) {
			System.out.println("Error : "+e.getMessage());
			e.printStackTrace();
		}
		
		return idProduct;
	}

	public Product productSpecific(int idProduct) throws Exception {
		Product beanProduct=new Product();
		String query="from Product where status = 1 and id='"+idProduct+"'";
		System.out.println("query : "+query);
		Session session=sessionfactory.openSession();
		
		List<Product> listProduct=session.createQuery(query).list();
		if(listProduct.size()>0){
			beanProduct=listProduct.get(0);
		}
		return beanProduct;
	}

}
