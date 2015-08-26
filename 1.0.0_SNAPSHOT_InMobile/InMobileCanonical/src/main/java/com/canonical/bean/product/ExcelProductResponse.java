package com.canonical.bean.product;

import com.canonical.bean.AbstractClass;

public class ExcelProductResponse extends AbstractClass{

	private String finalStatus;
	private int correctRows;
	private int incorrectRows;
	
	public String getFinalStatus() {
		return finalStatus;
	}
	public void setFinalStatus(String finalStatus) {
		this.finalStatus = finalStatus;
	}
	public int getCorrectRows() {
		return correctRows;
	}
	public void setCorrectRows(int correctRows) {
		this.correctRows = correctRows;
	}
	public int getIncorrectRows() {
		return incorrectRows;
	}
	public void setIncorrectRows(int incorrectRows) {
		this.incorrectRows = incorrectRows;
	}
	
}
