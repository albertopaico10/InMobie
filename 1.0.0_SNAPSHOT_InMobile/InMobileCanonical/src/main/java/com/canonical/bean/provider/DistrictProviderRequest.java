package com.canonical.bean.provider;

import java.util.List;

public class DistrictProviderRequest {
	private int id;
	private int idProvider;
	private List<Integer> listIdDistrict;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdProvider() {
		return idProvider;
	}

	public void setIdProvider(int idProvider) {
		this.idProvider = idProvider;
	}

	public List<Integer> getListIdDistrict() {
		return listIdDistrict;
	}

	public void setListIdDistrict(List<Integer> listIdDistrict) {
		this.listIdDistrict = listIdDistrict;
	}

}
