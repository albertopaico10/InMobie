package com.rest.web.service.inmobile.hibernate.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.web.service.inmobile.hibernate.RestaurantHibernate;
import com.rest.web.service.inmobile.hibernate.bean.Restaurant;
import com.rest.web.service.inmobile.hibernate.bean.User;

@Repository
public class RestaurantHibernateImpl implements RestaurantHibernate {
	
	@Autowired
	SessionFactory sessionfactory;

	public void saveRestaurant(Restaurant beanRequest) throws Exception {
		System.out.println("Grabar o actualizar Restaurant");
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.saveOrUpdate(beanRequest);
		System.out.println("Last ID : "+beanRequest.getId());
		
		transaction.commit();
		session.close();
	}

	public Restaurant getDataRestaurantByUserId(int idUser) throws Exception {
		Restaurant restaurantBean=null;
		String query="from Restaurant where status=1 and idUser='"+idUser+"'";
		System.out.println("query : "+query);
		Session session=sessionfactory.openSession();
		
		List<Restaurant> listRestaurantSpecific=session.createQuery(query).list();
		System.out.println("Cantidad de filas : "+listRestaurantSpecific.size());
		
		session.close();
		if(listRestaurantSpecific.size()>0){
			restaurantBean=listRestaurantSpecific.get(0);
		}
		return restaurantBean;
	}

	public List<Restaurant> listRestaurantPendingActive()throws Exception {
		List<Restaurant> listRestaurant=new ArrayList<Restaurant>();
		
		String query="from User where status=3";
		System.out.println("query : "+query);
		Session session=sessionfactory.openSession();
		
		List<User> listUserSpecific=session.createQuery(query).list();
		System.out.println("Cantidad de filas : "+listUserSpecific.size());
		
		if(listUserSpecific.size()>0){
			for(User beanUser:listUserSpecific){
				String queryRestaurant="from Restaurant where idUser="+beanUser.getId();
				System.out.println("query #2 : "+queryRestaurant);
				List<Restaurant> listRestaurantSpecific=session.createQuery(queryRestaurant).list();
				for(Restaurant beanListRest:listRestaurantSpecific){
					listRestaurant.add(beanListRest);
				}
			}
		}
		session.close();
		return listRestaurant;
	}
	
	public int findUserByIdRestaurant(int idRestaurant)throws Exception{
		Restaurant restaurantBean=null;
		String query="from Restaurant where status=1 and id='"+idRestaurant+"'";
		System.out.println("query : "+query);
		Session session=sessionfactory.openSession();
		
		List<Restaurant> listSpecificById=session.createQuery(query).list();
		System.out.println("Cantidad de filas : "+listSpecificById.size());
		if(listSpecificById.size()>0){
			restaurantBean=listSpecificById.get(0);
		}		
		return restaurantBean.getIdUser();
	}
	
	public User getUserByIdRestaurant(int idRestaurant)throws Exception{
		User userBean=null;
		String query="from Restaurant where status=1 and id='"+idRestaurant+"'";
		System.out.println("query : "+query);
		Session session=sessionfactory.openSession();
		
		List<Restaurant> listSpecificById=session.createQuery(query).list();
		System.out.println("Cantidad de filas : "+listSpecificById.size());
		if(listSpecificById.size()>0){
			String queryUser="from User where id='"+listSpecificById.get(0).getIdUser()+"'";
			System.out.println("query #2 : "+queryUser);
			List<User> listUserSpecific=session.createQuery(queryUser).list();
			userBean=listUserSpecific.get(0);
		}		
		return userBean;
	}
	
	
}
