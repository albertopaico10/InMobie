package com.canonical.bean.restaurant;

import java.util.List;

import com.canonical.bean.AbstractClass;

public class ListRestaurant extends AbstractClass {
	public List<RestaurantResponse> listRestaurantResponse;

	public List<RestaurantResponse> getListRestaurantResponse() {
		return listRestaurantResponse;
	}

	public void setListRestaurantResponse(
			List<RestaurantResponse> listRestaurantResponse) {
		this.listRestaurantResponse = listRestaurantResponse;
	}
	
	
}
