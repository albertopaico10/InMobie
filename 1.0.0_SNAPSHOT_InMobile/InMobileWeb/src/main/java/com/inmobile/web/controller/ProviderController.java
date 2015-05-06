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
import org.springframework.web.servlet.ModelAndView;

import com.inmobile.web.bean.ProviderDTO;
import com.inmobile.web.bean.ReturnService;
import com.inmobile.web.facade.ProviderManager;
import com.inmobile.web.util.CommonConstants;

@Controller
public class ProviderController {
	
	@Autowired
	private ProviderManager objProviderManager;
	
	@RequestMapping("registerProvider.htm")
	public ModelAndView validateUserForm(
			@RequestParam("fileLogo") MultipartFile file,
			@ModelAttribute ProviderDTO objProviderDTO,
			final BindingResult result, final SessionStatus status,
			final HttpServletRequest request,final ModelMap model) {
		
		String response = CommonConstants.Page.REDIRECT_INIT_PAGE;
		
		System.out.println("Entro en el metodo de registro de proveedores");
		System.out.println("ID User : "+objProviderDTO.getIdUser()+"*** "+objProviderDTO.getNameContact()
				+"*** "+objProviderDTO.getEmailContact()+"**"+objProviderDTO.getDepartment()+"**"
				+objProviderDTO.getProvince()+"**"
				+objProviderDTO.getDistrict());
		ReturnService beanReturn = objProviderManager.saveProviderInformation(objProviderDTO,file);
		request.setAttribute("idUserReq", beanReturn.getIdUser());
		return  new ModelAndView(beanReturn.getReturnPage());
	}
	
}
