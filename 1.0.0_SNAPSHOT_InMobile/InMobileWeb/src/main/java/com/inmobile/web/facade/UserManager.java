package com.inmobile.web.facade;

import org.springframework.stereotype.Service;

import com.inmobile.web.bean.RegisterUserDTO;
import com.inmobile.web.bean.ReturnService;

@Service
public interface UserManager {

	public ReturnService registerUserInMobile(RegisterUserDTO beanUser);
	public ReturnService validateUser(RegisterUserDTO beanUser);
	public ReturnService activeAccountUser(String idUser);
}
