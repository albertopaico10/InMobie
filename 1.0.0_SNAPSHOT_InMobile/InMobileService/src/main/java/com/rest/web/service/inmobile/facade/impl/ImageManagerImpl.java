package com.rest.web.service.inmobile.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.web.service.inmobile.bean.image.ImageRequest;
import com.rest.web.service.inmobile.bean.image.ImageResponse;
import com.rest.web.service.inmobile.facade.ImageManager;
import com.rest.web.service.inmobile.hibernate.ImageHibernate;
import com.rest.web.service.inmobile.hibernate.bean.Image;
import com.rest.web.service.inmobile.util.CommonConstants;
import com.rest.web.service.inmobile.util.ConvertClass;
@Service
@Transactional
public class ImageManagerImpl implements ImageManager {

	@Autowired
	private ImageHibernate imageHibernate;
	
	public ImageResponse saveImage(ImageRequest beanRequest) {
		ImageResponse beanResponse=new ImageResponse();
		
		try {
			Image image=ConvertClass.convertImageToDataBase(beanRequest);
			int idImage=imageHibernate.saveImageId(image);
			
			beanResponse.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_SUCCESS_IMAGE);
			beanResponse.setMessageResponse("Se grabó la imagen con exito");
			beanResponse.setIdImage(idImage);
		} catch (Exception e) {
			beanResponse.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_ERROR);
			beanResponse.setMessageResponse(e.getMessage());
		}
		return beanResponse;
	}

}
