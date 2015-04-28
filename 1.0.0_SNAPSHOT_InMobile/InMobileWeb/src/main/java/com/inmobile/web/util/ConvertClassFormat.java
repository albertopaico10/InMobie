package com.inmobile.web.util;

import com.inmobie.web.bean.RegisterUserDTO;
import com.inmobie.web.bean.canonical.user.UserRequest;

public class ConvertClassFormat {

	public static UserRequest convertWebToServiceUser(RegisterUserDTO registerUser){
		UserRequest userRequest=new UserRequest();
		userRequest.setEmail(registerUser.getUser());
		userRequest.setPassword(UtilMethods.encriptedPassword(registerUser.getPassword(),CommonConstants.EncriptedValues.ALGORITHM_MD5));
		userRequest.setTypeCustomer(registerUser.getTypeUser());
		return userRequest;
	}
	
}
