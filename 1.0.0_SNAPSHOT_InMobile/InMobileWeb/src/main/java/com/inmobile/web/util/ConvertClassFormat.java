package com.inmobile.web.util;

import com.inmobile.web.bean.RegisterUserDTO;
import com.inmobile.web.bean.RestaurantDTO;
import com.inmobile.web.bean.canonical.restaurant.RestaurantRequest;
import com.inmobile.web.bean.canonical.user.UserRequest;

public class ConvertClassFormat {

	public static UserRequest convertWebToServiceUser(RegisterUserDTO registerUser){
		UserRequest userRequest=new UserRequest();
		userRequest.setEmail(registerUser.getUser());
		userRequest.setPassword(UtilMethods.encriptedPassword(registerUser.getPassword(),CommonConstants.EncriptedValues.ALGORITHM_MD5));
		userRequest.setTypeCustomer(registerUser.getTypeUser());
		return userRequest;
	}
	
	public static RestaurantRequest convertWebToServiceRestaurant(RestaurantDTO restaurantBeanDTO){
		RestaurantRequest beanRequest=new RestaurantRequest();
		beanRequest.setSocialReason(restaurantBeanDTO.getSocialReason());
		beanRequest.setNameRestaurant(restaurantBeanDTO.getComercialName());
		beanRequest.setRUCRestaurant(restaurantBeanDTO.getRuc());
		beanRequest.setAddressRestaurant(restaurantBeanDTO.getAddress());
		beanRequest.setPhoneRestaurant(restaurantBeanDTO.getPhone());
		beanRequest.setReferenceRestaurant(restaurantBeanDTO.getReference());
		beanRequest.setIdDistrictRestaurant(Integer.parseInt(restaurantBeanDTO.getDistrict()));
		beanRequest.setIdProvinceRestaurant(Integer.parseInt(restaurantBeanDTO.getProvince()));
		beanRequest.setIdDeparmentRestaurant(Integer.parseInt(restaurantBeanDTO.getDepartment()));
//		beanRequest.setIdCategory(restaurantBeanDTO.get());
		beanRequest.setNameContact(restaurantBeanDTO.getNameContact());
		beanRequest.setLastNameContact(restaurantBeanDTO.getLastNameContact());
		beanRequest.setChargeContact(restaurantBeanDTO.getChargeContact());
		beanRequest.setPhoneContact(restaurantBeanDTO.getPhoneContact());
		beanRequest.setCellphoneContact(restaurantBeanDTO.getCelphoneContact());
		beanRequest.setReferenceContact(restaurantBeanDTO.getReference());
		beanRequest.setAnexoContact(restaurantBeanDTO.getAnexoContact());
		beanRequest.setIdUser(Integer.parseInt(restaurantBeanDTO.getIdUser()));
//		beanRequest.setIdImage(restaurantBeanDTO.get);
		return beanRequest;
	}
	
}
