package com.inmobile.web.facade;

import org.springframework.stereotype.Service;

import com.inmobile.web.bean.CheckProviderDTO;
import com.inmobile.web.bean.ReturnService;

@Service
public interface AdminProviderManager {
	public ReturnService listProviderPending();
	public ReturnService updateCheckProvider(CheckProviderDTO beanProviderDTO);
}
