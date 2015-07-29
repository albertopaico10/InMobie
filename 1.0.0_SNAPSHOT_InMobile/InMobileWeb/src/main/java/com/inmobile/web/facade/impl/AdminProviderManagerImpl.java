package com.inmobile.web.facade.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.canonical.bean.provider.ListProvider;
import com.inmobile.web.bean.ReturnService;
import com.inmobile.web.facade.AdminProviderManager;
import com.inmobile.web.util.CommonConstants;
import com.inmobile.web.util.ConvertClassFormat;
import com.inmobile.web.util.UtilMethods;
@Service
public class AdminProviderManagerImpl implements AdminProviderManager {
	private static final Logger logger = LoggerFactory.getLogger(AdminProviderManagerImpl.class);
	
	public ReturnService listProviderPending() {
		ReturnService beanReturnService=new ReturnService();
		RestTemplate restTemplate=new RestTemplate();
		ListProvider beanListProvider=restTemplate.getForObject(CommonConstants.URLService.URL_LIST_PROVIDER_PENDING_ACTIVE, ListProvider.class);
		logger.info(UtilMethods.fromObjectToString(beanListProvider));
		if(CommonConstants.Response.RESPONSE_SUCCESS_LIST_PROVIDER_PENDING_ACTIVE.equals(beanListProvider.getCodeResponse())){
			beanReturnService.setReturnPage(CommonConstants.Page.REDIRECT_LIST_USER_PENDING_ACTIVE);
			beanReturnService.setListProviderDTO(ConvertClassFormat.convertFromServiceToListProviderDTO(beanListProvider.getListProviderResponse()));
		}
		beanReturnService.setMessages(beanListProvider.getCodeResponse());
		return beanReturnService;
	}

}
