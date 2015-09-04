package com.canonical.bean.image;

public class ImageRequest {
	public String categoryImage;
	public String hexFile;
	public String nameFile;
	public String formatFile;
	public int idUser;
	private byte[] file;
	
	public String getCategoryImage() {
		return categoryImage;
	}
	public void setCategoryImage(String categoryImage) {
		this.categoryImage = categoryImage;
	}
	public String getHexFile() {
		return hexFile;
	}
	public void setHexFile(String hexFile) {
		this.hexFile = hexFile;
	}
	public String getNameFile() {
		return nameFile;
	}
	public void setNameFile(String nameFile) {
		this.nameFile = nameFile;
	}
	public String getFormatFile() {
		return formatFile;
	}
	public void setFormatFile(String formatFile) {
		this.formatFile = formatFile;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
}
