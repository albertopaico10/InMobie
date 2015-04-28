package com.inmobile.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.inmobie.web.bean.RegisterUserDTO;
import com.inmobie.web.bean.ReturnService;
import com.inmobile.web.facade.UserManager;
import com.inmobile.web.util.CommonConstants;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private UserManager userManager;	
	
	@RequestMapping("validateUser.htm")
	public ModelAndView validateUserForm(
			@ModelAttribute RegisterUserDTO logueoBean,
			final BindingResult result, final SessionStatus status,
			final HttpServletRequest request,final ModelMap model) {
		logger.info(CommonConstants.Logger.LOGGER_START);
		String response=CommonConstants.Page.REDIRECT_INIT_PAGE;
		System.out.println("Valores : "+logueoBean.getPassword()+"**** "+logueoBean.getUser()+"***"+logueoBean.getTypeUser()+"¨***"+logueoBean.getTypeOperation());
		ReturnService returnServiceBean=null;
		if(CommonConstants.WebId.LOGIN_REGISTER_USER.equals(logueoBean.getTypeOperation())){
			System.out.println("Es register");
			returnServiceBean=userManager.registerUserInMobile(logueoBean);
		}else{
			System.out.println("Is Login");
			returnServiceBean=userManager.validateUser(logueoBean);
		}
		model.addAttribute("loginUsuForm", logueoBean);
		request.setAttribute("messages", returnServiceBean.getMessages());
		request.setAttribute("messagesSpecific", returnServiceBean.getSpecificMessages());
		response=returnServiceBean.getReturnPage();
		logger.info(CommonConstants.Logger.LOGGER_END);
		return  new ModelAndView(response);   
	}
	
}
