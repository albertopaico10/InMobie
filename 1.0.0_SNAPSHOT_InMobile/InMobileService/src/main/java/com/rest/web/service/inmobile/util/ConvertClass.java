package com.rest.web.service.inmobile.util;

import java.util.ArrayList;
import java.util.List;

import com.canonical.bean.category.CategoryResponse;
import com.canonical.bean.image.ImageRequest;
import com.canonical.bean.planmember.BeanPlanMember;
import com.canonical.bean.presentation.PresentationResponse;
import com.canonical.bean.provider.CheckProviderActive;
import com.canonical.bean.provider.DistrictProviderRequest;
import com.canonical.bean.provider.ProviderRequest;
import com.canonical.bean.provider.ProviderResponse;
import com.canonical.bean.restaurant.CheckRestaurantActive;
import com.canonical.bean.restaurant.RestaurantRequest;
import com.canonical.bean.restaurant.RestaurantResponse;
import com.canonical.bean.ubigeo.Ubigeo;
import com.canonical.bean.user.UserRequest;
import com.rest.web.service.inmobile.hibernate.ImageHibernate;
import com.rest.web.service.inmobile.hibernate.UbigeoHibernate;
import com.rest.web.service.inmobile.hibernate.bean.Category;
import com.rest.web.service.inmobile.hibernate.bean.CheckActiveProvider;
import com.rest.web.service.inmobile.hibernate.bean.CheckActiveRestaurant;
import com.rest.web.service.inmobile.hibernate.bean.Department;
import com.rest.web.service.inmobile.hibernate.bean.District;
import com.rest.web.service.inmobile.hibernate.bean.DistrictProvider;
import com.rest.web.service.inmobile.hibernate.bean.Image;
import com.rest.web.service.inmobile.hibernate.bean.PlanMember;
import com.rest.web.service.inmobile.hibernate.bean.Presentation;
import com.rest.web.service.inmobile.hibernate.bean.Provider;
import com.rest.web.service.inmobile.hibernate.bean.Province;
import com.rest.web.service.inmobile.hibernate.bean.Restaurant;
import com.rest.web.service.inmobile.hibernate.bean.SchedulerRestaurant;
import com.rest.web.service.inmobile.hibernate.bean.User;

public class ConvertClass {

	public static User convertUserRequestToDataBase(UserRequest beanRequest){
		User userDataBase=new User();
		userDataBase.setEmail(beanRequest.getEmail());
		userDataBase.setPasswordUser(beanRequest.getPassword());
		userDataBase.setTypeUser(Integer.parseInt(beanRequest.getTypeCustomer()));
		return userDataBase;
	}
	
	public static Restaurant convertRestaurantRequestToDataBase(RestaurantRequest beanRequest){
		Restaurant clienRestDataBase=new Restaurant();
		clienRestDataBase.setSocialReason(beanRequest.getSocialReason());
		clienRestDataBase.setNameRestaurant(beanRequest.getNameRestaurant());
		clienRestDataBase.setRUCRestaurant(beanRequest.getRUCRestaurant());
		clienRestDataBase.setAddressRestaurant(beanRequest.getAddressRestaurant());
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
		clienRestDataBase.setId(beanRequest.getId());
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
	
	public static DistrictProvider convertDistrictProviderRequestToDataBase(DistrictProviderRequest objDistrictProviderRequest,int idDistrict){
		DistrictProvider objDistrictProvider = new DistrictProvider();
		objDistrictProvider.setIdDistrict(idDistrict);
		objDistrictProvider.setIdProvider(objDistrictProviderRequest.getIdProvider());
		return objDistrictProvider;
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
	
	public static ProviderResponse convertFromDatabaseToProviderResponse(Provider beanProvider,
			UbigeoHibernate ubigeoHibernate,ImageHibernate imageHibernate){
		ProviderResponse beanProviderResp=new ProviderResponse();
		beanProviderResp.setAddressProvider(beanProvider.getAddressProvider());
		beanProviderResp.setAnexoContact(beanProvider.getAnexoContact());
		beanProviderResp.setCellphoneContact(beanProvider.getCellphoneContact());
		beanProviderResp.setChargeContact(beanProvider.getChargeContact());
		beanProviderResp.setId(beanProvider.getId());
//		beanRestaurantResp.setIdCategory(beanClientClientRestaurant.getIdCategory());
//		beanRestaurantResp.setNameCategory(nameCategory);
		beanProviderResp.setLastNameContact(beanProvider.getLastNameContact());
		beanProviderResp.setNameProvider(beanProvider.getNameProvider());
		beanProviderResp.setPhoneContact(beanProvider.getPhoneContact());
		beanProviderResp.setPhoneProvider(beanProvider.getPhoneProvider());
		beanProviderResp.setReferenceContact(beanProvider.getReferenceContact());
		beanProviderResp.setReferenceProvider(beanProvider.getReferenceProvider());
		beanProviderResp.setRUCProvider(beanProvider.getRUCProvider());
		beanProviderResp.setSocialReason(beanProvider.getSocialReason());
		beanProviderResp.setNameContact(beanProvider.getNameContact());
		try {
			//-- Department
			Department beaDepartment=ubigeoHibernate.getDepartmentById(beanProvider.getIdDeparmentProvider());
			beanProviderResp.setIdDeparmentProvider(beanProvider.getIdDeparmentProvider());
			beanProviderResp.setNameDepartment(beaDepartment.getDepartmentName());
			//-- Province
			Province beanProvince=ubigeoHibernate.getProvinceById(beanProvider.getIdProvinceProvider());
			beanProviderResp.setNameProvince(beanProvince.getProvinceName());
			beanProviderResp.setIdProvinceProvider(beanProvider.getIdProvinceProvider());
			//-- District
			District beanDistrict=ubigeoHibernate.getDistrictById(beanProvider.getIdDistrictProvider());
			beanProviderResp.setNameDistrict(beanDistrict.getDistrictName());
			beanProviderResp.setIdDistrictProvider(beanProvider.getIdDistrictProvider());
			//--Image
			Image beanImage=imageHibernate.getImageById(beanProvider.getIdImage());
			beanProviderResp.setIdImage(beanProvider.getIdImage());
			if(beanProviderResp.getIdImage()==0){
				beanProviderResp.setNameImage("");
			}else{
				beanProviderResp.setNameImage(beanImage.getId()+"_"+beanImage.getCategoryImage());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return beanProviderResp;
	}
	
	public static RestaurantResponse convertFromDatabaseToRestaurantResponse(Restaurant beanClientClientRestaurant,
			UbigeoHibernate ubigeoHibernate,ImageHibernate imageHibernate){
		RestaurantResponse beanRestaurantResp=new RestaurantResponse();
		beanRestaurantResp.setAddressRestaurant(beanClientClientRestaurant.getAddressRestaurant());
		beanRestaurantResp.setAnexoContact(beanClientClientRestaurant.getAnexoContact());
		beanRestaurantResp.setCellphoneContact(beanClientClientRestaurant.getCellphoneContact());
		beanRestaurantResp.setChargeContact(beanClientClientRestaurant.getChargeContact());
		beanRestaurantResp.setId(beanClientClientRestaurant.getId());
//		beanRestaurantResp.setIdCategory(beanClientClientRestaurant.getIdCategory());
//		beanRestaurantResp.setNameCategory(nameCategory);
		beanRestaurantResp.setLastNameContact(beanClientClientRestaurant.getLastNameContact());
		beanRestaurantResp.setNameRestaurant(beanClientClientRestaurant.getNameRestaurant());
		beanRestaurantResp.setPhoneContact(beanClientClientRestaurant.getPhoneContact());
		beanRestaurantResp.setPhoneRestaurant(beanClientClientRestaurant.getPhoneRestaurant());
		beanRestaurantResp.setReferenceContact(beanClientClientRestaurant.getReferenceContact());
		beanRestaurantResp.setReferenceRestaurant(beanClientClientRestaurant.getReferenceRestaurant());
		beanRestaurantResp.setRUCRestaurant(beanClientClientRestaurant.getRUCRestaurant());
		beanRestaurantResp.setSocialReason(beanClientClientRestaurant.getSocialReason());
		beanRestaurantResp.setNameContact(beanClientClientRestaurant.getNameContact());
		beanRestaurantResp.setId(beanClientClientRestaurant.getId());
		try {
			//-- Department
			Department beaDepartment=ubigeoHibernate.getDepartmentById(beanClientClientRestaurant.getIdDeparmentRestaurant());
			beanRestaurantResp.setIdDeparmentRestaurant(beanClientClientRestaurant.getIdDeparmentRestaurant());
			beanRestaurantResp.setNameDepartment(beaDepartment.getDepartmentName());
			//-- Province
			Province beanProvince=ubigeoHibernate.getProvinceById(beanClientClientRestaurant.getIdProvinceRestaurant());
			beanRestaurantResp.setNameProvince(beanProvince.getProvinceName());
			beanRestaurantResp.setIdProvinceRestaurant(beanClientClientRestaurant.getIdProvinceRestaurant());
			//-- District
			District beanDistrict=ubigeoHibernate.getDistrictById(beanClientClientRestaurant.getIdDistrictRestaurant());
			beanRestaurantResp.setNameDistrict(beanDistrict.getDistrictName());
			beanRestaurantResp.setIdDistrictRestaurant(beanClientClientRestaurant.getIdDistrictRestaurant());
			//--Image
			Image beanImage=imageHibernate.getImageById(beanClientClientRestaurant.getIdImage());
			beanRestaurantResp.setIdImage(beanClientClientRestaurant.getIdImage());
			if(beanClientClientRestaurant.getIdImage()==0){
				beanRestaurantResp.setNameImage("");
			}else{
				beanRestaurantResp.setNameImage(beanImage.getId()+"_"+beanImage.getCategoryImage());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return beanRestaurantResp;
	}
	
	public static SchedulerRestaurant convertFromServiceToDataBase(int idRestaurant,int dayWeek,String specifiHours){
		SchedulerRestaurant beanScheduler=new SchedulerRestaurant();
		beanScheduler.setIdRestaurant(idRestaurant);
		beanScheduler.setDayOfWeek(dayWeek);
		beanScheduler.setSpecificHour(specifiHours);
		return beanScheduler;
	}
	
	public static List<RestaurantResponse> convertFromDataBaseToListRestaurant(List<Restaurant> listClientRestaurant,
			UbigeoHibernate ubigeoHibernate,ImageHibernate imageHibernate){
		List<RestaurantResponse> listRestaurantResp=new ArrayList<RestaurantResponse>();
		for(Restaurant beanClientRestaurant:listClientRestaurant){
			RestaurantResponse beanRestaurant=new RestaurantResponse();
			beanRestaurant=convertFromDatabaseToRestaurantResponse(beanClientRestaurant,ubigeoHibernate,imageHibernate);
			listRestaurantResp.add(beanRestaurant);
		}
		return listRestaurantResp;
	}
	
	public static List<ProviderResponse> convertFromDataBaseToListProvider(List<Provider> listProvider,
			UbigeoHibernate ubigeoHibernate,ImageHibernate imageHibernate){
		List<ProviderResponse> listProviderResp=new ArrayList<ProviderResponse>();
		for(Provider beanProvider:listProvider){
			ProviderResponse beanProviderResponse=new ProviderResponse();
			beanProviderResponse=convertFromDatabaseToProviderResponse(beanProvider,ubigeoHibernate,imageHibernate);
			listProviderResp.add(beanProviderResponse);
		}
		return listProviderResp;
	}
	
	public static CheckActiveRestaurant convertValuesForDataBase(int idRestaurant){
		CheckActiveRestaurant beanCheckRestaurant=new CheckActiveRestaurant();
		beanCheckRestaurant.setIdRestaurant(idRestaurant);
		beanCheckRestaurant.setManualReception(0);
		beanCheckRestaurant.setMembershipPlan(4);
		beanCheckRestaurant.setStatus(1);
		beanCheckRestaurant.setTraining(0);
		beanCheckRestaurant.setVerificationAddress(0);
		beanCheckRestaurant.setVerificationSunat(0);
		beanCheckRestaurant.setVerificationUser(0);
		return beanCheckRestaurant;
	}
	
	public static CheckActiveProvider convertValuesForDataBaseProvider(int idProvider){
		CheckActiveProvider beanCheckProvider=new CheckActiveProvider();
		beanCheckProvider.setIdProvider(idProvider);
		beanCheckProvider.setManualReception(0);
		beanCheckProvider.setIdMemberShipPlan(4);
		beanCheckProvider.setStatus(1);
		beanCheckProvider.setTraining(0);
		beanCheckProvider.setVerificationAddress(0);
		beanCheckProvider.setVerificationSunat(0);
		beanCheckProvider.setVerificationUser(0);
		return beanCheckProvider;
	}
	
	public static CheckActiveRestaurant convertValuesCheckActiveRestaurantForUpdateDataBase(CheckRestaurantActive beanCheck){
		CheckActiveRestaurant beanCheckRestaurant=new CheckActiveRestaurant();
		beanCheckRestaurant.setIdRestaurant(beanCheck.getIdRestaurant());
		beanCheckRestaurant.setId(beanCheck.getId());
		beanCheckRestaurant.setManualReception(beanCheck.getManualReception());
		beanCheckRestaurant.setMembershipPlan(beanCheck.getIdMembershipPlan());
		beanCheckRestaurant.setStatus(beanCheck.getStatus());
		beanCheckRestaurant.setTraining(beanCheck.getTraining());
		beanCheckRestaurant.setVerificationAddress(beanCheck.getVerificationAddress());
		beanCheckRestaurant.setVerificationSunat(beanCheck.getVerificationSunat());
		beanCheckRestaurant.setVerificationUser(beanCheck.getVerificationUser());
		return beanCheckRestaurant;
	}
	
	public static CheckActiveProvider convertValuesCheckActiveProviderForUpdateDataBase(CheckProviderActive beanCheck){
		CheckActiveProvider beanCheckProvider=new CheckActiveProvider();
		beanCheckProvider.setIdProvider(beanCheck.getIdProvider());
		beanCheckProvider.setId(beanCheck.getId());
		beanCheckProvider.setManualReception(beanCheck.getManualReception());
		beanCheckProvider.setIdMemberShipPlan(beanCheck.getIdMembershipPlan());
		beanCheckProvider.setStatus(beanCheck.getStatus());
		beanCheckProvider.setTraining(beanCheck.getTraining());
		beanCheckProvider.setVerificationAddress(beanCheck.getVerificationAddress());
		beanCheckProvider.setVerificationSunat(beanCheck.getVerificationSunat());
		beanCheckProvider.setVerificationUser(beanCheck.getVerificationUser());
		return beanCheckProvider;
	}

	public static CheckRestaurantActive convertFromDataBaseToCheckRestaurantActive(CheckActiveRestaurant beanCheckActRest){
		//--Set check Values
		CheckRestaurantActive beanCheckRestaurantActive=new CheckRestaurantActive();
		beanCheckRestaurantActive.setId(beanCheckActRest.getId());
		beanCheckRestaurantActive.setIdMembershipPlan(beanCheckActRest.getMembershipPlan());
		beanCheckRestaurantActive.setIdRestaurant(beanCheckActRest.getIdRestaurant());
		beanCheckRestaurantActive.setManualReception(beanCheckActRest.getManualReception());
		beanCheckRestaurantActive.setTraining(beanCheckActRest.getTraining());
		beanCheckRestaurantActive.setVerificationAddress(beanCheckActRest.getVerificationAddress());
		beanCheckRestaurantActive.setVerificationSunat(beanCheckActRest.getVerificationSunat());
		beanCheckRestaurantActive.setVerificationUser(beanCheckActRest.getVerificationUser());
		beanCheckRestaurantActive.setStatus(beanCheckActRest.getStatus());
		return beanCheckRestaurantActive;
	}
	
	public static CheckProviderActive convertFromDataBaseToCheckProviderActive(CheckActiveProvider beanCheckActProv){
		//--Set check Values
		CheckProviderActive beanCheckActive=new CheckProviderActive();
		beanCheckActive.setId(beanCheckActProv.getId());
		beanCheckActive.setIdMembershipPlan(beanCheckActProv.getIdMemberShipPlan());
		beanCheckActive.setIdProvider(beanCheckActProv.getIdProvider());
		beanCheckActive.setManualReception(beanCheckActProv.getManualReception());
		beanCheckActive.setTraining(beanCheckActProv.getTraining());
		beanCheckActive.setVerificationAddress(beanCheckActProv.getVerificationAddress());
		beanCheckActive.setVerificationSunat(beanCheckActProv.getVerificationSunat());
		beanCheckActive.setVerificationUser(beanCheckActProv.getVerificationUser());
		beanCheckActive.setStatus(beanCheckActProv.getStatus());
		return beanCheckActive;
	}
	
	public static List<BeanPlanMember> convertFromDataBaseToBeanPlanMenber(List<PlanMember> listPlanMember){
		List<BeanPlanMember> listBeanPlanMember=new ArrayList<BeanPlanMember>();
		for(PlanMember beanPlanMember:listPlanMember){
			BeanPlanMember objBeanPlanMember=new BeanPlanMember();
			objBeanPlanMember.setValuePlanMenber(beanPlanMember.getValuePlanMenber());
			objBeanPlanMember.setStatus(beanPlanMember.getStatus());
			objBeanPlanMember.setId(beanPlanMember.getId());
			listBeanPlanMember.add(objBeanPlanMember);
		}
		return listBeanPlanMember;
	}

	public static List<PresentationResponse> convertListPresentationToListPresentationResponse(List<Presentation> listPresentation){
		List<PresentationResponse> listPresentationResponse=new ArrayList<PresentationResponse>();
		for(Presentation beanPresentation:listPresentation){
			PresentationResponse beanPresentationResponse=new PresentationResponse();
			beanPresentationResponse.setIdPresentation(beanPresentation.getId());
			beanPresentationResponse.setNamePresentation(beanPresentation.getNamePresentation());
			listPresentationResponse.add(beanPresentationResponse);
		}
		return listPresentationResponse;
	}
	
	public static List<CategoryResponse> convertListCategoryToListCategoryResponse(List<Category> listCategory){
		List<CategoryResponse> listCategoryResponse=new ArrayList<CategoryResponse>();
		for(Category beanCategory:listCategory){
			CategoryResponse beanCategoryResponse=new CategoryResponse();
			beanCategoryResponse.setIdCategory(beanCategory.getId());
			beanCategoryResponse.setNameCategory(beanCategory.getNameCategory());
			listCategoryResponse.add(beanCategoryResponse);
		}
		return listCategoryResponse;
	}
} 
