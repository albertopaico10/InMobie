package com.inmobile.web.bean;

import java.util.List;


public class ReturnService {
	public String returnPage;
	public String messages;
	public String specificMessages;
	public String email;
	public int idUser;
	public List<SchedulerRestaurantBean> nameDay;
	public List<SchedulerRestaurantBean> numberHours;
	public RestaurantDTO beanRestaurantDTO;
	public ProviderDTO beanProviderDTO;
	public List<UbigeoProvinceDTO> listProvinceDTO;
	public List<UbigeoDistrictDTO> listDistrictDTO;
	
	public List<RestaurantDTO> listRestaurantDTO;
	public List<ProviderDTO> listProviderDTO;
	
	public String getReturnPage() {
		return returnPage;
	}
	public void setReturnPage(String returnPage) {
		this.returnPage = returnPage;
	}
	public String getMessages() {
		return messages;
	}
	public void setMessages(String messages) {
		this.messages = messages;
	}
	public String getSpecificMessages() {
		return specificMessages;
	}
	public void setSpecificMessages(String specificMessages) {
		this.specificMessages = specificMessages;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public List<SchedulerRestaurantBean> getNameDay() {
		return nameDay;
	}
	public void setNameDay(List<SchedulerRestaurantBean> nameDay) {
		this.nameDay = nameDay;
	}
	public List<SchedulerRestaurantBean> getNumberHours() {
		return numberHours;
	}
	public void setNumberHours(List<SchedulerRestaurantBean> numberHours) {
		this.numberHours = numberHours;
	}
	public RestaurantDTO getBeanRestaurantDTO() {
		return beanRestaurantDTO;
	}
	public void setBeanRestaurantDTO(RestaurantDTO beanRestaurantDTO) {
		this.beanRestaurantDTO = beanRestaurantDTO;
	}
	public List<UbigeoProvinceDTO> getListProvinceDTO() {
		return listProvinceDTO;
	}
	public void setListProvinceDTO(List<UbigeoProvinceDTO> listProvinceDTO) {
		this.listProvinceDTO = listProvinceDTO;
	}
	public List<UbigeoDistrictDTO> getListDistrictDTO() {
		return listDistrictDTO;
	}
	public void setListDistrictDTO(List<UbigeoDistrictDTO> listDistrictDTO) {
		this.listDistrictDTO = listDistrictDTO;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<RestaurantDTO> getListRestaurantDTO() {
		return listRestaurantDTO;
	}
	public void setListRestaurantDTO(List<RestaurantDTO> listRestaurantDTO) {
		this.listRestaurantDTO = listRestaurantDTO;
	}
	public ProviderDTO getBeanProviderDTO() {
		return beanProviderDTO;
	}
	public void setBeanProviderDTO(ProviderDTO beanProviderDTO) {
		this.beanProviderDTO = beanProviderDTO;
	}
	public List<ProviderDTO> getListProviderDTO() {
		return listProviderDTO;
	}
	public void setListProviderDTO(List<ProviderDTO> listProviderDTO) {
		this.listProviderDTO = listProviderDTO;
	}
}
