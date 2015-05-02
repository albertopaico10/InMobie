package com.rest.web.service.inmobile.bean.restaurant;

public class RestaurantResponse {

	public int id;
	public int idUser;
	public String codeResponse;
	public String messagesResponse;
	public String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	
}
