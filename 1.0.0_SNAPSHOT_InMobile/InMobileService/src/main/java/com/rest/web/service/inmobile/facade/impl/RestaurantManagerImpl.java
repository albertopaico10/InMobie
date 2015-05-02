package com.rest.web.service.inmobile.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.web.service.inmobile.bean.restaurant.RestaurantRequest;
import com.rest.web.service.inmobile.bean.restaurant.RestaurantResponse;
import com.rest.web.service.inmobile.facade.ReqRespManager;
import com.rest.web.service.inmobile.facade.RestaurantManage;
import com.rest.web.service.inmobile.hibernate.RestaurantHibernate;
import com.rest.web.service.inmobile.hibernate.bean.ClientRestaurant;
import com.rest.web.service.inmobile.hibernate.bean.RequestResponse;
import com.rest.web.service.inmobile.util.CommonConstants;
import com.rest.web.service.inmobile.util.ConvertClass;

@Service
@Transactional
public class RestaurantManagerImpl implements RestaurantManage {
	
	@Autowired
	private ReqRespManager reqRespManager;
	
	@Autowired
	private RestaurantHibernate restaurantHibernate;
	
	public RestaurantResponse saveRestaurant(RestaurantRequest beanRequest) {
		
		RestaurantResponse restaurantResponseBean=new RestaurantResponse();
		
		//--Save Json in Data Base
		RequestResponse valueReqResp=(RequestResponse)reqRespManager.saveOrUpdate(beanRequest, 
				CommonConstants.TypeOperationReqResp.OPERATION_SAVE_RESTAURANT,beanRequest.getIdUser(),0);
		System.out.println("ID Response : "+valueReqResp.getId());
		
		try {
			//--Upload Image to Data Base
			System.out.println("Listo para grabar la info");
			
			//--Convert canonical request to object database
			ClientRestaurant clientResturant=ConvertClass.convertRestaurantRequestToDataBase(beanRequest);
			
			restaurantHibernate.saveRestaurant(clientResturant);
			
			//--Update status user to 3
			
			
		} catch (Exception e) {
			restaurantResponseBean.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_ERROR);
			restaurantResponseBean.setMessagesResponse(e.getMessage());
		}
		reqRespManager.saveOrUpdate(restaurantResponseBean, 
				CommonConstants.TypeOperationReqResp.OPERATION_SAVE_RESTAURANT,beanRequest.getIdUser(),valueReqResp.getId());
		return null;
	}

}
