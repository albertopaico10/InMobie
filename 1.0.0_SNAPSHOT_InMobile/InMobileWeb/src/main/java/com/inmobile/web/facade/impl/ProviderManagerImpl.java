package com.inmobile.web.facade.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.inmobile.web.bean.ProviderDTO;
import com.inmobile.web.bean.ReturnService;
import com.inmobile.web.bean.canonical.restaurant.ProviderRequest;
import com.inmobile.web.bean.canonical.restaurant.ProviderResponse;
import com.inmobile.web.facade.ProviderManager;
import com.inmobile.web.util.CommonConstants;
import com.inmobile.web.util.ConvertClassFormat;
import com.inmobile.web.util.UtilMethods;

@Service
public class ProviderManagerImpl implements ProviderManager{

	public ReturnService saveProviderInformation(ProviderDTO beanDTO) {
		ReturnService benResponse = new ReturnService();
		RestTemplate restTemplate = new RestTemplate();
		
		ProviderRequest beanRequest = ConvertClassFormat.convertWebToServiceProvider(beanDTO);
		System.out.println("Valor Request : "+UtilMethods.fromObjectToString(beanRequest));
		System.out.println("URL : "+CommonConstants.URLService.URL_SAVE_PROVIDER);
		ProviderResponse beanResponse = restTemplate.postForObject(CommonConstants.URLService.URL_SAVE_PROVIDER, beanRequest, ProviderResponse.class);
		System.out.println("Valor Request : "+UtilMethods.fromObjectToString(beanResponse));
		
		return benResponse;
	}

}
