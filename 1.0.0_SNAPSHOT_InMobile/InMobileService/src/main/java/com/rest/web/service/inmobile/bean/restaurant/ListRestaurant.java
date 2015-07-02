package com.rest.web.service.inmobile.bean.restaurant;

import java.util.List;

public class ListRestaurant {
	public String codeResponse;
	public String messagesResponse;
	public String description;
	public List<RestaurantResponse> listRestaurantResponse;

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

	public List<RestaurantResponse> getListRestaurantResponse() {
		return listRestaurantResponse;
	}

	public void setListRestaurantResponse(
			List<RestaurantResponse> listRestaurantResponse) {
		this.listRestaurantResponse = listRestaurantResponse;
	}
	
	
}
