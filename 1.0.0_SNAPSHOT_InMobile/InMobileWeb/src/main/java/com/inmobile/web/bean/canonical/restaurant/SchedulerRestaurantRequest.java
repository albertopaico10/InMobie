package com.inmobile.web.bean.canonical.restaurant;

public class SchedulerRestaurantRequest {

	public int idRestaurant;
	public int idUser;
	public String daysAndHours;
	
	
	
	public int getIdRestaurant() {
		return idRestaurant;
	}
	public void setIdRestaurant(int idRestaurant) {
		this.idRestaurant = idRestaurant;
	}
	public String getDaysAndHours() {
		return daysAndHours;
	}
	public void setDaysAndHours(String daysAndHours) {
		this.daysAndHours = daysAndHours;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
}
