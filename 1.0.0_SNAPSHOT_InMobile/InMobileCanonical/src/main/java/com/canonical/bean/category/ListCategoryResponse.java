package com.canonical.bean.category;

import java.util.List;

import com.canonical.bean.AbstractClass;

public class ListCategoryResponse extends AbstractClass{

	public List<CategoryResponse> listCategoryResponse;

	public List<CategoryResponse> getListCategoryResponse() {
		return listCategoryResponse;
	}

	public void setListCategoryResponse(List<CategoryResponse> listCategoryResponse) {
		this.listCategoryResponse = listCategoryResponse;
	}
	
}
