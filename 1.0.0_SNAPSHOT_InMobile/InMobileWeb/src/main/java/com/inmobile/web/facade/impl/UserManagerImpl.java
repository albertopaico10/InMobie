package com.inmobile.web.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.inmobile.web.bean.RegisterUserDTO;
import com.inmobile.web.bean.ReturnService;
import com.inmobile.web.bean.UbigeoDepartmentDTO;
import com.inmobile.web.bean.UbigeoDistrictDTO;
import com.inmobile.web.bean.UbigeoProvinceDTO;
import com.inmobile.web.bean.canonical.ubigeo.Ubigeo;
import com.inmobile.web.bean.canonical.ubigeo.UbigeoResponse;
import com.inmobile.web.bean.canonical.user.UserRequest;
import com.inmobile.web.bean.canonical.user.UserResponse;
import com.inmobile.web.controller.LoginController;
import com.inmobile.web.facade.UserManager;
import com.inmobile.web.util.CommonConstants;
import com.inmobile.web.util.ConvertClassFormat;
import com.inmobile.web.util.UtilMethods;

@Service
public class UserManagerImpl implements UserManager{
	private static final Logger logger = LoggerFactory.getLogger(UserManagerImpl.class);
	
	public ReturnService registerUserInMobile(RegisterUserDTO beanUser) {
		logger.info(CommonConstants.Logger.LOGGER_START);
		ReturnService beanReturn=new ReturnService();
		RestTemplate restTemplate=new RestTemplate();
		UserRequest beanRequest=ConvertClassFormat.convertWebToServiceUser(beanUser);
		logger.info("Valor Request : "+UtilMethods.fromObjectToString(beanRequest));
		UserResponse beanResponse=restTemplate.postForObject(CommonConstants.URLService.URL_REGISTER_USER, beanRequest, UserResponse.class);
		logger.info("Valor Response : "+UtilMethods.fromObjectToString(beanResponse));
		if(CommonConstants.Response.RESPONSE_USER_SUCCESS.equals(beanResponse.getCodeResponse())){
			beanReturn.setReturnPage(CommonConstants.Page.REDIRECT_SENDEMAIL);
		}else if(CommonConstants.Response.RESPONSE_USER_EXIST.equals(beanResponse.getCodeResponse())||
				CommonConstants.Response.RESPONSE_ERROR.equals(beanResponse.getCodeResponse())){
			beanReturn.setReturnPage(CommonConstants.Page.REDIRECT_LOGIN_PAGE);
			beanReturn.setSpecificMessages(beanResponse.getMessagesResponse());
		}
		beanReturn.setMessages(beanResponse.getCodeResponse());
		logger.info(CommonConstants.Logger.LOGGER_END);
		return beanReturn;
	}

	public ReturnService validateUser(RegisterUserDTO beanUser) {
		logger.info(CommonConstants.Logger.LOGGER_START);
		ReturnService beanReturn=new ReturnService();
		RestTemplate restTemplate=new RestTemplate();
		try {
			UserRequest beanRequest=ConvertClassFormat.convertWebToServiceUser(beanUser);
			logger.info("Valor Request : "+UtilMethods.fromObjectToString(beanRequest));
			logger.info("URL : "+CommonConstants.URLService.URL_VALIDATION_USER);
			UserResponse beanResponse=restTemplate.postForObject(CommonConstants.URLService.URL_VALIDATION_USER, beanRequest, UserResponse.class);
			logger.info("Valor Response : "+UtilMethods.fromObjectToString(beanResponse));
			if(CommonConstants.Response.RESPONSE_SUCCESS_VALIDATION.equals(beanResponse.getCodeResponse())){
	//			//--Load Departments
	//			UbigeoResponse ubigeoResponse=restTemplate.getForObject(CommonConstants.URLService.URL_LIST_DEPARTMENTS, UbigeoResponse.class);
				if(CommonConstants.Response.RESPONSE_IS_RESTAURANT.equals(beanResponse.getMessagesResponse())){
					beanReturn.setReturnPage(CommonConstants.Page.REDIRECT_RESTAURANT);
					//--Convert Response Bean Service to DTO
					if(beanResponse.getBeanResponseRestaurant()!=null){
						beanReturn.setBeanRestaurantDTO(ConvertClassFormat.convertFromServiceToRestaurantDTO(beanResponse.getBeanResponseRestaurant()));
						beanReturn.setListProvinceDTO(ConvertClassFormat.convertResponsetToListUbigeoProvinceDTO(beanResponse.getBeanUbigeoResponseProvince()));
						beanReturn.setListDistrictDTO(ConvertClassFormat.convertResponsetToListUbigeoDistrictDTO(beanResponse.getBeanUbigeoResponseDistrict()));
						
					}
				}else if(CommonConstants.Response.RESPONSE_IS_PROVIDER.equals(beanResponse.getMessagesResponse())){
					beanReturn.setReturnPage(CommonConstants.Page.REDIRECT_PROVIDER);
				}else if(CommonConstants.Response.RESPONSE_ACCOUNT_PENDING_VALIDATION.equals(beanResponse.getMessagesResponse())) {
					beanReturn.setReturnPage(CommonConstants.Page.REDIRECT_ACCOUNT_PENDING);
				}else if(CommonConstants.Response.RESPONSE_ACCOUNT_ADMIN.equals(beanResponse.getMessagesResponse())) {
					beanReturn.setReturnPage(CommonConstants.Page.REDIRECT_INIT_ADMIN_PAGE);
				}
	//			beanReturn.setSpecificMessages(beanResponse.getDescription());
				beanReturn.setEmail(beanResponse.getEmail());
				beanReturn.setMessages(beanResponse.getCodeResponse());
			}else if(CommonConstants.Response.RESPONSE_FAIL_VALIDATION.equals(beanResponse.getCodeResponse()) ||
					CommonConstants.Response.RESPONSE_NOT_EXITS_USER.equals(beanResponse.getCodeResponse())){
				beanReturn.setReturnPage(CommonConstants.Page.REDIRECT_LOGIN_PAGE);
				beanReturn.setMessages(beanResponse.getCodeResponse());
			}else if(CommonConstants.Response.RESPONSE_ACCOUNT_INACTIVE.equals(beanResponse.getCodeResponse())){
				beanReturn.setReturnPage(CommonConstants.Page.REDIRECT_INACTIVE_ACCOUNT_PAGE);
				beanReturn.setMessages(beanResponse.getCodeResponse());
			}else{
				beanReturn.setReturnPage(CommonConstants.Page.REDIRECT_LOGIN_PAGE);
				beanReturn.setMessages("ERROR");
				beanReturn.setSpecificMessages("Service don't response.");
			}
			beanReturn.setIdUser(beanResponse.getIdUser());
		} catch (Exception e) {
			beanReturn.setReturnPage(CommonConstants.Page.REDIRECT_LOGIN_PAGE);
			beanReturn.setMessages("ERROR");
			beanReturn.setSpecificMessages("Service don't response.");
		}
		logger.info(CommonConstants.Logger.LOGGER_END);
		return beanReturn;
	}
	
	public ReturnService activeAccountUser(String idUser){
		logger.info(CommonConstants.Logger.LOGGER_START);
		ReturnService returnServiceBean=new ReturnService();
		RestTemplate restTemplate=new RestTemplate();
		UserRequest beanRequest=new UserRequest();
		beanRequest.setEncriptUser(idUser);
		logger.info("Valor Request : "+UtilMethods.fromObjectToString(beanRequest));
		logger.info("URL : "+CommonConstants.URLService.URL_ACTIVATE_USER);
		UserResponse beanResponse=restTemplate.postForObject(CommonConstants.URLService.URL_ACTIVATE_USER, beanRequest, UserResponse.class);
		logger.info("Valor Response : "+UtilMethods.fromObjectToString(beanResponse));
		if(!CommonConstants.Response.RESPONSE_ERROR.equals(beanResponse.getCodeResponse())){
			returnServiceBean.setIdUser(beanResponse.getIdUser());
			returnServiceBean.setSpecificMessages(beanResponse.getDescription());
			if(CommonConstants.Response.RESPONSE_IS_PROVIDER.equals(beanResponse.getCodeResponse())){
				returnServiceBean.setReturnPage(CommonConstants.Page.REDIRECT_PROVIDER);
			}else if(CommonConstants.Response.RESPONSE_IS_RESTAURANT.equals(beanResponse.getCodeResponse())){
				returnServiceBean.setReturnPage(CommonConstants.Page.REDIRECT_RESTAURANT);
			}else if(CommonConstants.Response.RESPONSE_LINK_USED.equals(beanResponse.getCodeResponse())){
				returnServiceBean.setReturnPage(CommonConstants.Page.REDIRECT_MESSAGE_LINK_USED);
			}
		}else{
			returnServiceBean.setReturnPage(CommonConstants.Page.REDIRECT_ERROR);
		}
		returnServiceBean.setSpecificMessages(beanResponse.getDescription());
		logger.info(CommonConstants.Logger.LOGGER_END);
		return returnServiceBean;
	}

	public List<UbigeoDepartmentDTO> listDepartment() {
		logger.info(CommonConstants.Logger.LOGGER_START);
		List<UbigeoDepartmentDTO> listUbiDepDTO=new ArrayList<UbigeoDepartmentDTO>();
		RestTemplate restTemplate=new RestTemplate();
		UbigeoResponse ubigeoResponse=restTemplate.getForObject(CommonConstants.URLService.URL_LIST_DEPARTMENTS, UbigeoResponse.class);
		if(CommonConstants.Response.RESPONSE_SUCCESS_DEPARTMENT.equals(ubigeoResponse.getCodeResponse())){
			listUbiDepDTO=ConvertClassFormat.convertResponsetToListUbigeoDepartmentDTO(ubigeoResponse);
		}
		logger.info(CommonConstants.Logger.LOGGER_END);
		return listUbiDepDTO;
	}

	public List<UbigeoProvinceDTO> listProvinceByDepartment(String idDepartment) {
		logger.info(CommonConstants.Logger.LOGGER_START);
		List<UbigeoProvinceDTO> listUbiProvDTO=new ArrayList<UbigeoProvinceDTO>();
		RestTemplate restTemplate=new RestTemplate();
		UbigeoResponse ubigeoResponse=restTemplate.getForObject(CommonConstants.URLService.URL_LIST_PROVINCE+"/"+idDepartment, UbigeoResponse.class);
		if(CommonConstants.Response.RESPONSE_SUCCESS_PROVINCE.equals(ubigeoResponse.getCodeResponse())){
			listUbiProvDTO=ConvertClassFormat.convertResponsetToListUbigeoProvinceDTO(ubigeoResponse);
		}
		logger.info(CommonConstants.Logger.LOGGER_END);
		return listUbiProvDTO;
	}

	public List<UbigeoDistrictDTO> listDistrictByProvince(String idProvince) {
		logger.info(CommonConstants.Logger.LOGGER_START);
		List<UbigeoDistrictDTO> listUbiDistrDTO=new ArrayList<UbigeoDistrictDTO>();
		RestTemplate restTemplate=new RestTemplate();
		UbigeoResponse ubigeoResponse=restTemplate.getForObject(CommonConstants.URLService.URL_LIST_DISTRICT+"/"+idProvince, UbigeoResponse.class);
		if(CommonConstants.Response.RESPONSE_SUCCESS_DISTRICT.equals(ubigeoResponse.getCodeResponse())){
			listUbiDistrDTO=ConvertClassFormat.convertResponsetToListUbigeoDistrictDTO(ubigeoResponse);
		}
		logger.info(CommonConstants.Logger.LOGGER_END);
		return listUbiDistrDTO;
	}

	
	
}
