package com.inmobile.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.inmobie.web.bean.RegisterUserDTO;
import com.inmobile.web.util.CommonConstants;

@Controller
public class LoginController {

	@RequestMapping("validateUser.htm")
	public ModelAndView validateUserForm(
			@ModelAttribute RegisterUserDTO logueoBean,
			final BindingResult result, final SessionStatus status,
			final HttpServletRequest request,final ModelMap model) {
		System.out.println("Dentro de ValidateUserForm");
		String response=CommonConstants.Page.REDIRECT_INIT_PAGE;
		System.out.println("Valores : "+logueoBean.getPassword()+"**** "+logueoBean.getUser()+"***"+logueoBean.getTypeUser());
		if(!("apaico".equals(logueoBean.getUser())&&"12345".equals(logueoBean.getPassword()))){
			model.addAttribute("loginUsuForm", logueoBean);
			request.setAttribute("messages", "incorrect");
			response=CommonConstants.Page.REDIRECT_LOGIN_PAGE;
		}
		return  new ModelAndView(response);   
	}
	
}
