package com.inmobile.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import com.inmobie.web.bean.RegisterUserDTO;
import com.inmobile.web.util.CommonConstants;

@Controller
public class InitController {
	
	@RequestMapping("inicio.htm")
    public String show(final HttpServletRequest request,final ModelMap model) {
		System.out.println("inside inicio htm");
		final RegisterUserDTO tableUser=new RegisterUserDTO();
		model.addAttribute("loginUsuForm", tableUser);
		return CommonConstants.Page.REDIRECT_LOGIN_PAGE; 
//		return CommonConstants.Page.REDIRECT_INIT_PAGE; 
	}
}
