package com.canonical.bean.category;

import com.canonical.bean.AbstractClass;

public class CategoryResponse extends AbstractClass {

	public int idCategory;
	public String nameCategory;
	
	public int getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
	public String getNameCategory() {
		return nameCategory;
	}
	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}
	
}
