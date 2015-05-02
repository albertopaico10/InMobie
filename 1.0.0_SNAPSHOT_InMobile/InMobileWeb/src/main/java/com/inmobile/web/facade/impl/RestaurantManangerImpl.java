package com.inmobile.web.facade.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.inmobile.web.bean.RestaurantDTO;
import com.inmobile.web.bean.ReturnService;
import com.inmobile.web.bean.canonical.restaurant.RestaurantRequest;
import com.inmobile.web.bean.canonical.restaurant.RestaurantResponse;
import com.inmobile.web.facade.RestaurantManager;
import com.inmobile.web.util.CommonConstants;
import com.inmobile.web.util.ConvertClassFormat;
import com.inmobile.web.util.UtilMethods;

@Service
public class RestaurantManangerImpl implements RestaurantManager {

	public ReturnService saveRestaurantInformation(RestaurantDTO beanDTO) {
		ReturnService benResponse=new ReturnService();
		RestTemplate restTemplate=new RestTemplate();
		
		RestaurantRequest beanRequest=ConvertClassFormat.convertWebToServiceRestaurant(beanDTO);
		System.out.println("Valor Request : "+UtilMethods.fromObjectToString(beanRequest));
		System.out.println("URL : "+CommonConstants.URLService.URL_SAVE_RESTAURANT);
		RestaurantResponse beanResponse=restTemplate.postForObject(CommonConstants.URLService.URL_SAVE_RESTAURANT, beanRequest, RestaurantResponse.class);
		System.out.println("Valor Request : "+UtilMethods.fromObjectToString(beanResponse));
//		if()
		
		
		return benResponse;
	}

}
