package com.rest.web.service.inmobile.hibernate.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the tb_user database table.
 * 
 */
@Entity
@Table(name="tb_user")
public class UserDB implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="date_created")
	private Timestamp dateCreated;

	@Column(name="date_updated")
	private Timestamp dateUpdated;

	private String email;

	private String passwordUser;

	private int status;

	private int typeUser;

	@Column(name="user_created")
	private int userCreated;

	@Column(name="user_updated")
	private int userUpdated;

	public UserDB() {
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

	public Timestamp getDateUpdated() {
		return this.dateUpdated;
	}

	public void setDateUpdated(Timestamp dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordUser() {
		return this.passwordUser;
	}

	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getTypeUser() {
		return this.typeUser;
	}

	public void setTypeUser(int typeUser) {
		this.typeUser = typeUser;
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