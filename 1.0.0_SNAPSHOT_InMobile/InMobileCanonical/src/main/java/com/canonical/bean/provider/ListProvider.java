package com.canonical.bean.provider;

import java.util.List;

import com.canonical.bean.AbstractClass;

public class ListProvider extends AbstractClass {
	public List<ProviderResponse> listProviderResponse;

	public List<ProviderResponse> getListProviderResponse() {
		return listProviderResponse;
	}

	public void setListProviderResponse(List<ProviderResponse> listProviderResponse) {
		this.listProviderResponse = listProviderResponse;
	}
	
	
}
