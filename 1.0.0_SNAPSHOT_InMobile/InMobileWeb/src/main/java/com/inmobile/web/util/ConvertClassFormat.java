package com.inmobile.web.util;

import java.util.ArrayList;
import java.util.List;

import com.inmobile.web.bean.ProviderDTO;
import com.inmobile.web.bean.RegisterUserDTO;
import com.inmobile.web.bean.RestaurantDTO;
import com.inmobile.web.bean.UbigeoDepartmentDTO;
import com.inmobile.web.bean.UbigeoDistrictDTO;
import com.inmobile.web.bean.UbigeoProvinceDTO;
import com.inmobile.web.bean.canonical.restaurant.ProviderRequest;
import com.inmobile.web.bean.canonical.restaurant.RestaurantRequest;
import com.inmobile.web.bean.canonical.ubigeo.Ubigeo;
import com.inmobile.web.bean.canonical.ubigeo.UbigeoResponse;
import com.inmobile.web.bean.canonical.user.UserRequest;

public class ConvertClassFormat {

	public static UserRequest convertWebToServiceUser(RegisterUserDTO registerUser){
		UserRequest userRequest=new UserRequest();
		userRequest.setEmail(registerUser.getUser());
		userRequest.setPassword(UtilMethods.encriptedPassword(registerUser.getPassword(),CommonConstants.EncriptedValues.ALGORITHM_MD5));
		userRequest.setTypeCustomer(registerUser.getTypeUser());
		return userRequest;
	}
	
	public static RestaurantRequest convertWebToServiceRestaurant(RestaurantDTO restaurantBeanDTO){
		RestaurantRequest beanRequest=new RestaurantRequest();
		beanRequest.setSocialReason(restaurantBeanDTO.getSocialReason());
		beanRequest.setNameRestaurant(restaurantBeanDTO.getComercialName());
		beanRequest.setRUCRestaurant(restaurantBeanDTO.getRuc());
		beanRequest.setAddressRestaurant(restaurantBeanDTO.getAddress());
		beanRequest.setPhoneRestaurant(restaurantBeanDTO.getPhone());
		beanRequest.setReferenceRestaurant(restaurantBeanDTO.getReference());
		beanRequest.setIdDistrictRestaurant(Integer.parseInt(restaurantBeanDTO.getDistrict()));
		beanRequest.setIdProvinceRestaurant(Integer.parseInt(restaurantBeanDTO.getProvince()));
		beanRequest.setIdDeparmentRestaurant(Integer.parseInt(restaurantBeanDTO.getDepartment()));
//		beanRequest.setIdCategory(restaurantBeanDTO.get());
		beanRequest.setNameContact(restaurantBeanDTO.getNameContact());
		beanRequest.setLastNameContact(restaurantBeanDTO.getLastNameContact());
		beanRequest.setChargeContact(restaurantBeanDTO.getChargeContact());
		beanRequest.setPhoneContact(restaurantBeanDTO.getPhoneContact());
		beanRequest.setCellphoneContact(restaurantBeanDTO.getCelphoneContact());
		beanRequest.setReferenceContact(restaurantBeanDTO.getReference());
		beanRequest.setAnexoContact(restaurantBeanDTO.getAnexoContact());
		beanRequest.setIdUser(Integer.parseInt(restaurantBeanDTO.getIdUser()));
//		beanRequest.setIdImage(restaurantBeanDTO.get);
		return beanRequest;
	}
	
	public static ProviderRequest convertWebToServiceProvider(ProviderDTO objProviderDTO){
		ProviderRequest objProvideRequest = new ProviderRequest();
		objProvideRequest.setSocialReason(objProviderDTO.getSocialReason());
		objProvideRequest.setNameProvider(objProviderDTO.getComercialName());
		objProvideRequest.setRUCProvider(objProviderDTO.getRuc());
		objProvideRequest.setAddressProvider(objProviderDTO.getAddress());
		objProvideRequest.setPhoneProvider(objProviderDTO.getPhone());
		objProvideRequest.setReferenceProvider(objProviderDTO.getReference());
		objProvideRequest.setIdDistrictProvider(Integer.parseInt(objProviderDTO.getDistrict()));
		objProvideRequest.setIdProvinceProvider(Integer.parseInt(objProviderDTO.getProvince()));
		objProvideRequest.setIdDeparmentProvider(Integer.parseInt(objProviderDTO.getDepartment()));
//		objProvideRequest.setIdCategory(ProviderBeanDTO.get());
		objProvideRequest.setNameContact(objProviderDTO.getNameContact());
		objProvideRequest.setLastNameContact(objProviderDTO.getLastNameContact());
		objProvideRequest.setChargeContact(objProviderDTO.getChargeContact());
		objProvideRequest.setPhoneContact(objProviderDTO.getPhoneContact());
		objProvideRequest.setCellphoneContact(objProviderDTO.getCelphoneContact());
		objProvideRequest.setReferenceContact(objProviderDTO.getReference());
		objProvideRequest.setAnexoContact(objProviderDTO.getAnexoContact());
		objProvideRequest.setIdUser(Integer.parseInt(objProviderDTO.getIdUser()));
		objProvideRequest.setIdPlan(Integer.parseInt(objProviderDTO.getIdPlan()));
//		beanRequest.setIdImage(restaurantBeanDTO.get);
		return objProvideRequest;
	}
	
	public static List<UbigeoDepartmentDTO> convertResponsetToListUbigeoDepartmentDTO(UbigeoResponse beanUbigeoResponse){
		List<UbigeoDepartmentDTO> listUbigeoDTO=new ArrayList<UbigeoDepartmentDTO>();
		for(Ubigeo beanUbigeo:beanUbigeoResponse.getUbigeoBean()){
			UbigeoDepartmentDTO beanUbiDepart=new UbigeoDepartmentDTO();
			beanUbiDepart.setIdDepartment(beanUbigeo.getId());
			beanUbiDepart.setNameDepartment(beanUbigeo.getName());
			listUbigeoDTO.add(beanUbiDepart);
		}
		return listUbigeoDTO;
	}
	
	public static List<UbigeoProvinceDTO> convertResponsetToListUbigeoProvinceDTO(UbigeoResponse beanUbigeoResponse){
		List<UbigeoProvinceDTO> listUbigeoDTO=new ArrayList<UbigeoProvinceDTO>();
		for(Ubigeo beanUbigeo:beanUbigeoResponse.getUbigeoBean()){
			UbigeoProvinceDTO beanUbiProv=new UbigeoProvinceDTO();
			beanUbiProv.setIdProvince(beanUbigeo.getId());
			beanUbiProv.setNameProvince(beanUbigeo.getName());
			listUbigeoDTO.add(beanUbiProv);
		}
		return listUbigeoDTO;
	}
	
	public static List<UbigeoDistrictDTO> convertResponsetToListUbigeoDistrictDTO(UbigeoResponse beanUbigeoResponse){
		List<UbigeoDistrictDTO> listUbigeoDTO=new ArrayList<UbigeoDistrictDTO>();
		for(Ubigeo beanUbigeo:beanUbigeoResponse.getUbigeoBean()){
			UbigeoDistrictDTO beanUbiProv=new UbigeoDistrictDTO();
			beanUbiProv.setIdDistrict(beanUbigeo.getId());
			beanUbiProv.setNameDistrict(beanUbigeo.getName());
			listUbigeoDTO.add(beanUbiProv);
		}
		return listUbigeoDTO;
	}
}
