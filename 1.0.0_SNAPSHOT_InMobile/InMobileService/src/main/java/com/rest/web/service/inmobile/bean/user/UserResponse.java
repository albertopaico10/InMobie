package com.rest.web.service.inmobile.bean.user;

import com.rest.web.service.inmobile.bean.restaurant.ProviderResponse;
import com.rest.web.service.inmobile.bean.restaurant.RestaurantResponse;
import com.rest.web.service.inmobile.bean.ubigeo.UbigeoResponse;

public class UserResponse {

	public int idUser;
	public String codeResponse;
	public String messagesResponse;
	public String description;

	private String email;
	private int status;
	private int typeUser;
	
	public RestaurantResponse beanResponseRestaurant;
	public ProviderResponse beanResponseProvider;
	public UbigeoResponse beanUbigeoResponseProvince;
	public UbigeoResponse beanUbigeoResponseDistrict;
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getCodeResponse() {
		return codeResponse;
	}
	public void setCodeResponse(String codeResponse) {
		this.codeResponse = codeResponse;
	}
	public String getMessagesResponse() {
		return messagesResponse;
	}
	public void setMessagesResponse(String messagesResponse) {
		this.messagesResponse = messagesResponse;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public RestaurantResponse getBeanResponseRestaurant() {
		return beanResponseRestaurant;
	}
	public void setBeanResponseRestaurant(RestaurantResponse beanResponseRestaurant) {
		this.beanResponseRestaurant = beanResponseRestaurant;
	}
	public UbigeoResponse getBeanUbigeoResponseProvince() {
		return beanUbigeoResponseProvince;
	}
	public void setBeanUbigeoResponseProvince(
			UbigeoResponse beanUbigeoResponseProvince) {
		this.beanUbigeoResponseProvince = beanUbigeoResponseProvince;
	}
	public UbigeoResponse getBeanUbigeoResponseDistrict() {
		return beanUbigeoResponseDistrict;
	}
	public void setBeanUbigeoResponseDistrict(
			UbigeoResponse beanUbigeoResponseDistrict) {
		this.beanUbigeoResponseDistrict = beanUbigeoResponseDistrict;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getTypeUser() {
		return typeUser;
	}
	public void setTypeUser(int typeUser) {
		this.typeUser = typeUser;
	}
	public ProviderResponse getBeanResponseProvider() {
		return beanResponseProvider;
	}
	public void setBeanResponseProvider(ProviderResponse beanResponseProvider) {
		this.beanResponseProvider = beanResponseProvider;
	}
	
}
