package com.rest.web.service.inmobile.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.canonical.bean.presentation.ListPresentationResponse;
import com.canonical.bean.presentation.PresentationResponse;
import com.rest.web.service.inmobile.facade.PresentationManager;
import com.rest.web.service.inmobile.hibernate.PresentationHibernate;
import com.rest.web.service.inmobile.hibernate.bean.Presentation;
import com.rest.web.service.inmobile.util.CommonConstants;
import com.rest.web.service.inmobile.util.ConvertClass;
@Service
@Transactional
public class PresentationManagerImpl implements PresentationManager{
	private static final Logger logger = LoggerFactory.getLogger(PresentationManagerImpl.class);
	
	@Autowired
	private PresentationHibernate presentationHibernate;
	
	public ListPresentationResponse listAllPresentation() {
		logger.info(CommonConstants.Logger.LOGGER_START);
		ListPresentationResponse listPresentationResponse=new ListPresentationResponse();
		try {
			List<Presentation> listPresentation=presentationHibernate.listAllPresentation();
			List<PresentationResponse> listConvPresentationResponse=ConvertClass.convertListPresentationToListPresentationResponse(listPresentation);
			
			if(listConvPresentationResponse.size()>0){
				listPresentationResponse.setListPresentation(listConvPresentationResponse);
				listPresentationResponse.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_SUCCESS_LIST_PRESENTATION);
			}else{
				logger.info("The list is Empty");
				listPresentationResponse.setMessagesResponse("The list is Empty");
				listPresentationResponse.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_EMPTY_LIST_PRESENTATION);
			}
		} catch (Exception e) {
			listPresentationResponse.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_ERROR);
			logger.error("Error : "+e.getMessage());
		}
		logger.info(CommonConstants.Logger.LOGGER_END);
		return listPresentationResponse;
	}

	
	
}
