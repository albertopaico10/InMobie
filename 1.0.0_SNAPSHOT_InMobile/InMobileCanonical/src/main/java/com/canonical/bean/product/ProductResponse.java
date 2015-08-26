package com.canonical.bean.product;

import java.math.BigDecimal;
import com.canonical.bean.AbstractClass;

public class ProductResponse extends AbstractClass {

	private int id;
	private String brand;
	private BigDecimal costProduct;
	private String descriptionProduct;
	private int idCategory;
	private int idImagePhoto;
	private int idPresentation;
	private String nameProduct;
	private int status;
	private int totalStock;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public BigDecimal getCostProduct() {
		return costProduct;
	}
	public void setCostProduct(BigDecimal costProduct) {
		this.costProduct = costProduct;
	}
	public String getDescriptionProduct() {
		return descriptionProduct;
	}
	public void setDescriptionProduct(String descriptionProduct) {
		this.descriptionProduct = descriptionProduct;
	}
	public int getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
	public int getIdImagePhoto() {
		return idImagePhoto;
	}
	public void setIdImagePhoto(int idImagePhoto) {
		this.idImagePhoto = idImagePhoto;
	}
	public int getIdPresentation() {
		return idPresentation;
	}
	public void setIdPresentation(int idPresentation) {
		this.idPresentation = idPresentation;
	}
	public String getNameProduct() {
		return nameProduct;
	}
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getTotalStock() {
		return totalStock;
	}
	public void setTotalStock(int totalStock) {
		this.totalStock = totalStock;
	}
}
