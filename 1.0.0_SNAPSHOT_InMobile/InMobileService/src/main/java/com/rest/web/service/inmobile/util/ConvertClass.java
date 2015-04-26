package com.rest.web.service.inmobile.util;

import com.rest.web.service.inmobile.bean.user.UserRequest;
import com.rest.web.service.inmobile.hibernate.bean.UserDB;

public class ConvertClass {

	public static UserDB convertUserRequestToDataBase(UserRequest beanRequest){
		UserDB userDataBase=new UserDB();
		userDataBase.setEmail(beanRequest.getEmail());
		userDataBase.setPasswordUser(UtilMethods.encriptedPassword(beanRequest.getPassword(), CommonConstants.EncriptedValues.ALGORITHM_MD5));
		userDataBase.setTypeUser(Integer.parseInt(beanRequest.getTypeCustomer()));
		return userDataBase;
	}
	
}
