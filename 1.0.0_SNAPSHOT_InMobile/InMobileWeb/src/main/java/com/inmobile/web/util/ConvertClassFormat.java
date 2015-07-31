package com.inmobile.web.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.canonical.bean.image.ImageRequest;
import com.canonical.bean.provider.DistrictProviderRequest;
import com.canonical.bean.provider.ProviderRequest;
import com.canonical.bean.provider.ProviderResponse;
import com.canonical.bean.restaurant.CheckRestaurantActive;
import com.canonical.bean.restaurant.RestaurantRequest;
import com.canonical.bean.restaurant.RestaurantResponse;
import com.canonical.bean.restaurant.SchedulerRestaurantRequest;
import com.canonical.bean.ubigeo.Ubigeo;
import com.canonical.bean.ubigeo.UbigeoResponse;
import com.canonical.bean.user.UserRequest;
import com.inmobile.web.bean.CheckRestaurantDTO;
import com.inmobile.web.bean.DistrictProviderDTO;
import com.inmobile.web.bean.ProviderDTO;
import com.inmobile.web.bean.RegisterUserDTO;
import com.inmobile.web.bean.RestaurantDTO;
import com.inmobile.web.bean.UbigeoDepartmentDTO;
import com.inmobile.web.bean.UbigeoDistrictDTO;
import com.inmobile.web.bean.UbigeoProvinceDTO;

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
		beanRequest.setId(restaurantBeanDTO.getId());
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
	
	public static DistrictProviderRequest convertWebToServiceDistrictProvider(DistrictProviderDTO objDistrictProviderDTO){
		DistrictProviderRequest objDistrictProviderRequest = new DistrictProviderRequest();
//		objDistrictProviderRequest.setIdDistrict(Integer.parseInt(objDistrictProviderDTO.getIdDistrict()));
		objDistrictProviderRequest.setIdProvider(objDistrictProviderDTO.getIdProvider());
		return objDistrictProviderRequest;
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
	
	
	public static RestaurantDTO convertFromServiceToRestaurantDTO(RestaurantResponse beanRestaurantResponse){
		RestaurantDTO beanRestaurantDTO=new RestaurantDTO();
		beanRestaurantDTO.setAddress(beanRestaurantResponse.getAddressRestaurant());
		beanRestaurantDTO.setAnexoContact(beanRestaurantResponse.getAnexoContact());
		beanRestaurantDTO.setCelphoneContact(beanRestaurantResponse.getCellphoneContact());
		beanRestaurantDTO.setChargeContact(beanRestaurantResponse.getChargeContact());
		beanRestaurantDTO.setComercialName(beanRestaurantResponse.getNameRestaurant());
		beanRestaurantDTO.setDepartment(String.valueOf(beanRestaurantResponse.getIdDeparmentRestaurant()));
		beanRestaurantDTO.setDistrict(String.valueOf(beanRestaurantResponse.getIdDistrictRestaurant()));
		beanRestaurantDTO.setLastNameContact(beanRestaurantResponse.getLastNameContact());
		beanRestaurantDTO.setNameContact(beanRestaurantResponse.getNameContact());
		beanRestaurantDTO.setPhone(beanRestaurantResponse.getPhoneRestaurant());
		beanRestaurantDTO.setPhoneContact(beanRestaurantResponse.getPhoneContact());
		beanRestaurantDTO.setProvince(String.valueOf(beanRestaurantResponse.getIdProvinceRestaurant()));
		beanRestaurantDTO.setReference(beanRestaurantResponse.getReferenceRestaurant());
		beanRestaurantDTO.setRuc(beanRestaurantResponse.getRUCRestaurant());
		beanRestaurantDTO.setSocialReason(beanRestaurantResponse.getSocialReason());
		beanRestaurantDTO.setFileName(beanRestaurantResponse.getNameImage());
		beanRestaurantDTO.setIdImage(beanRestaurantResponse.getIdImage());
		beanRestaurantDTO.setId(beanRestaurantResponse.getId());
		
		beanRestaurantDTO.setDepartmentNameSpecific(beanRestaurantResponse.getNameDepartment());
		beanRestaurantDTO.setDistrictNameSpecific(beanRestaurantResponse.getNameDistrict());
		beanRestaurantDTO.setProvinceNameSpecific(beanRestaurantResponse.getNameProvince());
		return beanRestaurantDTO;
	}

	public static ProviderDTO convertFromServiceToProviderDTO(ProviderResponse beanProviderResponse){
		ProviderDTO beanProviderDTO=new ProviderDTO();
		beanProviderDTO.setAddress(beanProviderResponse.getAddressProvider());
		beanProviderDTO.setAnexoContact(beanProviderResponse.getAnexoContact());
		beanProviderDTO.setCelphoneContact(beanProviderResponse.getCellphoneContact());
		beanProviderDTO.setChargeContact(beanProviderResponse.getChargeContact());
		beanProviderDTO.setComercialName(beanProviderResponse.getNameProvider());
		beanProviderDTO.setDepartment(String.valueOf(beanProviderResponse.getIdDeparmentProvider()));
		beanProviderDTO.setDistrict(String.valueOf(beanProviderResponse.getIdDistrictProvider()));
		beanProviderDTO.setLastNameContact(beanProviderResponse.getLastNameContact());
		beanProviderDTO.setNameContact(beanProviderResponse.getNameContact());
		beanProviderDTO.setPhone(beanProviderResponse.getPhoneProvider());
		beanProviderDTO.setPhoneContact(beanProviderResponse.getPhoneContact());
		beanProviderDTO.setProvince(String.valueOf(beanProviderResponse.getIdProvinceProvider()));
		beanProviderDTO.setReference(beanProviderResponse.getReferenceProvider());
		beanProviderDTO.setRuc(beanProviderResponse.getRUCProvider());
		beanProviderDTO.setSocialReason(beanProviderResponse.getSocialReason());
		beanProviderDTO.setFileName(beanProviderResponse.getNameImage());
		beanProviderDTO.setIdImage(beanProviderResponse.getIdImage());
		beanProviderDTO.setId(beanProviderResponse.getId());
		
		beanProviderDTO.setDepartmentNameSpecific(beanProviderResponse.getNameDepartment());
		beanProviderDTO.setDistrictNameSpecific(beanProviderResponse.getNameDistrict());
		beanProviderDTO.setProvinceNameSpecific(beanProviderResponse.getNameProvince());
		return beanProviderDTO;
	}

	
	public static SchedulerRestaurantRequest convertFromWebToServiceScheduler(int idUser,String daysHours){
		SchedulerRestaurantRequest beanScheduler=new SchedulerRestaurantRequest();
		beanScheduler.setIdUser(idUser);
		beanScheduler.setDaysAndHours(daysHours);
		return beanScheduler;
	}
	
	public static List<RestaurantDTO> convertFromServiceToListRestaurantDTO(List<RestaurantResponse> listRestaurantResponse){
		List<RestaurantDTO> listRestaurantDTO=new ArrayList<RestaurantDTO>();
		for(RestaurantResponse beanRestaurantResponse:listRestaurantResponse){
			RestaurantDTO beanRestaurantDTO=convertFromServiceToRestaurantDTO(beanRestaurantResponse);
			listRestaurantDTO.add(beanRestaurantDTO);
		}
		return listRestaurantDTO;
	}
	
	public static List<ProviderDTO> convertFromServiceToListProviderDTO(List<ProviderResponse> listProviderResponse){
		List<ProviderDTO> listProviderDTO=new ArrayList<ProviderDTO>();
		for(ProviderResponse beanProviderResponse:listProviderResponse){
			ProviderDTO beanProviderDTO=convertFromServiceToProviderDTO(beanProviderResponse);
			listProviderDTO.add(beanProviderDTO);
		}
		return listProviderDTO;
	}
	
	public static CheckRestaurantActive convertFromWebToServiceCheckRest(CheckRestaurantDTO beanDTO){
		CheckRestaurantActive beanActive=new CheckRestaurantActive();
		beanActive.setId(beanDTO.getIdCheck());
		beanActive.setIdMembershipPlan(beanDTO.getIdMembershipPlan());
		beanActive.setIdRestaurant(beanDTO.getRestaurantId());
		beanActive.setManualReception(beanDTO.getManualReception());
		beanActive.setTraining(beanDTO.getTraining());
		beanActive.setVerificationAddress(beanDTO.getVerificationAddress());
		beanActive.setVerificationSunat(beanDTO.getVerificationSunat());
		beanActive.setVerificationUser(beanDTO.getVerificationUser());
		if(beanDTO.getUpdateStatus()==1){
			beanActive.setUpdateStatus(true);
		}else{
			beanActive.setUpdateStatus(false);
		}
		return beanActive;
	}
}
