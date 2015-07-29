package com.rest.web.service.inmobile.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.canonical.bean.restaurant.CheckRestaurantActive;
import com.canonical.bean.restaurant.ListRestaurant;
import com.canonical.bean.restaurant.RestaurantRequest;
import com.canonical.bean.restaurant.RestaurantResponse;
import com.canonical.bean.restaurant.SchedulerRestaurantRequest;
import com.canonical.bean.restaurant.SchedulerRestaurantResponse;
import com.canonical.bean.restaurant.VerificationRestaurant;
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
	
	@RequestMapping(value = CommonConstants.ValueRequestMapping.SAVE_RESTAURANT_SCHEDULER, method = RequestMethod.POST)
	public @ResponseBody SchedulerRestaurantResponse saveRestaurantSchedulerInformation(@RequestBody SchedulerRestaurantRequest beanRequest) {
		logger.info("Start saveRestaurantSchedulerInformation.");
		SchedulerRestaurantResponse beanResponse=restaurantManager.saveRestaurantScheduler(beanRequest);
		return beanResponse;
	}
	
	@RequestMapping(value = CommonConstants.ValueRequestMapping.LIST_RESTAURANT_PENDING_ACTIVE, method = RequestMethod.GET)
	public @ResponseBody ListRestaurant getListRestaurantPending() {
		logger.info(CommonConstants.Logger.LOGGER_START+"Start getListProvince ID=");
		ListRestaurant beanResponse=restaurantManager.listRestaurantPendingActive();
		return beanResponse;
	}
	
	@RequestMapping(value = CommonConstants.ValueRequestMapping.VERIFICATION_RESTAURANT, method = RequestMethod.GET)
	public @ResponseBody VerificationRestaurant getVerificationRest(@PathVariable("id") int idRestaurant) {
		logger.info(CommonConstants.Logger.LOGGER_START+"Start getVerificationRest ID="+idRestaurant);
		VerificationRestaurant beanResponse=restaurantManager.getVerificationRestaurant(idRestaurant);
		return beanResponse;
	}
	
	@RequestMapping(value = CommonConstants.ValueRequestMapping.SAVE_CHECK_RESTAURANT, method = RequestMethod.POST)
	public @ResponseBody CheckRestaurantActive saveCheckRestaurant(@RequestBody CheckRestaurantActive beanRequest) {
		logger.info("Start saveCheckRestaurant.");
		CheckRestaurantActive beanResponse=restaurantManager.updateCheckRestaurant(beanRequest);
		return beanResponse;
	}
}
