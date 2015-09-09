package com.rest.web.service.inmobile.hibernate;

import java.util.List;

import com.rest.web.service.inmobile.hibernate.bean.Category;

public interface CategoryHibernate {
	public List<Category> listAllCategory()throws Exception; 
}
