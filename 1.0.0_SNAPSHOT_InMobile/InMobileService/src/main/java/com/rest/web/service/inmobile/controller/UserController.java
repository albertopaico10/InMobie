package com.rest.web.service.inmobile.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.canonical.bean.user.UserRequest;
import com.canonical.bean.user.UserResponse;
import com.rest.web.service.inmobile.facade.UserManager;
import com.rest.web.service.inmobile.util.CommonConstants;

@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserManager userManager;
	
	@RequestMapping(value = CommonConstants.ValueRequestMapping.CREATE_USER, method = RequestMethod.POST)
	public @ResponseBody UserResponse createUser(@RequestBody UserRequest beanRequest) {
		logger.info("Start createEmployee.");
		logger.info("Correo : "+beanRequest.getEmail()+"** Password : "+beanRequest.getPassword());
		UserResponse beanResponse=userManager.saveUserInformation(beanRequest);
		return beanResponse;
	}
	
	@RequestMapping(value = CommonConstants.ValueRequestMapping.VALIDATE_USER, method = RequestMethod.POST)
	public @ResponseBody UserResponse validateUser(@RequestBody UserRequest beanRequest) {
		logger.info("Start validateUser.");
		logger.info("Correo : "+beanRequest.getEmail()+"** Password : "+beanRequest.getPassword());
		UserResponse beanResponse=userManager.validateUser(beanRequest);
		return beanResponse;
	}
	
	@RequestMapping(value = CommonConstants.ValueRequestMapping.ACTIVATE_USER, method = RequestMethod.POST)
	public @ResponseBody UserResponse getActivateAccount(@RequestBody UserRequest beanRequest) {
		logger.info("Start getTypeUser. "+beanRequest.getEncriptUser());
		UserResponse beanResponse=userManager.activeAccount(beanRequest.getEncriptUser());
		return beanResponse;
	}
}
