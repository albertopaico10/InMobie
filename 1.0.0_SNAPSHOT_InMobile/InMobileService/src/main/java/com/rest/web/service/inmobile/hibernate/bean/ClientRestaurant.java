package com.rest.web.service.inmobile.hibernate.bean;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the tb_clientrestaurant database table.
 * 
 */
@Entity
@Table(name="tb_clientrestaurant")
public class ClientRestaurant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	private String addressRestaurant;

	private String anexoContact;

	private String cellphoneContact;

	private String chargeContact;

	@Column(name="date_created")
	private Timestamp dateCreated;

	@Column(name="date_updated")
	private Timestamp dateUpdated;

	private int idCategory;

	private int idDeparmentRestaurant;

	private int idDistrictRestaurant;

	private int idImage;

	private int idProvinceRestaurant;

	private int idUser;

	private String lastNameContact;

	private String nameContact;

	private String nameRestaurant;

	private String phoneContact;

	private String phoneRestaurant;

	private String referenceContact;

	private String referenceRestaurant;

	private String RUCRestaurant;

	private String socialReason;

	private int status;

	@Column(name="user_created")
	private int userCreated;

	@Column(name="user_updated")
	private int userUpdated;

	public ClientRestaurant() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddressRestaurant() {
		return this.addressRestaurant;
	}

	public void setAddressRestaurant(String addressRestaurant) {
		this.addressRestaurant = addressRestaurant;
	}

	public String getAnexoContact() {
		return this.anexoContact;
	}

	public void setAnexoContact(String anexoContact) {
		this.anexoContact = anexoContact;
	}

	public String getCellphoneContact() {
		return this.cellphoneContact;
	}

	public void setCellphoneContact(String cellphoneContact) {
		this.cellphoneContact = cellphoneContact;
	}

	public String getChargeContact() {
		return this.chargeContact;
	}

	public void setChargeContact(String chargeContact) {
		this.chargeContact = chargeContact;
	}

	public Timestamp getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Timestamp getDateUpdated() {
		return this.dateUpdated;
	}

	public void setDateUpdated(Timestamp dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public int getIdCategory() {
		return this.idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public int getIdDeparmentRestaurant() {
		return this.idDeparmentRestaurant;
	}

	public void setIdDeparmentRestaurant(int idDeparmentRestaurant) {
		this.idDeparmentRestaurant = idDeparmentRestaurant;
	}

	public int getIdDistrictRestaurant() {
		return this.idDistrictRestaurant;
	}

	public void setIdDistrictRestaurant(int idDistrictRestaurant) {
		this.idDistrictRestaurant = idDistrictRestaurant;
	}

	public int getIdImage() {
		return this.idImage;
	}

	public void setIdImage(int idImage) {
		this.idImage = idImage;
	}

	public int getIdProvinceRestaurant() {
		return this.idProvinceRestaurant;
	}

	public void setIdProvinceRestaurant(int idProvinceRestaurant) {
		this.idProvinceRestaurant = idProvinceRestaurant;
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getLastNameContact() {
		return this.lastNameContact;
	}

	public void setLastNameContact(String lastNameContact) {
		this.lastNameContact = lastNameContact;
	}

	public String getNameContact() {
		return this.nameContact;
	}

	public void setNameContact(String nameContact) {
		this.nameContact = nameContact;
	}

	public String getNameRestaurant() {
		return this.nameRestaurant;
	}

	public void setNameRestaurant(String nameRestaurant) {
		this.nameRestaurant = nameRestaurant;
	}

	public String getPhoneContact() {
		return this.phoneContact;
	}

	public void setPhoneContact(String phoneContact) {
		this.phoneContact = phoneContact;
	}

	public String getPhoneRestaurant() {
		return this.phoneRestaurant;
	}

	public void setPhoneRestaurant(String phoneRestaurant) {
		this.phoneRestaurant = phoneRestaurant;
	}

	public String getReferenceContact() {
		return this.referenceContact;
	}

	public void setReferenceContact(String referenceContact) {
		this.referenceContact = referenceContact;
	}

	public String getReferenceRestaurant() {
		return this.referenceRestaurant;
	}

	public void setReferenceRestaurant(String referenceRestaurant) {
		this.referenceRestaurant = referenceRestaurant;
	}

	public String getRUCRestaurant() {
		return this.RUCRestaurant;
	}

	public void setRUCRestaurant(String RUCRestaurant) {
		this.RUCRestaurant = RUCRestaurant;
	}

	public String getSocialReason() {
		return this.socialReason;
	}

	public void setSocialReason(String socialReason) {
		this.socialReason = socialReason;
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

	public int getUserUpdated() {
		return this.userUpdated;
	}

	public void setUserUpdated(int userUpdated) {
		this.userUpdated = userUpdated;
	}

}