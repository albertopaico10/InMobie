package com.rest.web.service.inmobile.hibernate;

import com.rest.web.service.inmobile.hibernate.bean.ClientRestaurant;

public interface RestaurantHibernate {

	public void saveRestaurant(ClientRestaurant beanRequest)throws Exception;
}
