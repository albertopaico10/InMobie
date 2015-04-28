package com.inmobile.web.facade;

import org.springframework.stereotype.Service;

import com.inmobie.web.bean.RegisterUserDTO;
import com.inmobie.web.bean.ReturnService;

@Service
public interface UserManager {

	public ReturnService registerUserInMobile(RegisterUserDTO beanUser);
	public ReturnService validateUser(RegisterUserDTO beanUser);
	
}
