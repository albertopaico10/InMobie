package com.canonical.bean.restaurant;

public class SchedulerRestaurantRequest {
	
	private int idRestaurant;
	private int idUser;
	private String daysAndHours;
	
	
	public int getIdRestaurant() {
		return idRestaurant;
	}
	public void setIdRestaurant(int idRestaurant) {
		this.idRestaurant = idRestaurant;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getDaysAndHours() {
		return daysAndHours;
	}
	public void setDaysAndHours(String daysAndHours) {
		this.daysAndHours = daysAndHours;
	}
}
