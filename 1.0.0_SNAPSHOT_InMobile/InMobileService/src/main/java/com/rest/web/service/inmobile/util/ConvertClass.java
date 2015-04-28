package com.rest.web.service.inmobile.util;

import com.rest.web.service.inmobile.bean.user.UserRequest;
import com.rest.web.service.inmobile.hibernate.bean.User;

public class ConvertClass {

	public static User convertUserRequestToDataBase(UserRequest beanRequest){
		User userDataBase=new User();
		userDataBase.setEmail(beanRequest.getEmail());
		userDataBase.setPasswordUser(beanRequest.getPassword());
		userDataBase.setTypeUser(Integer.parseInt(beanRequest.getTypeCustomer()));
		return userDataBase;
	}
	
}
