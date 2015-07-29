package com.rest.web.service.inmobile.facade.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.canonical.bean.provider.DistrictProviderRequest;
import com.canonical.bean.provider.DistrictProviderResponse;
import com.canonical.bean.provider.ListProvider;
import com.canonical.bean.provider.ProviderRequest;
import com.canonical.bean.provider.ProviderResponse;
import com.rest.web.service.inmobile.facade.ProviderManager;
import com.rest.web.service.inmobile.facade.ReqRespManager;
import com.rest.web.service.inmobile.hibernate.ImageHibernate;
import com.rest.web.service.inmobile.hibernate.ProviderHibernate;
import com.rest.web.service.inmobile.hibernate.UbigeoHibernate;
import com.rest.web.service.inmobile.hibernate.UserHibernate;
import com.rest.web.service.inmobile.hibernate.bean.DistrictProvider;
import com.rest.web.service.inmobile.hibernate.bean.Provider;
import com.rest.web.service.inmobile.hibernate.bean.RequestResponse;
import com.rest.web.service.inmobile.hibernate.bean.User;
import com.rest.web.service.inmobile.util.CommonConstants;
import com.rest.web.service.inmobile.util.ConvertClass;

@Service
@Transactional
public class ProviderManagerImpl implements ProviderManager {
	private static final Logger logger = LoggerFactory.getLogger(ProviderManagerImpl.class);
	@Autowired
	private ReqRespManager objReqRespManager;
	
	@Autowired
	private ProviderHibernate objProviderHibernate;
	@Autowired
	private UserHibernate userHibernate;
	@Autowired
	private ImageHibernate imageHibernate;
	@Autowired
	private UbigeoHibernate ubigeoHibernate;
	
	public ProviderResponse saveProvider(ProviderRequest objProviderRequest) {
		
		ProviderResponse objProviderResponse = new ProviderResponse();
		
		//--Save Json in Data Base
		RequestResponse valueReqResp = (RequestResponse)objReqRespManager.saveOrUpdate(objProviderRequest, 
				CommonConstants.TypeOperationReqResp.OPERATION_SAVE_PROVIDER,objProviderRequest.getIdUser(),0);
		System.out.println("ID Response : "+valueReqResp.getId());
		
		try {
			//--Upload Image to Data Base
			System.out.println("Listo para grabar la info");
			
			//--Convert canonical request to object database
			Provider objProvider = ConvertClass.convertProviderRequestToDataBase(objProviderRequest);
			objProvider.setStatus(1);
			objProviderHibernate.saveProvider(objProvider);
			System.out.println("REGISTRO DE PROVEEDOR: "+objProvider.getId());
			//--Update status user to 3
			User beanUser=userHibernate.findUSerBeanActiveAccount(String.valueOf(objProviderRequest.getIdUser()));
//			beanUser.setStatus(3);
			//--Update status User
			userHibernate.saveUserResponseId(beanUser);
			objProviderResponse.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_SUCCESS_PROVIDE);
			objProviderResponse.setMessagesResponse("The user create one part of his registration");
			objProviderResponse.setIdUser(objProvider.getId());
			
		} catch (Exception e) {
			objProviderResponse.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_ERROR);
			objProviderResponse.setMessagesResponse(e.getMessage());
			objProviderResponse.setIdUser(objProviderRequest.getIdUser());
		}
		objReqRespManager.saveOrUpdate(objProviderResponse, 
				CommonConstants.TypeOperationReqResp.OPERATION_SAVE_PROVIDER, objProviderRequest.getIdUser(), valueReqResp.getId());
		return objProviderResponse;
	}

	public DistrictProviderResponse saveDistrictProvider(DistrictProviderRequest objDistrictProviderRequest) {
		
		DistrictProviderResponse objDistrictProviderResponse = new DistrictProviderResponse();
		
		//--Save Json in Data Base
		RequestResponse valueReqResp = (RequestResponse)objReqRespManager.saveOrUpdate(objDistrictProviderRequest, 
				CommonConstants.TypeOperationReqResp.OPERATION_SAVE_DISTRICT_PROVIDER,0,0);
		System.out.println("ID Response : "+valueReqResp.getId());
		
		try {
			DistrictProvider objDistrictProvider = ConvertClass.convertDistrictProviderRequestToDataBase(objDistrictProviderRequest);
			
			objProviderHibernate.saveDistrictProvider(objDistrictProvider);
			
			objDistrictProviderResponse.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_SUCCESS_DISTRICT_PROVIDER);
			objDistrictProviderResponse.setMessagesResponse("The district provider registered");
			//objDistrictProviderResponse.setIdUser(objProviderRequest.getIdUser());
			
		} catch (Exception e) {
			objDistrictProviderResponse.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_ERROR);
			objDistrictProviderResponse.setMessagesResponse(e.getMessage());
		}
		objReqRespManager.saveOrUpdate(objDistrictProviderResponse, 
				CommonConstants.TypeOperationReqResp.OPERATION_SAVE_PROVIDER, 0, valueReqResp.getId());
		// TODO Auto-generated method stub
		return objDistrictProviderResponse;
	}

	public ListProvider listProviderPendingActive() {
		logger.info(CommonConstants.Logger.LOGGER_START);
		ListProvider listProvider=new ListProvider();
		//--Save Json in Data Base
		RequestResponse valueReqResp=(RequestResponse)objReqRespManager.saveOrUpdate("", 
					CommonConstants.TypeOperationReqResp.OPERATION_LIST_RESTAURANT_PENDING_ACTIVE,0,0);
		System.out.println("ID Response : "+valueReqResp.getId());
		try {
			List<Provider> listProviderPending=objProviderHibernate.listRestaurantPendingActive();
			logger.info("Cantidad de filas Proveedores pendientes activar : "+listProviderPending.size());
			if(listProviderPending.size()>0){
				listProvider.setListProviderResponse(ConvertClass.convertFromDataBaseToListProvider(listProviderPending, ubigeoHibernate, imageHibernate));
				listProvider.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_SUCCESS_LIST_PROVIDER_PENDING_ACTIVE);
				listProvider.setDescription("Restaurant in status pending active");
			}
			else{
				listProvider.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_EMPTY_LIST_PROVIDER_PENDING_ACTIVE);
				listProvider.setDescription("No hay Restauranteros para dar de alta");
			}
		} catch (Exception e) {
			listProvider.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_ERROR);
			listProvider.setMessagesResponse(e.getMessage());
		}
		objReqRespManager.saveOrUpdate(listProvider, 
				CommonConstants.TypeOperationReqResp.OPERATION_LIST_PROVIDER_PENDING_ACTIVE,0,valueReqResp.getId());
		return listProvider;
	}

}
