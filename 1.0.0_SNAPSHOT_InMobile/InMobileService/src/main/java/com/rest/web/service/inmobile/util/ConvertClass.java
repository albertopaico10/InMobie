package com.rest.web.service.inmobile.util;

import com.rest.web.service.inmobile.bean.restaurant.RestaurantRequest;
import com.rest.web.service.inmobile.bean.user.UserRequest;
import com.rest.web.service.inmobile.bean.user.UserResponse;
import com.rest.web.service.inmobile.hibernate.bean.ClientRestaurant;
import com.rest.web.service.inmobile.hibernate.bean.User;

public class ConvertClass {

	public static User convertUserRequestToDataBase(UserRequest beanRequest){
		User userDataBase=new User();
		userDataBase.setEmail(beanRequest.getEmail());
		userDataBase.setPasswordUser(beanRequest.getPassword());
		userDataBase.setTypeUser(Integer.parseInt(beanRequest.getTypeCustomer()));
		return userDataBase;
	}
	
	public static ClientRestaurant convertRestaurantRequestToDataBase(RestaurantRequest beanRequest){
		ClientRestaurant clienRestDataBase=new ClientRestaurant();
		clienRestDataBase.setSocialReason(beanRequest.getSocialReason());
		clienRestDataBase.setNameRestaurant(beanRequest.getNameRestaurant());
		clienRestDataBase.setRUCRestaurant(beanRequest.getRUCRestaurant());
		clienRestDataBase.setAddressRestaurant(beanRequest.getSocialReason());
		clienRestDataBase.setPhoneRestaurant(beanRequest.getPhoneRestaurant());
		clienRestDataBase.setReferenceRestaurant(beanRequest.getReferenceRestaurant());
		clienRestDataBase.setIdDistrictRestaurant(beanRequest.getIdDistrictRestaurant());
		clienRestDataBase.setIdProvinceRestaurant(beanRequest.getIdProvinceRestaurant());
		clienRestDataBase.setIdDeparmentRestaurant(beanRequest.getIdDeparmentRestaurant());
		clienRestDataBase.setIdCategory(beanRequest.getIdCategory());
		clienRestDataBase.setNameContact(beanRequest.getNameContact());
		clienRestDataBase.setLastNameContact(beanRequest.getLastNameContact());
		clienRestDataBase.setChargeContact(beanRequest.getChargeContact());
		clienRestDataBase.setPhoneContact(beanRequest.getPhoneContact());
		clienRestDataBase.setCellphoneContact(beanRequest.getCellphoneContact());
		clienRestDataBase.setReferenceContact(beanRequest.getReferenceContact());
		clienRestDataBase.setAnexoContact(beanRequest.getAnexoContact());
		clienRestDataBase.setIdUser(beanRequest.getIdUser());
		clienRestDataBase.setIdImage(beanRequest.getIdImage());
		return clienRestDataBase;
	}
	
//	public static UserResponse convertDataBaseToUserResponse(User beanUser){
//		UserResponse beanResponseUser=new UserResponse();
//		beanResponseUser.setIdUser(beanUser.getId());
//		beanResponseUser.set
//		return beanResponseUser;
//	}
	
}
