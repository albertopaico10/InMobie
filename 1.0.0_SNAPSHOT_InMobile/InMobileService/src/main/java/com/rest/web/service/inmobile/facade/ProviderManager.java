package com.rest.web.service.inmobile.facade;

import org.springframework.stereotype.Service;

import com.rest.web.service.inmobile.bean.restaurant.ProviderRequest;
import com.rest.web.service.inmobile.bean.restaurant.ProviderResponse;

@Service
public interface ProviderManager {

	public ProviderResponse saveProvider(ProviderRequest objProviderRequest);
	
}
