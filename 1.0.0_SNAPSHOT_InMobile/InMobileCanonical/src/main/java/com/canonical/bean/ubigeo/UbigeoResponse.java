package com.canonical.bean.ubigeo;

import java.util.List;

import com.canonical.bean.AbstractClass;


public class UbigeoResponse extends AbstractClass {
	private List<Ubigeo> ubigeoBean;

	public List<Ubigeo> getUbigeoBean() {
		return ubigeoBean;
	}

	public void setUbigeoBean(List<Ubigeo> ubigeoBean) {
		this.ubigeoBean = ubigeoBean;
	}
	
}
