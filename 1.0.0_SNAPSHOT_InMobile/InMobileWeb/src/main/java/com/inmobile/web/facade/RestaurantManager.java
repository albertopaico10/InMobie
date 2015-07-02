package com.inmobile.web.facade;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.inmobile.web.bean.RestaurantDTO;
import com.inmobile.web.bean.ReturnService;
import com.inmobile.web.bean.canonical.restaurant.VerificationRestaurant;

@Service
public interface RestaurantManager {

	public ReturnService saveRestaurantInformation(RestaurantDTO beanDTO,MultipartFile file);
	public ReturnService saveRestaurantSchedulerInformation(int idRestaurant,String dayAndHours);
	public List<VerificationRestaurant> getCheckRestaurantInformation(String idRestaurant);
}
