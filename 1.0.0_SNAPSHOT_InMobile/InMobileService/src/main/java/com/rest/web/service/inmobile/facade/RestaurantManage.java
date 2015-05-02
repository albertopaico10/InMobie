package com.rest.web.service.inmobile.facade;

import org.springframework.stereotype.Service;

import com.rest.web.service.inmobile.bean.restaurant.RestaurantRequest;
import com.rest.web.service.inmobile.bean.restaurant.RestaurantResponse;

@Service
public interface RestaurantManage {

	public RestaurantResponse saveRestaurant(RestaurantRequest beanRequest);
	
}
