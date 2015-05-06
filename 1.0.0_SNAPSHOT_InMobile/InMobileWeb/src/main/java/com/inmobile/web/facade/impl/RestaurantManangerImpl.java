package com.inmobile.web.facade.impl;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.inmobile.web.bean.RestaurantDTO;
import com.inmobile.web.bean.ReturnService;
import com.inmobile.web.bean.canonical.image.ImageRequest;
import com.inmobile.web.bean.canonical.image.ImageResponse;
import com.inmobile.web.bean.canonical.restaurant.RestaurantRequest;
import com.inmobile.web.bean.canonical.restaurant.RestaurantResponse;
import com.inmobile.web.facade.RestaurantManager;
import com.inmobile.web.util.CommonConstants;
import com.inmobile.web.util.ConvertClassFormat;
import com.inmobile.web.util.UtilMethods;

@Service
public class RestaurantManangerImpl implements RestaurantManager {

	public ReturnService saveRestaurantInformation(RestaurantDTO beanDTO,MultipartFile file) {
		ReturnService benResponseService=new ReturnService();
		RestTemplate restTemplate=new RestTemplate();
		if(!file.isEmpty()){
			//Save Image to DataBase
			ImageRequest beanRequest=ConvertClassFormat.convertWebToImageRequest(file,Integer.parseInt(beanDTO.getIdUser()));
			System.out.println("Requesst Image: "+UtilMethods.fromObjectToString(beanRequest));
			ImageResponse beanResponseImage=restTemplate.postForObject(CommonConstants.URLService.URL_SAVE_IMAGE,
					beanRequest, ImageResponse.class);
			System.out.println("Response Image : "+beanResponseImage);
			if(CommonConstants.Response.RESPONSE_SUCCESS_IMAGE.equals(beanResponseImage.getCodeResponse())){
				RestaurantRequest beanRestaurantRequest=ConvertClassFormat.convertWebToServiceRestaurant(beanDTO);
				beanRestaurantRequest.setIdImage(beanResponseImage.getIdImage());
				System.out.println("Valor Request : "+UtilMethods.fromObjectToString(beanRestaurantRequest));
				System.out.println("URL : "+CommonConstants.URLService.URL_SAVE_RESTAURANT);
				RestaurantResponse beanResponse=restTemplate.postForObject(CommonConstants.URLService.URL_SAVE_RESTAURANT, beanRestaurantRequest, RestaurantResponse.class);
				System.out.println("Valor Response : "+UtilMethods.fromObjectToString(beanResponse));
				if(CommonConstants.Response.RESPONSE_SUCCESS_RESTAURANT.equals(beanResponse.getCodeResponse())){
					benResponseService.setReturnPage(CommonConstants.Page.REDIRECT_SCHEDULER_PAGE);
					benResponseService.setIdUser(beanResponse.getIdUser());
				}
			}
		}else{
			benResponseService.setReturnPage(CommonConstants.Page.REDIRECT_ERROR);
		}		
		return benResponseService;
	}

}
