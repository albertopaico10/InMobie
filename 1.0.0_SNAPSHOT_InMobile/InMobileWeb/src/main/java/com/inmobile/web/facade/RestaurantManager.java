package com.inmobile.web.facade;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.inmobile.web.bean.RestaurantDTO;
import com.inmobile.web.bean.ReturnService;

@Service
public interface RestaurantManager {

	public ReturnService saveRestaurantInformation(RestaurantDTO beanDTO,MultipartFile file);
	
}
