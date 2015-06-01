package com.rest.web.service.inmobile.hibernate.bean;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the tb_provider database table.
 * 
 */
@Entity
@Table(name="tb_provider")
public class Provider implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	private String addressProvider;

	private String anexoContact;

	private String cellphoneContact;

	private String chargeContact;

	@Column(name="date_created")
	private Timestamp dateCreated;

	@Column(name="date_updated")
	private Timestamp dateUpdated;

	private int idCategory;

	private int idDeparmentProvider;

	private int idDistrictProvider;

	private int idImage;

	private int idProvinceProvider;

	private int idUser;

	private String lastNameContact;

	private String nameContact;

	private String nameProvider;

	private String phoneContact;

	private String phoneProvider;

	private String referenceContact;

	private String referenceProvider;

	private String RUCProvider;

	private String socialReason;

	private int status;
	
	private int idPlan;

	@Column(name="user_created")
	private int userCreated;

	@Column(name="user_updated")
	private int userUpdated;

	public Provider() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddressProvider() {
		return addressProvider;
	}

	public void setAddressProvider(String addressProvider) {
		this.addressProvider = addressProvider;
	}

	public String getAnexoContact() {
		return anexoContact;
	}

	public void setAnexoContact(String anexoContact) {
		this.anexoContact = anexoContact;
	}

	public String getCellphoneContact() {
		return cellphoneContact;
	}

	public void setCellphoneContact(String cellphoneContact) {
		this.cellphoneContact = cellphoneContact;
	}

	public String getChargeContact() {
		return chargeContact;
	}

	public void setChargeContact(String chargeContact) {
		this.chargeContact = chargeContact;
	}

	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Timestamp getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Timestamp dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public int getIdDeparmentProvider() {
		return idDeparmentProvider;
	}

	public void setIdDeparmentProvider(int idDeparmentProvider) {
		this.idDeparmentProvider = idDeparmentProvider;
	}

	public int getIdDistrictProvider() {
		return idDistrictProvider;
	}

	public void setIdDistrictProvider(int idDistrictProvider) {
		this.idDistrictProvider = idDistrictProvider;
	}

	public int getIdImage() {
		return idImage;
	}

	public void setIdImage(int idImage) {
		this.idImage = idImage;
	}

	public int getIdProvinceProvider() {
		return idProvinceProvider;
	}

	public void setIdProvinceProvider(int idProvinceProvider) {
		this.idProvinceProvider = idProvinceProvider;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getLastNameContact() {
		return lastNameContact;
	}

	public void setLastNameContact(String lastNameContact) {
		this.lastNameContact = lastNameContact;
	}

	public String getNameContact() {
		return nameContact;
	}

	public void setNameContact(String nameContact) {
		this.nameContact = nameContact;
	}

	public String getNameProvider() {
		return nameProvider;
	}

	public void setNameProvider(String nameProvider) {
		this.nameProvider = nameProvider;
	}

	public String getPhoneContact() {
		return phoneContact;
	}

	public void setPhoneContact(String phoneContact) {
		this.phoneContact = phoneContact;
	}

	public String getPhoneProvider() {
		return phoneProvider;
	}

	public void setPhoneProvider(String phoneProvider) {
		this.phoneProvider = phoneProvider;
	}

	public String getReferenceContact() {
		return referenceContact;
	}

	public void setReferenceContact(String referenceContact) {
		this.referenceContact = referenceContact;
	}

	public String getReferenceProvider() {
		return referenceProvider;
	}

	public void setReferenceProvider(String referenceProvider) {
		this.referenceProvider = referenceProvider;
	}

	public String getRUCProvider() {
		return RUCProvider;
	}

	public void setRUCProvider(String rUCProvider) {
		RUCProvider = rUCProvider;
	}

	public String getSocialReason() {
		return socialReason;
	}

	public void setSocialReason(String socialReason) {
		this.socialReason = socialReason;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getUserCreated() {
		return userCreated;
	}

	public void setUserCreated(int userCreated) {
		this.userCreated = userCreated;
	}

	public int getUserUpdated() {
		return userUpdated;
	}

	public void setUserUpdated(int userUpdated) {
		this.userUpdated = userUpdated;
	}

	public int getIdPlan() {
		return idPlan;
	}

	public void setIdPlan(int idPlan) {
		this.idPlan = idPlan;
	}


}