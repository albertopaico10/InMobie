package com.inmobile.web.facade;

import org.springframework.stereotype.Service;

import com.inmobile.web.bean.CheckRestaurantDTO;
import com.inmobile.web.bean.ReturnService;
@Service
public interface AdminManager {
	public ReturnService listRestaurantPending();
	public ReturnService updateCheckRestaurant(CheckRestaurantDTO beanRestaurantDTO);
}
