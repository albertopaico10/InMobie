package com.inmobile.web.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

import com.inmobile.web.bean.RegisterUserDTO;
import com.inmobile.web.bean.RestaurantDTO;
import com.inmobile.web.bean.UbigeoDepartmentDTO;
import com.inmobile.web.bean.UbigeoDistrictDTO;
import com.inmobile.web.bean.UbigeoProvinceDTO;
import com.inmobile.web.bean.canonical.image.ImageRequest;
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
	
	public static ImageRequest convertWebToImageRequest(MultipartFile file,int idUser){
		ImageRequest beanRequestImage=new ImageRequest();
		beanRequestImage.setCategoryImage(CommonConstants.WebId.IMAGE_SAVE_RESTAURANT);
		beanRequestImage.setIdUser(idUser);
		try {
			beanRequestImage.setHexFile(UtilMethods.bytesToHexString(file.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		beanRequestImage.setNameFile(file.getOriginalFilename());
		beanRequestImage.setFormatFile(CommonConstants.Format.FORMAT_JPG);
		return beanRequestImage;
	}
	
	public static HttpEntity convertWebToHttpEntity(MultipartFile file){
		
	    try {
//	    	LinkedMultiValueMap<String, Object> requestBody = new LinkedMultiValueMap<String, Object>();
//	    	requestBody.add("name", CommonConstants.WebId.LOGIN_REGISTER_USER);
//	    	requestBody.add("file", file);
	    	MultiValueMap<String, Object> requestBody = new LinkedMultiValueMap<String, Object>();
		    requestBody.add("name", CommonConstants.WebId.LOGIN_REGISTER_USER);
//			requestBody.add("file", file.getBytes());
		    requestBody.add("file", new FileSystemResource(file.getOriginalFilename()));
		    
		    HttpHeaders headers = new HttpHeaders();
		    headers.add("Content-Type", "multipart/form-data");
		    
		    HttpEntity request= new HttpEntity( requestBody, headers );
		    return request;
		} catch (Exception e) {
			System.out.println("Error : "+e.getMessage());
		}
	    
	    return null;
	}
}
