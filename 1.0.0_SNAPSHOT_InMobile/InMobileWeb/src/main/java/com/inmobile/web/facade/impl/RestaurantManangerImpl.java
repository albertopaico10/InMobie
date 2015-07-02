package com.inmobile.web.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.inmobile.web.bean.SchedulerRestaurantBean;
import com.inmobile.web.bean.canonical.image.ImageRequest;
import com.inmobile.web.bean.canonical.image.ImageResponse;
import com.inmobile.web.bean.canonical.restaurant.RestaurantRequest;
import com.inmobile.web.bean.canonical.restaurant.RestaurantResponse;
import com.inmobile.web.bean.canonical.restaurant.SchedulerRestaurantRequest;
import com.inmobile.web.bean.canonical.restaurant.SchedulerRestaurantResponse;
import com.inmobile.web.bean.canonical.restaurant.VerificationRestaurant;
import com.inmobile.web.controller.LoginController;
import com.inmobile.web.facade.RestaurantManager;
import com.inmobile.web.util.CommonConstants;
import com.inmobile.web.util.ConvertClassFormat;
import com.inmobile.web.util.UtilMethods;

@Service
public class RestaurantManangerImpl implements RestaurantManager {
	private static final Logger logger = LoggerFactory.getLogger(RestaurantManangerImpl.class);
	
	public ReturnService saveRestaurantInformation(RestaurantDTO beanDTO,MultipartFile file) {
		logger.info(CommonConstants.Logger.LOGGER_START);
		ReturnService benResponseService=new ReturnService();
		RestTemplate restTemplate=new RestTemplate();
		logger.info("Nombre del archivo : "+beanDTO.getFileName()+"**"+beanDTO.getIdImage());
		RestaurantRequest beanRestaurantRequest=ConvertClassFormat.convertWebToServiceRestaurant(beanDTO);
		if(!file.isEmpty()){
			//Save Image to DataBase
			ImageRequest beanRequest=ConvertClassFormat.convertWebToImageRequest(file,Integer.parseInt(beanDTO.getIdUser()));
			beanRequest.setCategoryImage(CommonConstants.WebId.IMAGE_SAVE_RESTAURANT);
			ImageResponse beanResponseImage=restTemplate.postForObject(CommonConstants.URLService.URL_SAVE_IMAGE,
					beanRequest, ImageResponse.class);
			logger.info("Response Image : "+UtilMethods.fromObjectToString(beanResponseImage));
			if(CommonConstants.Response.RESPONSE_SUCCESS_IMAGE.equals(beanResponseImage.getCodeResponse())){
				beanRestaurantRequest.setIdImage(beanResponseImage.getIdImage());
			}
		}else{
			beanRestaurantRequest.setIdImage(beanDTO.getIdImage());
		}
		logger.info("Valor Request : "+UtilMethods.fromObjectToString(beanRestaurantRequest));
		logger.info("URL : "+CommonConstants.URLService.URL_SAVE_RESTAURANT);
		//--Save Restaurant Information
		RestaurantResponse beanResponse=restTemplate.postForObject(CommonConstants.URLService.URL_SAVE_RESTAURANT, beanRestaurantRequest, RestaurantResponse.class);
		logger.info("Valor Response : "+UtilMethods.fromObjectToString(beanResponse));
		if(CommonConstants.Response.RESPONSE_SUCCESS_RESTAURANT.equals(beanResponse.getCodeResponse())){
			benResponseService.setReturnPage(CommonConstants.Page.REDIRECT_SCHEDULER_PAGE);
			benResponseService.setIdUser(beanResponse.getIdUser());
			//--Call service for get Scheduler for that customer
			
			//--Build Scheduler
			benResponseService.setNameDay(gettDaysWeekObj());
			benResponseService.setNumberHours(getNumberHoursObj());
		}
		logger.info(CommonConstants.Logger.LOGGER_END);
		return benResponseService;
	}
	
	public ReturnService saveRestaurantSchedulerInformation(int idUser,String dayAndHours) {
		ReturnService beanReturnService=new ReturnService();
		RestTemplate restTemplate=new RestTemplate();
		SchedulerRestaurantRequest beanSchedulerRequest=ConvertClassFormat.convertFromWebToServiceScheduler(idUser, dayAndHours);
		logger.info("REQUEST : "+UtilMethods.fromObjectToString(beanSchedulerRequest));
		logger.info("URL - Scheduler : ");
		SchedulerRestaurantResponse beanSchedulerResponse=restTemplate.postForObject(CommonConstants.URLService.URL_SAVE_RESTAURANT_SCHEDULER, beanSchedulerRequest, SchedulerRestaurantResponse.class);
		if(CommonConstants.Response.RESPONSE_SUCCESS_SCHEDULER.equals(beanSchedulerResponse.getCodeResponse())){
			beanReturnService.setReturnPage(CommonConstants.Page.REDIRECT_MESSAGE_SUCCESS_VALIDATION);
		}else{
			beanReturnService.setReturnPage(CommonConstants.Page.REDIRECT_ERROR);
		}
		return beanReturnService;
	}
	
	public List<VerificationRestaurant> getCheckRestaurantInformation(String idRestaurant){
		logger.info(CommonConstants.Logger.LOGGER_START);
		List<VerificationRestaurant> listVerifRest=new ArrayList<VerificationRestaurant>();
		RestTemplate restTemplate=new RestTemplate();
		logger.info("URL : "+CommonConstants.URLService.URL_GET_RESTAURANT_CHECK+idRestaurant);
		VerificationRestaurant beanResponse=restTemplate.getForObject(CommonConstants.URLService.URL_GET_RESTAURANT_CHECK+idRestaurant, VerificationRestaurant.class);
		listVerifRest.add(beanResponse);
		logger.info(CommonConstants.Logger.LOGGER_END);
		return listVerifRest;
	}
	
	
	public List<String> gettDaysWeek(){
		List<String> listDay=new ArrayList<String>();
		for(int i=0;i<=7;i++){
			listDay.add(String.valueOf(i));
		}
		return listDay;
	}
	
	public List<SchedulerRestaurantBean> gettDaysWeekObj(){
		List<SchedulerRestaurantBean> listDay=new ArrayList<SchedulerRestaurantBean>();
		for(int i=0;i<=7;i++){
			SchedulerRestaurantBean beanScheduler=new SchedulerRestaurantBean();
			beanScheduler.setIdValue(String.valueOf(i));
			beanScheduler.setValue(String.valueOf(i));
			beanScheduler.setCheck(false);
			listDay.add(beanScheduler);
		}
		return listDay;
	}
	
	public List<String> getNumberHours(){
		List<String> listDay=new ArrayList<String>();
		listDay.add("/");
		listDay.add("00:00");
		listDay.add("01:00");
		listDay.add("02:00");
		listDay.add("03:00");
		listDay.add("04:00");
		listDay.add("05:00");
		listDay.add("06:00");
		listDay.add("07:00");
		listDay.add("08:00");
		listDay.add("09:00");
		listDay.add("10:00");
		listDay.add("11:00");
		listDay.add("12:00");
		listDay.add("13:00");
		listDay.add("14:00");
		listDay.add("15:00");
		listDay.add("16:00");
		listDay.add("17:00");
		listDay.add("18:00");
		listDay.add("19:00");
		listDay.add("20:00");
		listDay.add("21:00");
		listDay.add("22:00");
		listDay.add("23:00");
		return listDay;
	}

	public List<SchedulerRestaurantBean> getNumberHoursObj(){
		List<SchedulerRestaurantBean> listDay=new ArrayList<SchedulerRestaurantBean>();
		
		SchedulerRestaurantBean beanScheduler1=new SchedulerRestaurantBean();
		beanScheduler1.setIdValue("1");
		beanScheduler1.setValue("/");
		beanScheduler1.setCheck(false);
		listDay.add(beanScheduler1);
		
		SchedulerRestaurantBean beanScheduler2=new SchedulerRestaurantBean();
		beanScheduler2.setIdValue("2");
		beanScheduler2.setValue("00:00");
		beanScheduler2.setCheck(false);
		listDay.add(beanScheduler2);
		
		SchedulerRestaurantBean beanScheduler3=new SchedulerRestaurantBean();
		beanScheduler3.setIdValue("3");
		beanScheduler3.setValue("01:00");
		beanScheduler3.setCheck(false);
		listDay.add(beanScheduler3);

		SchedulerRestaurantBean beanScheduler4=new SchedulerRestaurantBean();
		beanScheduler4.setIdValue("4");
		beanScheduler4.setValue("02:00");
		beanScheduler4.setCheck(false);
		listDay.add(beanScheduler4);
		
		SchedulerRestaurantBean beanScheduler5=new SchedulerRestaurantBean();
		beanScheduler5.setIdValue("5");
		beanScheduler5.setValue("03:00");
		beanScheduler5.setCheck(false);
		listDay.add(beanScheduler5);
		
		SchedulerRestaurantBean beanScheduler6=new SchedulerRestaurantBean();
		beanScheduler6.setIdValue("6");
		beanScheduler6.setValue("04:00");
		beanScheduler6.setCheck(false);
		listDay.add(beanScheduler6);
		
		SchedulerRestaurantBean beanScheduler7=new SchedulerRestaurantBean();
		beanScheduler7.setIdValue("7");
		beanScheduler7.setValue("05:00");
		beanScheduler7.setCheck(false);
		listDay.add(beanScheduler7);
		
		SchedulerRestaurantBean beanScheduler8=new SchedulerRestaurantBean();
		beanScheduler8.setIdValue("8");
		beanScheduler8.setValue("06:00");
		beanScheduler8.setCheck(false);
		listDay.add(beanScheduler8);
		
		SchedulerRestaurantBean beanScheduler9=new SchedulerRestaurantBean();
		beanScheduler9.setIdValue("9");
		beanScheduler9.setValue("07:00");
		beanScheduler9.setCheck(false);
		listDay.add(beanScheduler9);
		
		SchedulerRestaurantBean beanScheduler10=new SchedulerRestaurantBean();
		beanScheduler10.setIdValue("10");
		beanScheduler10.setValue("08:00");
		beanScheduler10.setCheck(false);
		listDay.add(beanScheduler10);
		
		SchedulerRestaurantBean beanScheduler11=new SchedulerRestaurantBean();
		beanScheduler11.setIdValue("11");
		beanScheduler11.setValue("09:00");
		beanScheduler11.setCheck(false);
		listDay.add(beanScheduler11);
		
		SchedulerRestaurantBean beanScheduler12=new SchedulerRestaurantBean();
		beanScheduler12.setIdValue("12");
		beanScheduler12.setValue("10:00");
		beanScheduler12.setCheck(false);
		listDay.add(beanScheduler12);
		
		SchedulerRestaurantBean beanScheduler13=new SchedulerRestaurantBean();
		beanScheduler13.setIdValue("13");
		beanScheduler13.setValue("11:00");
		beanScheduler13.setCheck(false);
		listDay.add(beanScheduler13);
		
		SchedulerRestaurantBean beanScheduler14=new SchedulerRestaurantBean();
		beanScheduler14.setIdValue("14");
		beanScheduler14.setValue("12:00");
		beanScheduler14.setCheck(false);
		listDay.add(beanScheduler14);
		
		SchedulerRestaurantBean beanScheduler15=new SchedulerRestaurantBean();
		beanScheduler15.setIdValue("15");
		beanScheduler15.setValue("13:00");
		beanScheduler15.setCheck(false);
		listDay.add(beanScheduler15);
		
		SchedulerRestaurantBean beanScheduler16=new SchedulerRestaurantBean();
		beanScheduler16.setIdValue("16");
		beanScheduler16.setValue("14:00");
		beanScheduler16.setCheck(false);
		listDay.add(beanScheduler16);
		
		SchedulerRestaurantBean beanScheduler17=new SchedulerRestaurantBean();
		beanScheduler17.setIdValue("17");
		beanScheduler17.setValue("15:00");
		beanScheduler17.setCheck(false);
		listDay.add(beanScheduler17);
		
		SchedulerRestaurantBean beanScheduler18=new SchedulerRestaurantBean();
		beanScheduler18.setIdValue("18");
		beanScheduler18.setValue("16:00");
		beanScheduler18.setCheck(false);
		listDay.add(beanScheduler18);
		
		SchedulerRestaurantBean beanScheduler19=new SchedulerRestaurantBean();
		beanScheduler19.setIdValue("19");
		beanScheduler19.setValue("17:00");
		beanScheduler19.setCheck(false);
		listDay.add(beanScheduler19);
		
		SchedulerRestaurantBean beanScheduler20=new SchedulerRestaurantBean();
		beanScheduler20.setIdValue("20");
		beanScheduler20.setValue("18:00");
		beanScheduler20.setCheck(false);
		listDay.add(beanScheduler20);
		
		SchedulerRestaurantBean beanScheduler21=new SchedulerRestaurantBean();
		beanScheduler21.setIdValue("21");
		beanScheduler21.setValue("19:00");
		beanScheduler21.setCheck(false);
		listDay.add(beanScheduler21);
		
		SchedulerRestaurantBean beanScheduler22=new SchedulerRestaurantBean();
		beanScheduler22.setIdValue("22");
		beanScheduler22.setValue("20:00");
		beanScheduler22.setCheck(false);
		listDay.add(beanScheduler22);
				
		SchedulerRestaurantBean beanScheduler23=new SchedulerRestaurantBean();
		beanScheduler23.setIdValue("23");
		beanScheduler23.setValue("21:00");
		beanScheduler23.setCheck(false);
		listDay.add(beanScheduler23);
				
		SchedulerRestaurantBean beanScheduler24=new SchedulerRestaurantBean();
		beanScheduler24.setIdValue("24");
		beanScheduler24.setValue("22:00");
		beanScheduler24.setCheck(false);
		listDay.add(beanScheduler24);
		
		SchedulerRestaurantBean beanScheduler25=new SchedulerRestaurantBean();
		beanScheduler25.setIdValue("1");
		beanScheduler25.setValue("23:00");
		beanScheduler25.setCheck(false);
		listDay.add(beanScheduler25);
		
		return listDay;
	}
	
}
