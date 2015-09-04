package com.cron.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class InicioController {
	@RequestMapping("inicio.htm")
    public String show(final HttpServletRequest request,final ModelMap model) {
		System.out.println("Start Cron");
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("scheduler-config.xml");
		return "loadPage.jsp"; 
	}
}
