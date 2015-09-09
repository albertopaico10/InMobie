package com.canonical.bean.presentation;

import java.util.List;

import com.canonical.bean.AbstractClass;

public class ListPresentationResponse extends AbstractClass {

	private List<PresentationResponse> listPresentation;

	public List<PresentationResponse> getListPresentation() {
		return listPresentation;
	}

	public void setListPresentation(List<PresentationResponse> listPresentation) {
		this.listPresentation = listPresentation;
	}
	
}
