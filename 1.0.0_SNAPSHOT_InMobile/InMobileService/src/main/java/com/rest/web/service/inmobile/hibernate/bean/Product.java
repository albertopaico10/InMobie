package com.rest.web.service.inmobile.hibernate.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the tb_product database table.
 * 
 */
@Entity
@Table(name="tb_product")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	private String brand;

	private BigDecimal costProduct;

	@Column(name="date_created")
	private Timestamp dateCreated;

	private String descriptionProduct;

	private int idCategory;

	private int idImagePhoto;

	private int idPresentation;

	private String nameProduct;

	private int status;

	private int totalStock;

	public Product() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public BigDecimal getCostProduct() {
		return this.costProduct;
	}

	public void setCostProduct(BigDecimal costProduct) {
		this.costProduct = costProduct;
	}

	public Timestamp getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getDescriptionProduct() {
		return this.descriptionProduct;
	}

	public void setDescriptionProduct(String descriptionProduct) {
		this.descriptionProduct = descriptionProduct;
	}

	public int getIdCategory() {
		return this.idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public int getIdImagePhoto() {
		return this.idImagePhoto;
	}

	public void setIdImagePhoto(int idImagePhoto) {
		this.idImagePhoto = idImagePhoto;
	}

	public int getIdPresentation() {
		return this.idPresentation;
	}

	public void setIdPresentation(int idPresentation) {
		this.idPresentation = idPresentation;
	}

	public String getNameProduct() {
		return this.nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getTotalStock() {
		return this.totalStock;
	}

	public void setTotalStock(int totalStock) {
		this.totalStock = totalStock;
	}

}