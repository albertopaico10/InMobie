package com.rest.web.service.inmobile.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.canonical.bean.image.ImageRequest;
import com.canonical.bean.image.ImageResponse;
import com.rest.web.service.inmobile.facade.ImageManager;
import com.rest.web.service.inmobile.facade.ReqRespManager;
import com.rest.web.service.inmobile.hibernate.ImageHibernate;
import com.rest.web.service.inmobile.hibernate.bean.Image;
import com.rest.web.service.inmobile.hibernate.bean.RequestResponse;
import com.rest.web.service.inmobile.util.CommonConstants;
import com.rest.web.service.inmobile.util.ConvertClass;
@Service
@Transactional
public class ImageManagerImpl implements ImageManager {
	@Autowired
	private ReqRespManager reqRespManager;
	
	@Autowired
	private ImageHibernate imageHibernate;
	
	public ImageResponse saveImage(ImageRequest beanRequest) {
		ImageResponse beanResponse=new ImageResponse();
		//--Save Json in Data Base
		RequestResponse valueReqResp=(RequestResponse)reqRespManager.saveOrUpdate(beanRequest, 
				CommonConstants.TypeOperationReqResp.OPERATION_UPLOAD_LOGO_RESTAURANT,beanRequest.getIdUser(),0);
		System.out.println("ID Response : "+valueReqResp.getId());
		try {
			Image image=ConvertClass.convertImageToDataBase(beanRequest);
			int idImage=imageHibernate.saveImageId(image);
			
			beanResponse.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_SUCCESS_IMAGE);
			beanResponse.setMessagesResponse("Se grabó la imagen con exito");
			beanResponse.setIdImage(idImage);
		} catch (Exception e) {
			beanResponse.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_ERROR);
			beanResponse.setMessagesResponse(e.getMessage());
		}
		reqRespManager.saveOrUpdate(beanResponse, 
				CommonConstants.TypeOperationReqResp.OPERATION_UPLOAD_LOGO_RESTAURANT,beanRequest.getIdUser(),valueReqResp.getId());
		return beanResponse;
	}

}
