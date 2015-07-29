package com.inmobile.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.canonical.bean.restaurant.VerificationRestaurant;
import com.inmobile.web.bean.CheckRestaurantDTO;
import com.inmobile.web.bean.RegisterUserDTO;
import com.inmobile.web.bean.RestaurantDTO;
import com.inmobile.web.bean.ReturnService;
import com.inmobile.web.facade.RestaurantManager;
import com.inmobile.web.util.UtilMethods;

@Controller
public class RestaurantController {
	private static final Logger logger = LoggerFactory.getLogger(RestaurantController.class);
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
		request.setAttribute("listDay", beanReturn.getNameDay());
		request.setAttribute("listHours", beanReturn.getNumberHours());
		return new ModelAndView(beanReturn.getReturnPage());
	}
	
	@RequestMapping("saveScheduler.htm")
	public String findUser(final HttpServletRequest request,final ModelMap model) {
		final int idUser = Integer.parseInt(request.getParameter("idUser"));
		final String schedulerValues = String.valueOf(request.getParameter("schedulerDetail"));
		logger.info("Valores : "+idUser+"***"+schedulerValues);
		ReturnService beanReturnService=restaurantManager.saveRestaurantSchedulerInformation(idUser, schedulerValues);
		
		return beanReturnService.getReturnPage();
	}
	
	@RequestMapping(value="/getCheckValues.htm",method=RequestMethod.GET)
	public @ResponseBody String getCheckValues(@RequestParam String idRestaurant,final ModelMap model){
		System.out.println("getCheckValues-->Id Complaint : "+idRestaurant+"***");
		List<VerificationRestaurant> listRestaurant=restaurantManager.getCheckRestaurantInformation(idRestaurant);
		final CheckRestaurantDTO checkRest=new CheckRestaurantDTO();
		model.addAttribute("checkRestForm", checkRest);
//		String rootProject=request.getSession().getServletContext().getRealPath("");
		
//		List<ImageDTO> listSpecificDistrict=imageManager.getImageFromService(Integer.parseInt(id),rootProject);
		System.out.println("Lo que va es : "+UtilMethods.fromObjectToString(listRestaurant));
		return UtilMethods.fromObjectToString(listRestaurant);
	}
}
