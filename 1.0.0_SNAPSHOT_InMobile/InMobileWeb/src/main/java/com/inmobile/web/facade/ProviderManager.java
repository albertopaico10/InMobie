package com.inmobile.web.facade;

import org.springframework.stereotype.Service;

import com.inmobile.web.bean.ProviderDTO;
import com.inmobile.web.bean.ReturnService;

@Service
public interface ProviderManager {

	public ReturnService saveProviderInformation(ProviderDTO beanDTO);
	
}
