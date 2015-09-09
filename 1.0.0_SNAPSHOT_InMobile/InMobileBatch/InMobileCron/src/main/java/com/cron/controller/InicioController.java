package com.cron.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cron.facade.TaskScheduling;
import com.cron.hibernate.bean.ScheduleAttrQuartz;

@Controller
public class InicioController {
	
	@Autowired
	private TaskScheduling objTaskScheduling;
	
	@RequestMapping("inicio.htm")
    public String show(final HttpServletRequest request,final ModelMap model) {
		System.out.println("Load 100%");
		
		ArrayList<ScheduleAttrQuartz> lstScheduleAttrQuartzs = (ArrayList<ScheduleAttrQuartz>) objTaskScheduling.listAllJobs();
		
		for(ScheduleAttrQuartz obj : lstScheduleAttrQuartzs)
			System.out.println(obj.getName());
		
		return "loadPage.jsp"; 
	}
}
