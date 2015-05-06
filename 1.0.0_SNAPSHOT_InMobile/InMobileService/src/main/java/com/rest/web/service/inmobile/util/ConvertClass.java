package com.rest.web.service.inmobile.util;

import java.util.ArrayList;
import java.util.List;

import com.rest.web.service.inmobile.bean.image.ImageRequest;
import com.rest.web.service.inmobile.bean.restaurant.ProviderRequest;
import com.rest.web.service.inmobile.bean.restaurant.RestaurantRequest;
import com.rest.web.service.inmobile.bean.ubigeo.Ubigeo;
import com.rest.web.service.inmobile.bean.user.UserRequest;
import com.rest.web.service.inmobile.bean.user.UserResponse;
import com.rest.web.service.inmobile.hibernate.bean.ClientRestaurant;
import com.rest.web.service.inmobile.hibernate.bean.Department;
import com.rest.web.service.inmobile.hibernate.bean.District;
import com.rest.web.service.inmobile.hibernate.bean.Image;
import com.rest.web.service.inmobile.hibernate.bean.Provider;
import com.rest.web.service.inmobile.hibernate.bean.Province;
import com.rest.web.service.inmobile.hibernate.bean.User;

public class ConvertClass {

	public static User convertUserRequestToDataBase(UserRequest beanRequest){
		User userDataBase=new User();
		userDataBase.setEmail(beanRequest.getEmail());
		userDataBase.setPasswordUser(beanRequest.getPassword());
		userDataBase.setTypeUser(Integer.parseInt(beanRequest.getTypeCustomer()));
		return userDataBase;
	}
	
	public static ClientRestaurant convertRestaurantRequestToDataBase(RestaurantRequest beanRequest){
		ClientRestaurant clienRestDataBase=new ClientRestaurant();
		clienRestDataBase.setSocialReason(beanRequest.getSocialReason());
		clienRestDataBase.setNameRestaurant(beanRequest.getNameRestaurant());
		clienRestDataBase.setRUCRestaurant(beanRequest.getRUCRestaurant());
		clienRestDataBase.setAddressRestaurant(beanRequest.getSocialReason());
		clienRestDataBase.setPhoneRestaurant(beanRequest.getPhoneRestaurant());
		clienRestDataBase.setReferenceRestaurant(beanRequest.getReferenceRestaurant());
		clienRestDataBase.setIdDistrictRestaurant(beanRequest.getIdDistrictRestaurant());
		clienRestDataBase.setIdProvinceRestaurant(beanRequest.getIdProvinceRestaurant());
		clienRestDataBase.setIdDeparmentRestaurant(beanRequest.getIdDeparmentRestaurant());
		clienRestDataBase.setIdCategory(beanRequest.getIdCategory());
		clienRestDataBase.setNameContact(beanRequest.getNameContact());
		clienRestDataBase.setLastNameContact(beanRequest.getLastNameContact());
		clienRestDataBase.setChargeContact(beanRequest.getChargeContact());
		clienRestDataBase.setPhoneContact(beanRequest.getPhoneContact());
		clienRestDataBase.setCellphoneContact(beanRequest.getCellphoneContact());
		clienRestDataBase.setReferenceContact(beanRequest.getReferenceContact());
		clienRestDataBase.setAnexoContact(beanRequest.getAnexoContact());
		clienRestDataBase.setIdUser(beanRequest.getIdUser());
		clienRestDataBase.setIdImage(beanRequest.getIdImage());
		return clienRestDataBase;
	}
	
	public static Provider convertProviderRequestToDataBase(ProviderRequest objProviderRequest){
		Provider objProvider = new Provider();
		objProvider.setSocialReason(objProviderRequest.getSocialReason());
		objProvider.setNameProvider(objProviderRequest.getNameProvider());
		objProvider.setRUCProvider(objProviderRequest.getRUCProvider());
		objProvider.setAddressProvider(objProviderRequest.getSocialReason());
		objProvider.setPhoneProvider(objProviderRequest.getPhoneProvider());
		objProvider.setReferenceProvider(objProviderRequest.getReferenceProvider());
		objProvider.setIdDistrictProvider(objProviderRequest.getIdDistrictProvider());
		objProvider.setIdProvinceProvider(objProviderRequest.getIdProvinceProvider());
		objProvider.setIdDeparmentProvider(objProviderRequest.getIdDeparmentProvider());
		objProvider.setIdCategory(objProviderRequest.getIdCategory());
		objProvider.setNameContact(objProviderRequest.getNameContact());
		objProvider.setLastNameContact(objProviderRequest.getLastNameContact());
		objProvider.setChargeContact(objProviderRequest.getChargeContact());
		objProvider.setPhoneContact(objProviderRequest.getPhoneContact());
		objProvider.setCellphoneContact(objProviderRequest.getCellphoneContact());
		objProvider.setReferenceContact(objProviderRequest.getReferenceContact());
		objProvider.setAnexoContact(objProviderRequest.getAnexoContact());
		objProvider.setIdUser(objProviderRequest.getIdUser());
		objProvider.setIdImage(objProviderRequest.getIdImage());
		objProvider.setIdPlan(objProviderRequest.getIdPlan());
		return objProvider;
	}
	
	public static List<Ubigeo> convertDataBasetoUbigeo(List<Department> listBeanDepartments){
		List<Ubigeo> listBeanUbigeo=new ArrayList<Ubigeo>();
		for(Department beanDepartment:listBeanDepartments){
			Ubigeo ubigeoBean=new Ubigeo();
			ubigeoBean.setId(beanDepartment.getId());
			ubigeoBean.setName(beanDepartment.getDepartmentName());
			listBeanUbigeo.add(ubigeoBean);
		}
		
		return listBeanUbigeo;
	}
	
	public static List<Ubigeo> convertDataBaseProvincetoUbigeo(List<Province> listBeanProvince){
		List<Ubigeo> listBeanUbigeo=new ArrayList<Ubigeo>();
		for(Province beanProvince:listBeanProvince){
			Ubigeo ubigeoBean=new Ubigeo();
			ubigeoBean.setId(beanProvince.getId());
			ubigeoBean.setName(beanProvince.getProvinceName());
			listBeanUbigeo.add(ubigeoBean);
		}
		
		return listBeanUbigeo;
	}
	
	public static List<Ubigeo> convertDataBaseDistricttoUbigeo(List<District> listBeanDistrict){
		List<Ubigeo> listBeanUbigeo=new ArrayList<Ubigeo>();
		for(District beanDistrict:listBeanDistrict){
			Ubigeo ubigeoBean=new Ubigeo();
			ubigeoBean.setId(beanDistrict.getId());
			ubigeoBean.setName(beanDistrict.getDistrictName());
			listBeanUbigeo.add(ubigeoBean);
		}
		
		return listBeanUbigeo;
	}
	
	public static Image convertImageToDataBase(ImageRequest beanImageRequest){
		Image beanImage=new Image();
		beanImage.setCategoryImage(beanImageRequest.getCategoryImage());
		//--Get bytes
		byte[] imageByte=UtilMethods.hexStringToByteArray(beanImageRequest.getHexFile());
		beanImage.setImg(imageByte);
		return beanImage;
	}
}
