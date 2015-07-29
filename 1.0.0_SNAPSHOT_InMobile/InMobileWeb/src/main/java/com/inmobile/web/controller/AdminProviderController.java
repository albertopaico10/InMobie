package com.inmobile.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.inmobile.web.bean.CheckRestaurantDTO;
import com.inmobile.web.bean.ReturnService;
import com.inmobile.web.facade.AdminProviderManager;
import com.inmobile.web.util.CommonConstants;

@Controller
public class AdminProviderController {
	private static final Logger logger = LoggerFactory.getLogger(AdminProviderController.class);
	
	@Autowired
	private AdminProviderManager adminProviderManager;
	
	@RequestMapping("listPendingActiveProvider.htm")
	public ModelAndView listPendingActiveProvider(final HttpServletRequest request,final ModelMap model) {
		logger.info(CommonConstants.Logger.LOGGER_START);
		ReturnService returnService=adminProviderManager.listProviderPending();
		request.setAttribute("listProviderPending", returnService.getListProviderDTO());
		request.setAttribute("messages", returnService.getMessages());
		
//		final CheckDTO checkRest=new CheckRestaurantDTO();
//		model.addAttribute("checkRestForm", checkRest);
		logger.info(CommonConstants.Logger.LOGGER_END+"**"+returnService.getReturnPage());
		return new ModelAndView(returnService.getReturnPage());
	}
}
