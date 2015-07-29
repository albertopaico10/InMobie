package com.rest.web.service.inmobile.facade;

import org.springframework.stereotype.Service;

import com.canonical.bean.restaurant.CheckRestaurantActive;
import com.canonical.bean.restaurant.ListRestaurant;
import com.canonical.bean.restaurant.RestaurantRequest;
import com.canonical.bean.restaurant.RestaurantResponse;
import com.canonical.bean.restaurant.SchedulerRestaurantRequest;
import com.canonical.bean.restaurant.SchedulerRestaurantResponse;
import com.canonical.bean.restaurant.VerificationRestaurant;


@Service
public interface RestaurantManage {

	public RestaurantResponse saveRestaurant(RestaurantRequest beanRequest);
	public SchedulerRestaurantResponse saveRestaurantScheduler(SchedulerRestaurantRequest beanRequest);
	public ListRestaurant listRestaurantPendingActive();
	public VerificationRestaurant getVerificationRestaurant(int idRestaurant);
	public CheckRestaurantActive updateCheckRestaurant(CheckRestaurantActive beanRequest);
}
