package com.inmobile.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.inmobile.web.bean.RestaurantDTO;
import com.inmobile.web.bean.ReturnService;
import com.inmobile.web.facade.RestaurantManager;

@Controller
public class RestaurantController {
	@Autowired
	private RestaurantManager restaurantManager;
	
	@RequestMapping("registerRestaurant.htm")
	public ModelAndView validateUserForm(
            @RequestParam("fileLogo") MultipartFile file,
			@ModelAttribute RestaurantDTO restaurantBean,
			final BindingResult result, final SessionStatus status,
			final HttpServletRequest request,final ModelMap model) {
		System.out.println("Grabar informacion restaurant");
		System.out.println("ID User : "+restaurantBean.getIdUser()+"*** "+restaurantBean.getNameContact()
				+"*** "+restaurantBean.getEmailContact()+"**"+restaurantBean.getDepartment()+"**"
				+restaurantBean.getProvince()+"**"
				+restaurantBean.getDistrict());
		ReturnService beanReturn=restaurantManager.saveRestaurantInformation(restaurantBean,file);
		request.setAttribute("idUserReq", beanReturn.getIdUser());
		return new ModelAndView(beanReturn.getReturnPage());
	}
}
