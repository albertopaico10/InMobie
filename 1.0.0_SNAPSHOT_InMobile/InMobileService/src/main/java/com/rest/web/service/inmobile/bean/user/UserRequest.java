package com.rest.web.service.inmobile.bean.user;

public class UserRequest {

	public String email;
	public String password;
	public String typeCustomer;
	public String encriptUser;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTypeCustomer() {
		return typeCustomer;
	}
	public void setTypeCustomer(String typeCustomer) {
		this.typeCustomer = typeCustomer;
	}
	public String getEncriptUser() {
		return encriptUser;
	}
	public void setEncriptUser(String encriptUser) {
		this.encriptUser = encriptUser;
	}
	
}
