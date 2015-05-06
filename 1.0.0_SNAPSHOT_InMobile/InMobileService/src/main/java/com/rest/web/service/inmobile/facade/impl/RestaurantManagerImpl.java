package com.rest.web.service.inmobile.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.web.service.inmobile.bean.restaurant.RestaurantRequest;
import com.rest.web.service.inmobile.bean.restaurant.RestaurantResponse;
import com.rest.web.service.inmobile.facade.ReqRespManager;
import com.rest.web.service.inmobile.facade.RestaurantManage;
import com.rest.web.service.inmobile.hibernate.RestaurantHibernate;
import com.rest.web.service.inmobile.hibernate.UserHibernate;
import com.rest.web.service.inmobile.hibernate.bean.ClientRestaurant;
import com.rest.web.service.inmobile.hibernate.bean.RequestResponse;
import com.rest.web.service.inmobile.hibernate.bean.User;
import com.rest.web.service.inmobile.util.CommonConstants;
import com.rest.web.service.inmobile.util.ConvertClass;

@Service
@Transactional
public class RestaurantManagerImpl implements RestaurantManage {
	
	@Autowired
	private ReqRespManager reqRespManager;
	
	@Autowired
	private UserHibernate userHibernate;
	@Autowired
	private RestaurantHibernate restaurantHibernate;
	
	public RestaurantResponse saveRestaurant(RestaurantRequest beanRequest) {
		
		RestaurantResponse restaurantResponseBean=new RestaurantResponse();
		
		//--Save Json in Data Base
		RequestResponse valueReqResp=(RequestResponse)reqRespManager.saveOrUpdate(beanRequest, 
				CommonConstants.TypeOperationReqResp.OPERATION_SAVE_RESTAURANT,beanRequest.getIdUser(),0);
		System.out.println("ID Response : "+valueReqResp.getId());
		
		try {
			//--Convert canonical request to object database
			ClientRestaurant clientResturant=ConvertClass.convertRestaurantRequestToDataBase(beanRequest);
			
			restaurantHibernate.saveRestaurant(clientResturant);
			
			//--Update status user to 3
			User beanUser=userHibernate.findUSerBeanActiveAccount(String.valueOf(beanRequest.getIdUser()));
			beanUser.setStatus(3);
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

}
