package com.rest.web.service.inmobile.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rest.web.service.inmobile.bean.restaurant.DistrictProviderRequest;
import com.rest.web.service.inmobile.bean.restaurant.DistrictProviderResponse;
import com.rest.web.service.inmobile.bean.restaurant.ProviderRequest;
import com.rest.web.service.inmobile.bean.restaurant.ProviderResponse;
import com.rest.web.service.inmobile.facade.ProviderManager;
import com.rest.web.service.inmobile.util.CommonConstants;

@Controller
public class ProviderController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private ProviderManager objProviderManager;
	
	@RequestMapping(value = CommonConstants.ValueRequestMapping.SAVE_PROVIDER, method = RequestMethod.POST)
	public @ResponseBody ProviderResponse saveRestaurantInformation(@RequestBody ProviderRequest objProviderRequest) {
		logger.info("Start saveProdider.");
		logger.info("Correo : "+objProviderRequest.getNameContact()+"** Password : "+objProviderRequest.getNameProvider());
		ProviderResponse objProviderResponse = objProviderManager.saveProvider(objProviderRequest);
		return objProviderResponse;
	}
	
	@RequestMapping(value = CommonConstants.ValueRequestMapping.ADD_DISTRICT_PROVIDER, method = RequestMethod.POST)
	public @ResponseBody DistrictProviderResponse saveDistrictProviderInformation(@RequestBody DistrictProviderRequest objDistrictProviderRequest) {
		logger.info("Start saveDistrictProviderInformation.");
		DistrictProviderResponse objDistrictProviderResponse = objProviderManager.saveDistrictProvider(objDistrictProviderRequest);
		return objDistrictProviderResponse;
	}
}
