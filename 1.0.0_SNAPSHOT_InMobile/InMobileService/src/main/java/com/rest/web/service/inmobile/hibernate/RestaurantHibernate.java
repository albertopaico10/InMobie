package com.rest.web.service.inmobile.hibernate;

import java.util.List;

import com.rest.web.service.inmobile.hibernate.bean.ClientRestaurant;
import com.rest.web.service.inmobile.hibernate.bean.User;

public interface RestaurantHibernate {

	public void saveRestaurant(ClientRestaurant beanRequest)throws Exception;
	public ClientRestaurant getDataRestaurantByUserId(int idUser)throws Exception;
	public List<ClientRestaurant> listRestaurantPendingActive()throws Exception;
	public int findUserByIdRestaurant(int idRestaurant)throws Exception;
	public User getUserByIdRestaurant(int idRestaurant)throws Exception;
}
