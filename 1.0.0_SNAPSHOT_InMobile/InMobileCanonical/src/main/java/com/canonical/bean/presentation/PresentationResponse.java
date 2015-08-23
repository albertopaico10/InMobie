package com.canonical.bean.presentation;

import com.canonical.bean.AbstractClass;

public class PresentationResponse extends AbstractClass {

	private int idPresentation;
	private String namePresentation;
	
	public int getIdPresentation() {
		return idPresentation;
	}
	public void setIdPresentation(int idPresentation) {
		this.idPresentation = idPresentation;
	}
	public String getNamePresentation() {
		return namePresentation;
	}
	public void setNamePresentation(String namePresentation) {
		this.namePresentation = namePresentation;
	}
	
}
