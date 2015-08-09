package com.rest.web.service.inmobile.hibernate.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the tb_check_active_restaurant database table.
 * 
 */
@Entity
@Table(name="tb_check_active_restaurant")
public class CheckActiveRestaurant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	@Column(name="date_created")
	private Timestamp dateCreated;

	private int idRestaurant;

	private int manualReception;
	
	@Column(name="idMemberShipPlan")
	private int membershipPlan;

	private int status;

	private int training;

	@Column(name="user_created")
	private int userCreated;

	private int verificationAddress;

	private int verificationSunat;

	private int verificationUser;

	public CheckActiveRestaurant() {
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

	public int getIdRestaurant() {
		return this.idRestaurant;
	}

	public void setIdRestaurant(int idRestaurant) {
		this.idRestaurant = idRestaurant;
	}

	public int getMembershipPlan() {
		return membershipPlan;
	}

	public void setMembershipPlan(int membershipPlan) {
		this.membershipPlan = membershipPlan;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getUserCreated() {
		return this.userCreated;
	}

	public void setUserCreated(int userCreated) {
		this.userCreated = userCreated;
	}

	public int getManualReception() {
		return manualReception;
	}

	public void setManualReception(int manualReception) {
		this.manualReception = manualReception;
	}

	public int getTraining() {
		return training;
	}

	public void setTraining(int training) {
		this.training = training;
	}

	public int getVerificationAddress() {
		return verificationAddress;
	}

	public void setVerificationAddress(int verificationAddress) {
		this.verificationAddress = verificationAddress;
	}

	public int getVerificationSunat() {
		return verificationSunat;
	}

	public void setVerificationSunat(int verificationSunat) {
		this.verificationSunat = verificationSunat;
	}

	public int getVerificationUser() {
		return verificationUser;
	}

	public void setVerificationUser(int verificationUser) {
		this.verificationUser = verificationUser;
	}
	
}