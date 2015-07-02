package com.inmobile.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.inmobile.web.bean.CheckRestaurantDTO;
import com.inmobile.web.bean.RegisterUserDTO;
import com.inmobile.web.bean.ReturnService;
import com.inmobile.web.facade.AdminManager;
import com.inmobile.web.util.CommonConstants;

@Controller
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private AdminManager adminManger; 
	
	@RequestMapping("listPendingActive.htm")
	public ModelAndView validateUserForm(final HttpServletRequest request,final ModelMap model) {
		logger.info(CommonConstants.Logger.LOGGER_START);
		ReturnService returnService= adminManger.listRestaurantPending();
		request.setAttribute("listRestaurantPending", returnService.getListRestaurantDTO());
		request.setAttribute("messages", returnService.getMessages());
		
		HttpSession session = request.getSession();
		logger.info("Email que se va mandar : "+session.getAttribute("emailUser"));
		request.setAttribute("emailUser", session.getAttribute("emailUser"));
		final CheckRestaurantDTO checkRest=new CheckRestaurantDTO();
		model.addAttribute("checkRestForm", checkRest);
		logger.info(CommonConstants.Logger.LOGGER_END+"**"+returnService.getReturnPage());
		return new ModelAndView(returnService.getReturnPage());
	}
	
	@RequestMapping("saveCheckRestaurant.htm")
	public ModelAndView validateUserForm(
			@ModelAttribute CheckRestaurantDTO checkRestDTO,
			final BindingResult result, final SessionStatus status,
			final HttpServletRequest request,final ModelMap model) {
		System.out.println("Grabar Resultados : ");
		logger.info("Datos : "+checkRestDTO.getManualReception()+"***"+checkRestDTO.getTraining()+"***"+
		checkRestDTO.getVerificationSunat()+"///"+checkRestDTO.getIdMembershipPlan()+"////"+checkRestDTO.getRestaurantId()+"\\\\"+checkRestDTO.getIdCheck());
	    ReturnService beanReturn=adminManger.updateCheckRestaurant(checkRestDTO);
	    request.setAttribute("messagesSpecific", beanReturn.getSpecificMessages());
		return new ModelAndView("redirect:"+beanReturn.getReturnPage());
	}
}
