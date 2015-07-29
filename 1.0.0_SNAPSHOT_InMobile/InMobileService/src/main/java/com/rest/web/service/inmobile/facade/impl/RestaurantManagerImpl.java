package com.rest.web.service.inmobile.facade.impl;

import java.util.List;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.canonical.bean.restaurant.CheckRestaurantActive;
import com.canonical.bean.restaurant.ListRestaurant;
import com.canonical.bean.restaurant.RestaurantRequest;
import com.canonical.bean.restaurant.RestaurantResponse;
import com.canonical.bean.restaurant.SchedulerRestaurantRequest;
import com.canonical.bean.restaurant.SchedulerRestaurantResponse;
import com.canonical.bean.restaurant.VerificationRestaurant;
import com.rest.web.service.inmobile.controller.UserController;
import com.rest.web.service.inmobile.facade.ReqRespManager;
import com.rest.web.service.inmobile.facade.RestaurantManage;
import com.rest.web.service.inmobile.facade.UbigeoManager;
import com.rest.web.service.inmobile.hibernate.CheckActiveRestaurantHibernate;
import com.rest.web.service.inmobile.hibernate.ImageHibernate;
import com.rest.web.service.inmobile.hibernate.PlanMemberHibernate;
import com.rest.web.service.inmobile.hibernate.RestaurantHibernate;
import com.rest.web.service.inmobile.hibernate.SchedulerRestaurantHibernate;
import com.rest.web.service.inmobile.hibernate.UbigeoHibernate;
import com.rest.web.service.inmobile.hibernate.UserHibernate;
import com.rest.web.service.inmobile.hibernate.bean.CheckActiveRestaurant;
import com.rest.web.service.inmobile.hibernate.bean.ClientRestaurant;
import com.rest.web.service.inmobile.hibernate.bean.PlanMember;
import com.rest.web.service.inmobile.hibernate.bean.RequestResponse;
import com.rest.web.service.inmobile.hibernate.bean.SchedulerRestaurant;
import com.rest.web.service.inmobile.hibernate.bean.User;
import com.rest.web.service.inmobile.util.CommonConstants;
import com.rest.web.service.inmobile.util.ConvertClass;
import com.rest.web.service.inmobile.util.MailUtil;

@Service
@Transactional
public class RestaurantManagerImpl implements RestaurantManage {
	private static final Logger logger = LoggerFactory.getLogger(RestaurantManagerImpl.class);
	
	@Autowired
	private ReqRespManager reqRespManager;
	
	@Autowired
	private UserHibernate userHibernate;
	@Autowired
	private RestaurantHibernate restaurantHibernate;
	@Autowired
	private SchedulerRestaurantHibernate schedulerRestaurantHibernate;
	@Autowired
	private ImageHibernate imageHibernate;
	@Autowired
	private UbigeoHibernate ubigeoHibernate;
	@Autowired
	private CheckActiveRestaurantHibernate checkActiveRestaurantHibernate;
	@Autowired
	private PlanMemberHibernate planMemberHibernate;
	
	public RestaurantResponse saveRestaurant(RestaurantRequest beanRequest) {
		
		RestaurantResponse restaurantResponseBean=new RestaurantResponse();
		
		//--Save Json in Data Base
		RequestResponse valueReqResp=(RequestResponse)reqRespManager.saveOrUpdate(beanRequest, 
				CommonConstants.TypeOperationReqResp.OPERATION_SAVE_RESTAURANT,beanRequest.getIdUser(),0);
		System.out.println("ID Response : "+valueReqResp.getId());
		
		try {
			//--Convert canonical request to object database
			ClientRestaurant clientResturant=ConvertClass.convertRestaurantRequestToDataBase(beanRequest);
			clientResturant.setStatus(1);
			restaurantHibernate.saveRestaurant(clientResturant);
			
			//--Update status user to 3
			User beanUser=userHibernate.findUSerBeanActiveAccount(String.valueOf(beanRequest.getIdUser()));
//			beanUser.setStatus(3);
			//--Update status User
			userHibernate.saveUserResponseId(beanUser);
			restaurantResponseBean.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_SUCCESS_RESTAURANT);
			restaurantResponseBean.setMessagesResponse("The user create one part of his registration");
			restaurantResponseBean.setIdUser(beanRequest.getIdUser());
			
		} catch (Exception e) {
			restaurantResponseBean.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_ERROR);
			restaurantResponseBean.setMessagesResponse(e.getMessage());
			restaurantResponseBean.setIdUser(beanRequest.getIdUser());
		}
		reqRespManager.saveOrUpdate(restaurantResponseBean, 
				CommonConstants.TypeOperationReqResp.OPERATION_SAVE_RESTAURANT,beanRequest.getIdUser(),valueReqResp.getId());
		return restaurantResponseBean;
	}

	public SchedulerRestaurantResponse saveRestaurantScheduler(SchedulerRestaurantRequest beanRequest) {
		SchedulerRestaurantResponse beanResponse=new SchedulerRestaurantResponse();
		//--Save Json in Data Base
		RequestResponse valueReqResp=(RequestResponse)reqRespManager.saveOrUpdate(beanRequest, 
				CommonConstants.TypeOperationReqResp.OPERATION_SAVE_RESTAURANT_SCHEDULER,beanRequest.getIdUser(),0);
		System.out.println("ID Response : "+valueReqResp.getId());
		try {
			ClientRestaurant beanClientRestaurant=restaurantHibernate.getDataRestaurantByUserId(beanRequest.getIdUser());
			String[] arrayScheduler=beanRequest.getDaysAndHours().split("//");
			for(int i=0;i<arrayScheduler.length;i++){
				if(!arrayScheduler[i].isEmpty()){
					String[] detailDayHours=arrayScheduler[i].split("-");
					logger.info("** Days : "+detailDayHours[0]);
					logger.info("** Hours : "+detailDayHours[1]);
					SchedulerRestaurant beanScheduler=ConvertClass.convertFromServiceToDataBase(beanClientRestaurant.getId(), Integer.parseInt(detailDayHours[0]), detailDayHours[1]);
					schedulerRestaurantHibernate.saveSchedulerRestaurant(beanScheduler);
					
				}
			}
			User beanUser=userHibernate.findUSerBeanActiveAccount(String.valueOf(beanRequest.getIdUser()));
			//-- Save in table tb_check_active_restaurant
			logger.info("Valor a grabar : "+beanClientRestaurant.getId());
			CheckActiveRestaurant beanCheckRestaurant=ConvertClass.convertValuesForDataBase(beanClientRestaurant.getId());
			checkActiveRestaurantHibernate.saveCheckActiveRestaurant(beanCheckRestaurant);
			//-- End
			//-- Send Email
			buidlEmailFinalStepRegistration(beanUser.getEmail());
			//-- End
			//--Update status User
			beanUser.setStatus(3);
			userHibernate.saveUserResponseId(beanUser);
			//--End
			beanResponse.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_SUCCESS_SCHEDULER);
			beanResponse.setMessagesResponse("Se grabo con éxito el Scheduler del Restaurantero");
			beanResponse.setIdUser(beanRequest.getIdUser());
		} catch (Exception e) {
			beanResponse.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_ERROR);
			beanResponse.setMessagesResponse(e.getMessage());
			beanResponse.setIdUser(beanRequest.getIdUser());
		}
		reqRespManager.saveOrUpdate(beanResponse, 
				CommonConstants.TypeOperationReqResp.OPERATION_SAVE_RESTAURANT,beanRequest.getIdUser(),valueReqResp.getId());
		return beanResponse;
	}
	
	public void buidlEmailFinalStepRegistration(String emilTo)throws MessagingException{
		String body="<html>"
				+ "<body>"
				+ "<p>"
				+ "<b>InMobile Registro de Cuenta - Test Email</b>"
				+ "</p><br/>"
				+ "<p>Estimo Usario:</p><br/>"
				+ "<p>Su información esta siendo verificada por nuestro personal, de tener alguna duda nos pondremos en contacto con Ud.</p>"
				+ "<p><b>Gracias</b></p><br/>"
				+ "<p><b>Atte.</b></p><br/>"
				+ "<p><b>Plaza Proveedor</b></p><br/>"
				+ "</body>"
				+ "</html>";
		MailUtil.sendEmail(emilTo,CommonConstants.Email.SUBJECT_FINAL_STEP_REGISTRATON,body);
	}

	public ListRestaurant listRestaurantPendingActive() {
		logger.info(CommonConstants.Logger.LOGGER_START);
		ListRestaurant listRestaurant = new ListRestaurant();
		//--Save Json in Data Base
		RequestResponse valueReqResp=(RequestResponse)reqRespManager.saveOrUpdate("", 
				CommonConstants.TypeOperationReqResp.OPERATION_LIST_RESTAURANT_PENDING_ACTIVE,0,0);
		System.out.println("ID Response : "+valueReqResp.getId());
		try {
			List<ClientRestaurant> listClientRestaurant=restaurantHibernate.listRestaurantPendingActive();
			logger.info("Cantidad de filas usuarios pendientes activar : "+listClientRestaurant.size());
			if(listClientRestaurant.size()>0){
				listRestaurant.setListRestaurantResponse(ConvertClass.convertFromDataBaseToListRestaurant(listClientRestaurant, ubigeoHibernate, imageHibernate));
				listRestaurant.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_SUCCESS_LIST_RESTAURANT_PENDING_ACTIVE);
				listRestaurant.setDescription("Restaurant in status pending active");
			}
			else{
				listRestaurant.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_EMPTY_LIST_RESTAURANT_PENDING_ACTIVE);
				listRestaurant.setDescription("No hay Restauranteros para dar de alta");
			}
			
		} catch (Exception e) {
			listRestaurant.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_ERROR);
			listRestaurant.setMessagesResponse(e.getMessage());
		}
		reqRespManager.saveOrUpdate(listRestaurant, 
				CommonConstants.TypeOperationReqResp.OPERATION_LIST_RESTAURANT_PENDING_ACTIVE,0,valueReqResp.getId());
		return listRestaurant;
	}
	
	public VerificationRestaurant getVerificationRestaurant(int idRestaurant){
		VerificationRestaurant beanVerification=new VerificationRestaurant();
		//--Save Json in Data Base
		RequestResponse valueReqResp=(RequestResponse)reqRespManager.saveOrUpdate(idRestaurant, 
				CommonConstants.TypeOperationReqResp.OPERATION_GET_VALUES_RESTAURANT,0,0);
		System.out.println("ID Response : "+valueReqResp.getId());
		try {
			//--Get Values from Id Restaurant
			CheckActiveRestaurant beanCheckActRest=checkActiveRestaurantHibernate.getCheckActiveRestaurant(idRestaurant);
			List<PlanMember> listPlanMember=planMemberHibernate.listAllPlanMember();
			beanVerification.setBeanCheckRestaurantActive(ConvertClass.convertFromDataBaseToCheckRestaurantActive(beanCheckActRest));
			beanVerification.setListPlanMenber(ConvertClass.convertFromDataBaseToBeanPlanMenber(listPlanMember));
			beanVerification.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_SUCCESS_VERIFICATION_CHECK_REST);
			beanVerification.setDescription("Success Return information");
			//-- List Plan member
		} catch (Exception e) {
			beanVerification.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_ERROR);
			beanVerification.setMessagesResponse(e.getMessage());
		}
		reqRespManager.saveOrUpdate(beanVerification, 
				CommonConstants.TypeOperationReqResp.OPERATION_GET_VALUES_RESTAURANT,0,valueReqResp.getId());
		return beanVerification;
	}

	public CheckRestaurantActive updateCheckRestaurant(CheckRestaurantActive beanRequest) {
		logger.info(CommonConstants.Logger.LOGGER_START);
		//--Save Json in Data Base
		RequestResponse valueReqResp=(RequestResponse)reqRespManager.saveOrUpdate("", 
				CommonConstants.TypeOperationReqResp.OPERATION_LIST_RESTAURANT_PENDING_ACTIVE,0,0);
		System.out.println("ID Response : "+valueReqResp.getId());
		int idUser=0;
		try {
			beanRequest.setStatus(1);
			CheckActiveRestaurant beanHibernate=ConvertClass.convertValuesCheckActiveRestaurantForUpdateDataBase(beanRequest);
			//--Update Check Restaurant
			checkActiveRestaurantHibernate.saveCheckActiveRestaurant(beanHibernate);
			if(beanRequest.isUpdateStatus()){
				//--Update Status Restaurant
				User userBean=restaurantHibernate.getUserByIdRestaurant(beanRequest.getIdRestaurant());
				idUser=userBean.getId();
				userBean.setStatus(4);
				//--Update status User
				userHibernate.saveUserResponseId(userBean);
			}else{
				idUser=restaurantHibernate.findUserByIdRestaurant(beanRequest.getIdRestaurant());	
			}
			beanRequest.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_SUCCESS_CHECK_REST);
			beanRequest.setDescription("Se actualizo correctamente");
			//--Find Id User
//			
			
		} catch (Exception e) {
			beanRequest.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_ERROR);
			beanRequest.setMessagesResponse(e.getMessage());
		}
		reqRespManager.saveOrUpdate(beanRequest, 
				CommonConstants.TypeOperationReqResp.OPERATION_SAVE_RESTAURANT,idUser,valueReqResp.getId());
		return beanRequest;
	}

}
