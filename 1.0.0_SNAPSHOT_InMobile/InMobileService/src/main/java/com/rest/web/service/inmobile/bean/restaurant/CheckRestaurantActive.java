package com.rest.web.service.inmobile.bean.restaurant;

import com.rest.web.service.inmobile.bean.AbstractClass;


public class CheckRestaurantActive extends AbstractClass {
	private int id;
	private int idRestaurant;
	private int manualReception;
	private int idMembershipPlan;
	private int status;
	private int training;
	private int verificationAddress;
	private int verificationSunat;
	private int verificationUser;
	private boolean updateStatus;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdRestaurant() {
		return idRestaurant;
	}
	public void setIdRestaurant(int idRestaurant) {
		this.idRestaurant = idRestaurant;
	}
	public int getManualReception() {
		return manualReception;
	}
	public void setManualReception(int manualReception) {
		this.manualReception = manualReception;
	}
	public int getIdMembershipPlan() {
		return idMembershipPlan;
	}
	public void setIdMembershipPlan(int idMembershipPlan) {
		this.idMembershipPlan = idMembershipPlan;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
	public boolean isUpdateStatus() {
		return updateStatus;
	}
	public void setUpdateStatus(boolean updateStatus) {
		this.updateStatus = updateStatus;
	}
}
