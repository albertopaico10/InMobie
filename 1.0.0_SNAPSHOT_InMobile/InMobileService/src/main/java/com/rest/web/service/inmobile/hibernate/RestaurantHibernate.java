package com.rest.web.service.inmobile.hibernate;

import java.util.List;

import com.rest.web.service.inmobile.hibernate.bean.Restaurant;
import com.rest.web.service.inmobile.hibernate.bean.User;

public interface RestaurantHibernate {

	public void saveRestaurant(Restaurant beanRequest)throws Exception;
	public Restaurant getDataRestaurantByUserId(int idUser)throws Exception;
	public List<Restaurant> listRestaurantPendingActive()throws Exception;
	public int findUserByIdRestaurant(int idRestaurant)throws Exception;
	public User getUserByIdRestaurant(int idRestaurant)throws Exception;
}
