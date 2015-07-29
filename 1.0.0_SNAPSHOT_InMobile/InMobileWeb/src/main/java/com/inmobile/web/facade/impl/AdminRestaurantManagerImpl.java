package com.inmobile.web.facade.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.canonical.bean.restaurant.CheckRestaurantActive;
import com.canonical.bean.restaurant.ListRestaurant;
import com.inmobile.web.bean.CheckRestaurantDTO;
import com.inmobile.web.bean.ReturnService;
import com.inmobile.web.facade.AdminRestaurantManager;
import com.inmobile.web.util.CommonConstants;
import com.inmobile.web.util.ConvertClassFormat;
import com.inmobile.web.util.UtilMethods;

@Service
public class AdminRestaurantManagerImpl implements AdminRestaurantManager {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminRestaurantManagerImpl.class);
	
	public ReturnService listRestaurantPending(){
		ReturnService beanReturnService=new ReturnService();
		RestTemplate restTemplate=new RestTemplate();
		ListRestaurant beanListRestaurant=restTemplate.getForObject(CommonConstants.URLService.URL_LIST_RESTAURANT_PENDING_ACTIVE, ListRestaurant.class);
		logger.info(UtilMethods.fromObjectToString(beanListRestaurant));
		if(CommonConstants.Response.RESPONSE_SUCCESS_LIST_RESTAURANT_PENDING_ACTIVE.equals(beanListRestaurant.getCodeResponse())){
			beanReturnService.setReturnPage(CommonConstants.Page.REDIRECT_LIST_USER_PENDING_ACTIVE);
			beanReturnService.setListRestaurantDTO(ConvertClassFormat.convertFromServiceToListRestaurantDTO(beanListRestaurant.getListRestaurantResponse()));
		}
		beanReturnService.setMessages(beanListRestaurant.getCodeResponse());
		return beanReturnService;
	}
	
	public ReturnService updateCheckRestaurant(CheckRestaurantDTO beanRestaurantDTO){
		ReturnService beanReturnService=new ReturnService();
		CheckRestaurantActive beanCheckRestAct=ConvertClassFormat.convertFromWebToServiceCheckRest(beanRestaurantDTO);
		RestTemplate restTemplate=new RestTemplate();
		CheckRestaurantActive beanResponse=restTemplate.postForObject(CommonConstants.URLService.URL_UPDATE_CHECK_REST, beanCheckRestAct, CheckRestaurantActive.class);
		if(CommonConstants.Response.RESPONSE_SUCCESS_CHECK_REST.equals(beanResponse.getCodeResponse())){
			beanReturnService.setReturnPage("listPendingActive.htm");
			beanReturnService.setSpecificMessages(beanResponse.getCodeResponse());
		}
		return beanReturnService;
	}
	
	
}
