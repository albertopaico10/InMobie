package com.rest.web.service.inmobile.facade;

import org.springframework.stereotype.Service;

import com.rest.web.service.inmobile.bean.restaurant.CheckRestaurantActive;
import com.rest.web.service.inmobile.bean.restaurant.ListRestaurant;
import com.rest.web.service.inmobile.bean.restaurant.RestaurantRequest;
import com.rest.web.service.inmobile.bean.restaurant.RestaurantResponse;
import com.rest.web.service.inmobile.bean.restaurant.SchedulerRestaurantRequest;
import com.rest.web.service.inmobile.bean.restaurant.SchedulerRestaurantResponse;
import com.rest.web.service.inmobile.bean.restaurant.VerificationRestaurant;

@Service
public interface RestaurantManage {

	public RestaurantResponse saveRestaurant(RestaurantRequest beanRequest);
	public SchedulerRestaurantResponse saveRestaurantScheduler(SchedulerRestaurantRequest beanRequest);
	public ListRestaurant listRestaurantPendingActive();
	public VerificationRestaurant getVerificationRestaurant(int idRestaurant);
	public CheckRestaurantActive updateCheckRestaurant(CheckRestaurantActive beanRequest);
}
