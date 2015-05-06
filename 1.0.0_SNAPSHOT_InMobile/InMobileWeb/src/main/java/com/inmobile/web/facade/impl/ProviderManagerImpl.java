package com.inmobile.web.facade.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.inmobile.web.bean.ProviderDTO;
import com.inmobile.web.bean.ReturnService;
import com.inmobile.web.bean.canonical.image.ImageRequest;
import com.inmobile.web.bean.canonical.image.ImageResponse;
import com.inmobile.web.bean.canonical.restaurant.ProviderRequest;
import com.inmobile.web.bean.canonical.restaurant.ProviderResponse;
import com.inmobile.web.facade.ProviderManager;
import com.inmobile.web.util.CommonConstants;
import com.inmobile.web.util.ConvertClassFormat;
import com.inmobile.web.util.UtilMethods;

@Service
public class ProviderManagerImpl implements ProviderManager{

	public ReturnService saveProviderInformation(ProviderDTO beanDTO,MultipartFile file) {
		ReturnService benResponse = new ReturnService();
		RestTemplate restTemplate = new RestTemplate();
		if(!file.isEmpty()){
			//--Save Image
			ImageRequest beanRequestImage=ConvertClassFormat.convertWebToImageRequest(file,Integer.parseInt(beanDTO.getIdUser()));
			beanRequestImage.setCategoryImage(CommonConstants.WebId.IMAGE_SAVE_PROVIDER);
			System.out.println("Requesst Image: "+UtilMethods.fromObjectToString(beanRequestImage));
			ImageResponse beanResponseImage=restTemplate.postForObject(CommonConstants.URLService.URL_SAVE_IMAGE,
					beanRequestImage, ImageResponse.class);
			System.out.println("Response Image : "+UtilMethods.fromObjectToString(beanResponseImage));
			if(CommonConstants.Response.RESPONSE_SUCCESS_IMAGE.equals(beanResponseImage.getCodeResponse())){
				//--Save Provider Information
				ProviderRequest beanRequest = ConvertClassFormat.convertWebToServiceProvider(beanDTO);
				beanRequest.setIdImage(beanResponseImage.getIdImage());
				System.out.println("Valor Request : "+UtilMethods.fromObjectToString(beanRequest));
				System.out.println("URL : "+CommonConstants.URLService.URL_SAVE_PROVIDER);
				ProviderResponse beanResponse = restTemplate.postForObject(CommonConstants.URLService.URL_SAVE_PROVIDER, beanRequest, ProviderResponse.class);
				System.out.println("Valor Response : "+UtilMethods.fromObjectToString(beanResponse));
				if(CommonConstants.Response.RESPONSE_SUCCESS_PROVIDER.equals(beanResponse.getCodeResponse())){
					benResponse.setReturnPage(CommonConstants.Page.REDIRECT_DISTRICT_PROVIDER);
					benResponse.setIdUser(beanResponse.getIdUser());
				}
			}
		}else{
			benResponse.setReturnPage(CommonConstants.Page.REDIRECT_ERROR);
		}
				
		return benResponse;
	}

}
