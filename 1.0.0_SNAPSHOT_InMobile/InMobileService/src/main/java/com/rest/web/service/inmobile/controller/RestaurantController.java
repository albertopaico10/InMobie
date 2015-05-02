package com.rest.web.service.inmobile.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rest.web.service.inmobile.bean.restaurant.RestaurantRequest;
import com.rest.web.service.inmobile.bean.restaurant.RestaurantResponse;
import com.rest.web.service.inmobile.facade.RestaurantManage;
import com.rest.web.service.inmobile.util.CommonConstants;

@Controller
public class RestaurantController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private RestaurantManage restaurantManager;
	
	@RequestMapping(value = CommonConstants.ValueRequestMapping.SAVE_RESTAURANT, method = RequestMethod.POST)
	public @ResponseBody RestaurantResponse saveRestaurantInformation(@RequestBody RestaurantRequest beanRequest) {
		logger.info("Start saveRestaurantInformation.");
		logger.info("Correo : "+beanRequest.getNameContact()+"** Password : "+beanRequest.getNameRestaurant());
		RestaurantResponse beanResponse=restaurantManager.saveRestaurant(beanRequest);
		return beanResponse;
	}
}
