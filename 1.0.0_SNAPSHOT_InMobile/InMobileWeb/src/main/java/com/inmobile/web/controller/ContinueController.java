package com.inmobile.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContinueController {

	
	@RequestMapping("continue.htm")
	public ModelAndView validateUserForm(final HttpServletRequest request,final ModelMap model) {
		System.out.println("Entre a Continue");
		return null;
	}
}
