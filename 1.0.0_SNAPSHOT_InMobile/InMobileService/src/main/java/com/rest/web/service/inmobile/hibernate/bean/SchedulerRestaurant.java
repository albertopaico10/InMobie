package com.rest.web.service.inmobile.hibernate.bean;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the tb_schedulerrestaurant database table.
 * 
 */
@Entity
@Table(name="tb_schedulerrestaurant")
public class SchedulerRestaurant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	@Column(name="date_created")
	private Timestamp dateCreated;

	private int dayOfWeek;

	private int idRestaurant;

	private String specificHour;

	@Column(name="user_created")
	private int userCreated;

	public SchedulerRestaurant() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public int getDayOfWeek() {
		return this.dayOfWeek;
	}

	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public int getIdRestaurant() {
		return this.idRestaurant;
	}

	public void setIdRestaurant(int idRestaurant) {
		this.idRestaurant = idRestaurant;
	}

	public String getSpecificHour() {
		return this.specificHour;
	}

	public void setSpecificHour(String specificHour) {
		this.specificHour = specificHour;
	}

	public int getUserCreated() {
		return this.userCreated;
	}

	public void setUserCreated(int userCreated) {
		this.userCreated = userCreated;
	}

}