package com.rest.web.service.inmobile.hibernate.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the tb_check_active_provider database table.
 * 
 */
@Entity
@Table(name="tb_check_active_provider")
public class CheckActiveProvider implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	@Column(name="date_created")
	private Timestamp dateCreated;

	private int idMemberShipPlan;

	private int idProvider;

	private int manualReception;

	private int status;

	private int training;

	@Column(name="user_created")
	private int userCreated;

	private int verificationAddress;

	private int verificationSunat;

	private int verificationUser;

	public CheckActiveProvider() {
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

	public int getIdMemberShipPlan() {
		return this.idMemberShipPlan;
	}

	public void setIdMemberShipPlan(int idMemberShipPlan) {
		this.idMemberShipPlan = idMemberShipPlan;
	}

	public int getIdProvider() {
		return this.idProvider;
	}

	public void setIdProvider(int idProvider) {
		this.idProvider = idProvider;
	}

	public int getManualReception() {
		return this.manualReception;
	}

	public void setManualReception(int manualReception) {
		this.manualReception = manualReception;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getTraining() {
		return this.training;
	}

	public void setTraining(int training) {
		this.training = training;
	}

	public int getUserCreated() {
		return this.userCreated;
	}

	public void setUserCreated(int userCreated) {
		this.userCreated = userCreated;
	}

	public int getVerificationAddress() {
		return this.verificationAddress;
	}

	public void setVerificationAddress(int verificationAddress) {
		this.verificationAddress = verificationAddress;
	}

	public int getVerificationSunat() {
		return this.verificationSunat;
	}

	public void setVerificationSunat(int verificationSunat) {
		this.verificationSunat = verificationSunat;
	}

	public int getVerificationUser() {
		return this.verificationUser;
	}

	public void setVerificationUser(int verificationUser) {
		this.verificationUser = verificationUser;
	}

}