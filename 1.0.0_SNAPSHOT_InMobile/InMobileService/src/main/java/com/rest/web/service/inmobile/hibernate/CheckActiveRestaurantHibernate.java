package com.rest.web.service.inmobile.hibernate;

import com.rest.web.service.inmobile.hibernate.bean.CheckActiveRestaurant;

public interface CheckActiveRestaurantHibernate {

	public int saveCheckActiveRestaurant(CheckActiveRestaurant beanData) throws Exception;
	
	public CheckActiveRestaurant getCheckActiveRestaurant(int idRestaurant) throws Exception;
}
