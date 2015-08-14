package com.rest.web.service.inmobile.facade.impl;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.canonical.bean.provider.ProviderResponse;
import com.canonical.bean.restaurant.RestaurantResponse;
import com.canonical.bean.ubigeo.UbigeoResponse;
import com.canonical.bean.user.UserRequest;
import com.canonical.bean.user.UserResponse;
import com.rest.web.service.inmobile.bean.EmailBean;
import com.rest.web.service.inmobile.bean.ServiceBean;
import com.rest.web.service.inmobile.facade.ReqRespManager;
import com.rest.web.service.inmobile.facade.SystemParamManager;
import com.rest.web.service.inmobile.facade.UbigeoManager;
import com.rest.web.service.inmobile.facade.UserManager;
import com.rest.web.service.inmobile.hibernate.ImageHibernate;
import com.rest.web.service.inmobile.hibernate.ProviderHibernate;
import com.rest.web.service.inmobile.hibernate.RestaurantHibernate;
import com.rest.web.service.inmobile.hibernate.UbigeoHibernate;
import com.rest.web.service.inmobile.hibernate.UserHibernate;
import com.rest.web.service.inmobile.hibernate.bean.Restaurant;
import com.rest.web.service.inmobile.hibernate.bean.Provider;
import com.rest.web.service.inmobile.hibernate.bean.RequestResponse;
import com.rest.web.service.inmobile.hibernate.bean.User;
import com.rest.web.service.inmobile.util.CommonConstants;
import com.rest.web.service.inmobile.util.ConvertClass;
import com.rest.web.service.inmobile.util.MailUtil;
import com.rest.web.service.inmobile.util.UtilMethods;

@Service
@Transactional
public class UserManagerImpl implements UserManager{
	private static final Logger logger = LoggerFactory.getLogger(UserManagerImpl.class);
	@Autowired
	private UserHibernate userHibernate;
	@Autowired
	ReqRespManager reqRespManager;
	@Autowired
	private RestaurantHibernate restaurantHibernate;
	@Autowired
	private ProviderHibernate providerHibernate;
	@Autowired
	private UbigeoHibernate ubigeoHibernate;
	@Autowired
	private ImageHibernate imageHibernate;
	@Autowired
	private UbigeoManager ubigeoManager;
	@Autowired
	private SystemParamManager systemParamManager;
	
	public UserResponse saveUserInformation(UserRequest userRequest) {
		logger.info(CommonConstants.Logger.LOGGER_START);
		UserResponse userBeanResponse=new UserResponse();
		//--Save Json in Data Base
		RequestResponse valueReqResp=(RequestResponse)reqRespManager.saveOrUpdate(userRequest, 
				CommonConstants.TypeOperationReqResp.OPERATION_CREATE_USER, 0,0);
		System.out.println("ID Response : "+valueReqResp.getId());
		int idUser=0;
		try {
			boolean validateEmail=userHibernate.existEmail(userRequest.getEmail());
			//--Verify if email exist in Data Base
			if(!validateEmail){
				//--Save information in Data Base
				User userDataBase=ConvertClass.convertUserRequestToDataBase(userRequest);
				userDataBase.setStatus(1);
				idUser=userHibernate.saveUserResponseId(userDataBase);
				userBeanResponse.setIdUser(idUser);
				//--URL
	            String URL=buildURL(idUser);
				//--Send Email with URL
				System.out.println("Before Mandar el correo");
				buidlEmailCreationUser(userRequest.getEmail(),URL);
				//--Build Response for web service client
				
				userBeanResponse.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_SUCCESS_USER);
				userBeanResponse.setMessagesResponse("The user was created successfully.");
				userBeanResponse.setDescription("Url : "+URL);
			}else{
				userBeanResponse.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_EXITS_USER);
				userBeanResponse.setMessagesResponse("The Email exist in our Data Base");
			}
			
		} catch (Exception e) {
			userBeanResponse.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_ERROR);
			userBeanResponse.setMessagesResponse(e.getMessage());
		} 
		//--Save Json in Data Base
		reqRespManager.saveOrUpdate(userBeanResponse, 
				CommonConstants.TypeOperationReqResp.OPERATION_CREATE_USER, userBeanResponse.getIdUser(),
				valueReqResp.getId());
		logger.info(CommonConstants.Logger.LOGGER_END);
		return userBeanResponse;
	}
	
	public void buidlEmailCreationUser(String emilTo,String URL)throws MessagingException{
		EmailBean emailBean=systemParamManager.getEmailInSystemParam(CommonConstants.SystemParam.SYSTEM_PARAM_GENERAL_EMAIL,
				CommonConstants.Email.TYPE_OPERATION_CREATE_USER);
		//--Set Body with final values
		emailBean.setBodyEmail(setValuesToFinalBodyEmail(emailBean.getBodyEmail(), URL));
		emailBean.setToEmail(emilTo);
		MailUtil.sendEmail(emailBean);
	}
	
	private String setValuesToFinalBodyEmail(String email,String URL){
		email=UtilMethods.getFinalValuesForEmail(email, CommonConstants.Email.URL, URL);
		return email;
	}
	
	public void buidlEmailActivationUser(String emilTo,String URL)throws MessagingException{
		EmailBean emailBean=systemParamManager.getEmailInSystemParam(CommonConstants.SystemParam.SYSTEM_PARAM_GENERAL_EMAIL,
				CommonConstants.Email.TYPE_OPERATION_REFORWARD_LINK_USER);
		//--Set Body with final values
		emailBean.setBodyEmail(setValuesToFinalBodyEmail(emailBean.getBodyEmail(), URL));
		emailBean.setToEmail(emilTo);
		MailUtil.sendEmail(emailBean);
	}

	public String buildURL(int idUser){
		logger.info(CommonConstants.Logger.LOGGER_START);
		ServiceBean serviceBean=systemParamManager.getValuesForService(CommonConstants.SystemParam.SYSTEM_PARAM_GENERAL_SERVICE);
		String URL=serviceBean.getUrlService()+serviceBean.getProjectName()+serviceBean.getActionName();
		String encriptedValue=UtilMethods.encriptValue(String.valueOf(idUser));
		System.out.println("Encripted ID : "+encriptedValue);
		URL=URL+encriptedValue;
		logger.info(CommonConstants.Logger.LOGGER_END+" ** Final URL : "+URL);
		return URL;
	}

	public UserResponse validateUser(UserRequest userRequest) {
		System.out.println("Entreeeeee validateUser");
		UserResponse userBeanResponse=new UserResponse();
		//--Save Json in Data Base
		RequestResponse valueReqResp=(RequestResponse)reqRespManager.saveOrUpdate(userRequest, 
				CommonConstants.TypeOperationReqResp.OPERATION_VALIDATE_USER, 0,0);
		System.out.println("ID Response : "+valueReqResp.getId());
		try {
			boolean validateEmail=userHibernate.existEmail(userRequest.getEmail());
			if(validateEmail){
				User userBean=userHibernate.validateUser(userRequest.getEmail(), userRequest.getPassword());
				if(userBean!=null){
					if(userBean.getStatus()==1){
						//Su cuenta no esta activada
						userBeanResponse.setIdUser(userBean.getId());
						userBeanResponse.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_ACCOUNT_INACTIVE);
						userBeanResponse.setMessagesResponse("The Account still inactive");
						String URL=buildURL(userBean.getId());
						//--Send Email Again with URL
						System.out.println("Before Mandar el correo");
						buidlEmailActivationUser(userRequest.getEmail(),URL);
						userBeanResponse.setDescription("Url : "+URL);
					}else if(userBean.getStatus()==2){
						if(userBean.getTypeUser()==2){
							//Pantalla de ingresar datos para el restaurante
							userBeanResponse.setIdUser(userBean.getId());
							userBeanResponse.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_SUCCESS_VALIDATION);
							userBeanResponse.setMessagesResponse(CommonConstants.CodeResponse.CODE_RESPONSE_IS_RESTAURANT);
							//--Get Restaurant Values
							Restaurant beanClientClientRestaurant=restaurantHibernate.getDataRestaurantByUserId(userBean.getId());
							if(beanClientClientRestaurant!=null){
								RestaurantResponse beanRestaurantResponse=ConvertClass.convertFromDatabaseToRestaurantResponse(beanClientClientRestaurant,ubigeoHibernate,imageHibernate);
								userBeanResponse.setBeanResponseRestaurant(beanRestaurantResponse);
								UbigeoResponse beanUbigeoResponseProvince=ubigeoManager.listAllProvince(beanClientClientRestaurant.getIdDeparmentRestaurant());
								userBeanResponse.setBeanUbigeoResponseProvince(beanUbigeoResponseProvince);
								UbigeoResponse beanUbigeoDistrict=ubigeoManager.listAllDistrict(beanClientClientRestaurant.getIdProvinceRestaurant());
								userBeanResponse.setBeanUbigeoResponseDistrict(beanUbigeoDistrict);
							}
						}
						else{
							//Pantalla de ingresar datos para el proveedor
							userBeanResponse.setIdUser(userBean.getId());
							userBeanResponse.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_SUCCESS_VALIDATION);
							userBeanResponse.setMessagesResponse(CommonConstants.CodeResponse.CODE_RESPONSE_IS_PROVIDER);
							//--Get Provider Values
							Provider beanProvider=providerHibernate.getDataProviderByUserId(userBean.getId());
							if(beanProvider!=null){
								ProviderResponse beanProviderResponse=ConvertClass.convertFromDatabaseToProviderResponse(beanProvider, ubigeoHibernate, imageHibernate);
								userBeanResponse.setBeanResponseProvider(beanProviderResponse);
								UbigeoResponse beanUbigeoResponseProvince=ubigeoManager.listAllProvince(beanProviderResponse.getIdDeparmentProvider());
								userBeanResponse.setBeanUbigeoResponseProvince(beanUbigeoResponseProvince);
								UbigeoResponse beanUbigeoDistrict=ubigeoManager.listAllDistrict(beanProviderResponse.getIdProvinceProvider());
								userBeanResponse.setBeanUbigeoResponseDistrict(beanUbigeoDistrict);
							}
						}
						
					}else if(userBean.getStatus()==3){
						userBeanResponse.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_SUCCESS_VALIDATION);
						userBeanResponse.setMessagesResponse(CommonConstants.CodeResponse.CODE_RESPONSE_ACCOUNT_PENDING_VALDATION);
					}else if(userBean.getStatus()==4){
						if(userBean.getTypeUser()==0){
							userBeanResponse.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_SUCCESS_VALIDATION);
							userBeanResponse.setMessagesResponse(CommonConstants.CodeResponse.CODE_RESPONSE_ACCOUNT_ADMIN);
						}
						
					}
					userBeanResponse.setEmail(userBean.getEmail());
					userBeanResponse.setStatus(userBean.getStatus());
					userBeanResponse.setTypeUser(userBean.getTypeUser());
				}else{
					userBeanResponse.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_FAIL_VALIDATION);
					userBeanResponse.setMessagesResponse("The email or password is incorrect");
					userBeanResponse.setIdUser(9999);
				}
			}else{
				userBeanResponse.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_NOT_EXITS_USER);
				userBeanResponse.setMessagesResponse("The email don't exist ins our Data Base");
			}
			
			
		} catch (Exception e) {
			userBeanResponse.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_ERROR);
			userBeanResponse.setMessagesResponse(e.getMessage());
		}
		//--Save Json in Data Base
		reqRespManager.saveOrUpdate(userBeanResponse,CommonConstants.TypeOperationReqResp.OPERATION_CREATE_USER, userBeanResponse.getIdUser(),
			valueReqResp.getId());
		return userBeanResponse;
	}

	public UserResponse activeAccount(String idUSerEncripted) {
		UserResponse userBeanResponse=new UserResponse();
		try {
			String desencriptValue=UtilMethods.descriptValue(idUSerEncripted);
			logger.info("ID descripted : "+desencriptValue);
			User beanUser=userHibernate.findUSerBean(desencriptValue);
			if(beanUser==null){
				userBeanResponse.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_LINK_USED);
				userBeanResponse.setMessagesResponse("This link was used before.");
				userBeanResponse.setDescription("The User id "+desencriptValue);
				return userBeanResponse;
			}
			beanUser.setStatus(2);
			//--Update status User
			userHibernate.saveUserResponseId(beanUser);
			//--Redirect to Page
			userBeanResponse.setIdUser(beanUser.getId());
			if(beanUser.getTypeUser()==2){
				userBeanResponse.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_IS_RESTAURANT);
				userBeanResponse.setMessagesResponse("Is restaurant");
				userBeanResponse.setDescription("The User id "+beanUser.getId()+" is restaurant");
				userBeanResponse.setDescription(beanUser.getEmail());
			}else{
				userBeanResponse.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_IS_PROVIDER);
				userBeanResponse.setMessagesResponse("Is provider");
				userBeanResponse.setDescription(beanUser.getEmail());
			}
		} catch (Exception e) {
			userBeanResponse.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_ERROR);
			userBeanResponse.setMessagesResponse(e.getMessage());
		}
		return userBeanResponse;
	}
	
}
