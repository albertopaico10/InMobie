package com.inmobile.web.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.canonical.bean.image.ImageRequest;
import com.canonical.bean.image.ImageResponse;
import com.canonical.bean.provider.DistrictProviderRequest;
import com.canonical.bean.provider.DistrictProviderResponse;
import com.canonical.bean.provider.ProviderRequest;
import com.canonical.bean.provider.ProviderResponse;
import com.inmobile.web.bean.DistrictProviderDTO;
import com.inmobile.web.bean.ProviderDTO;
import com.inmobile.web.bean.ReturnService;
import com.inmobile.web.facade.ProviderManager;
import com.inmobile.web.util.CommonConstants;
import com.inmobile.web.util.ConvertClassFormat;
import com.inmobile.web.util.UtilMethods;

@Service
public class ProviderManagerImpl implements ProviderManager{
	private static final Logger logger = LoggerFactory.getLogger(ProviderManagerImpl.class);

	public ReturnService saveProviderInformation(ProviderDTO beanDTO,MultipartFile file) {
		ReturnService benResponse = new ReturnService();
		RestTemplate restTemplate = new RestTemplate();
		ProviderRequest beanRequest = ConvertClassFormat.convertWebToServiceProvider(beanDTO);
		if(!file.isEmpty()){
			//--Save Image
			ImageRequest beanRequestImage=ConvertClassFormat.convertWebToImageRequest(file,Integer.parseInt(beanDTO.getIdUser()));
			beanRequestImage.setCategoryImage(CommonConstants.WebId.IMAGE_SAVE_PROVIDER);
			ImageResponse beanResponseImage=restTemplate.postForObject(CommonConstants.URLService.URL_SAVE_IMAGE,
					beanRequestImage, ImageResponse.class);
			logger.info("Response Image : "+UtilMethods.fromObjectToString(beanResponseImage));
			if(CommonConstants.Response.RESPONSE_SUCCESS_IMAGE.equals(beanResponseImage.getCodeResponse())){
				beanRequest.setIdImage(beanResponseImage.getIdImage());
			}
		}else{
			beanRequest.setIdImage(beanDTO.getIdImage());
		}
		logger.info("Valor Request : "+UtilMethods.fromObjectToString(beanRequest));
		logger.info("URL : "+CommonConstants.URLService.URL_SAVE_PROVIDER);
		ProviderResponse beanResponse = restTemplate.postForObject(CommonConstants.URLService.URL_SAVE_PROVIDER, beanRequest, ProviderResponse.class);
		System.out.println("Valor Response : "+UtilMethods.fromObjectToString(beanResponse));
		if(CommonConstants.Response.RESPONSE_SUCCESS_PROVIDER.equals(beanResponse.getCodeResponse())){
			benResponse.setReturnPage(CommonConstants.Page.REDIRECT_DISTRICT_PROVIDER);
			benResponse.setIdUser(beanResponse.getIdUser());
		}
				
		return benResponse;
	}

	public ReturnService saveProviderByDistrict(DistrictProviderDTO disProviderDTO) {
		ReturnService benResponse = new ReturnService();
		RestTemplate restTemplate = new RestTemplate();
		String[] districts = disProviderDTO.getIdDistrict().split("-");
		
		List<Integer> listDistrictProvider=new ArrayList<Integer>();
		for(String idDistrict : districts){
			listDistrictProvider.add(Integer.parseInt(idDistrict));
		}
		
		DistrictProviderRequest objDistrictProviderRequest=new DistrictProviderRequest();
		objDistrictProviderRequest.setIdProvider(disProviderDTO.getIdProvider());
		objDistrictProviderRequest.setListIdDistrict(listDistrictProvider);
		logger.info("REQUEST : "+UtilMethods.fromObjectToString(objDistrictProviderRequest));
		DistrictProviderResponse objDistrictProviderResponse = restTemplate.postForObject(CommonConstants.URLService.URL_ADD_DISTRICT_PROVIDER, objDistrictProviderRequest, DistrictProviderResponse.class);
		if(CommonConstants.Response.RESPONSE_SUCCESS_DISTRICT_PROVIDER.equals(objDistrictProviderResponse.getCodeResponse())){
			benResponse.setReturnPage(CommonConstants.Page.REDIRECT_INACTIVE_ACCOUNT_PAGE);
		}else{
			benResponse.setReturnPage(CommonConstants.Page.REDIRECT_ERROR);
		}
		return benResponse;
	}

}
