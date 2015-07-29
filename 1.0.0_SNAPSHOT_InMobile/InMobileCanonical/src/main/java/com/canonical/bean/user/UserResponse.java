package com.canonical.bean.user;

import com.canonical.bean.AbstractClass;
import com.canonical.bean.provider.ProviderResponse;
import com.canonical.bean.restaurant.RestaurantResponse;
import com.canonical.bean.ubigeo.UbigeoResponse;

public class UserResponse extends AbstractClass{
	private String email;
	private int status;
	private int typeUser;
	
	public RestaurantResponse beanResponseRestaurant;
	public ProviderResponse beanResponseProvider;
	public UbigeoResponse beanUbigeoResponseProvince;
	public UbigeoResponse beanUbigeoResponseDistrict;
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
	public RestaurantResponse getBeanResponseRestaurant() {
		return beanResponseRestaurant;
	}
	public void setBeanResponseRestaurant(RestaurantResponse beanResponseRestaurant) {
		this.beanResponseRestaurant = beanResponseRestaurant;
	}
	public ProviderResponse getBeanResponseProvider() {
		return beanResponseProvider;
	}
	public void setBeanResponseProvider(ProviderResponse beanResponseProvider) {
		this.beanResponseProvider = beanResponseProvider;
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
	
}
