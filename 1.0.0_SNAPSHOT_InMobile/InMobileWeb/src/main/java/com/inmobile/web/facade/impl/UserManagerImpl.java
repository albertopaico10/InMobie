package com.inmobile.web.facade.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.inmobie.web.bean.RegisterUserDTO;
import com.inmobie.web.bean.ReturnService;
import com.inmobie.web.bean.canonical.user.UserRequest;
import com.inmobie.web.bean.canonical.user.UserResponse;
import com.inmobile.web.facade.UserManager;
import com.inmobile.web.util.CommonConstants;
import com.inmobile.web.util.ConvertClassFormat;
import com.inmobile.web.util.UtilMethods;

@Service
public class UserManagerImpl implements UserManager{

	public ReturnService registerUserInMobile(RegisterUserDTO beanUser) {
		ReturnService beanReturn=new ReturnService();
		RestTemplate restTemplate=new RestTemplate();
		UserRequest beanRequest=ConvertClassFormat.convertWebToServiceUser(beanUser);
		System.out.println("Valor Request : "+UtilMethods.fromObjectToString(beanRequest));
		UserResponse beanResponse=restTemplate.postForObject(CommonConstants.URLService.URL_REGISTER_USER, beanRequest, UserResponse.class);
		System.out.println("Valor Response : "+UtilMethods.fromObjectToString(beanResponse));
		if(CommonConstants.Response.RESPONSE_USER_SUCCESS.equals(beanResponse.getCodeResponse())){
			beanReturn.setReturnPage(CommonConstants.Page.REDIRECT_INIT_PAGE);
		}else if(CommonConstants.Response.RESPONSE_USER_EXIST.equals(beanResponse.getCodeResponse())||
				CommonConstants.Response.RESPONSE_USER_ERROR.equals(beanResponse.getCodeResponse())){
			beanReturn.setReturnPage(CommonConstants.Page.REDIRECT_LOGIN_PAGE);
			beanReturn.setSpecificMessages(beanResponse.getMessagesResponse());
		}
		beanReturn.setMessages(beanResponse.getCodeResponse());
		return beanReturn;
	}

	public ReturnService validateUser(RegisterUserDTO beanUser) {
		ReturnService beanReturn=new ReturnService();
		RestTemplate restTemplate=new RestTemplate();
		UserRequest beanRequest=ConvertClassFormat.convertWebToServiceUser(beanUser);
		System.out.println("Valor Request : "+UtilMethods.fromObjectToString(beanRequest));
		UserResponse beanResponse=restTemplate.postForObject(CommonConstants.URLService.URL_VALIDATION_USER, beanRequest, UserResponse.class);
		System.out.println("Valor Response : "+UtilMethods.fromObjectToString(beanResponse));
		if(CommonConstants.Response.RESPONSE_SUCCESS_VALIDATION.equals(beanResponse.getCodeResponse())){
			beanReturn.setReturnPage(CommonConstants.Page.REDIRECT_INIT_PAGE);
		}else if(CommonConstants.Response.RESPONSE_FAIL_VALIDATION.equals(beanResponse.getCodeResponse()) ||
				CommonConstants.Response.RESPONSE_NOT_EXITS_USER.equals(beanResponse.getCodeResponse())){
			beanReturn.setReturnPage(CommonConstants.Page.REDIRECT_LOGIN_PAGE);
		}
		beanReturn.setMessages(beanResponse.getCodeResponse());
		return beanReturn;
	}

	
	
}
