package com.rest.web.service.inmobile.hibernate;

import java.util.List;

import com.rest.web.service.inmobile.hibernate.bean.Product;

public interface ProductHibernate {

	public List<Product> listAllProduct()throws Exception;
	public int saveOrUpdateProduct(Product beanProduct)throws Exception;
	public Product productSpecific(int idProduct)throws Exception;
}
