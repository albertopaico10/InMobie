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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.inmobile.web.bean.DistrictProviderDTO;
import com.inmobile.web.bean.ProviderDTO;
import com.inmobile.web.bean.ReturnService;
import com.inmobile.web.bean.UbigeoDepartmentDTO;
import com.inmobile.web.facade.ProviderManager;
import com.inmobile.web.facade.UserManager;

@Controller
public class ProviderController {
	private static final Logger logger = LoggerFactory.getLogger(RestaurantController.class);
	@Autowired
	private ProviderManager objProviderManager;
	@Autowired
	private UserManager userManager;	
	
	@RequestMapping("registerProvider.htm")
	public ModelAndView validateUserForm(
			@RequestParam("fileLogo") MultipartFile file,
			@ModelAttribute ProviderDTO objProviderDTO,
			final BindingResult result, final SessionStatus status,
			final HttpServletRequest request,final ModelMap model) {
		
		logger.info("Entro en el metodo de registro de proveedores");
		logger.info("ID User : "+objProviderDTO.getIdUser()+"*** "+objProviderDTO.getNameContact()
				+"*** "+objProviderDTO.getEmailContact()+"**"+objProviderDTO.getDepartment()+"**"
				+objProviderDTO.getProvince()+"**"
				+objProviderDTO.getDistrict());
		ReturnService beanReturn = objProviderManager.saveProviderInformation(objProviderDTO,file);
		DistrictProviderDTO objDistrictProviderDTO = new DistrictProviderDTO();
		objDistrictProviderDTO.setDepartment(1);
		objDistrictProviderDTO.setProvince(0);
		objDistrictProviderDTO.setDistrict(0);
		model.addAttribute("idDistrictProvider","");
		model.addAttribute("districtForm",objDistrictProviderDTO);
		request.setAttribute("department", 1);
		request.setAttribute("idUserReq", beanReturn.getIdUser());
		return new ModelAndView(beanReturn.getReturnPage());
	}
	
	@RequestMapping("registerDistrictProvider.htm")
	public ModelAndView registerDistrictProvider(@RequestParam("idUser") String idUser, @ModelAttribute DistrictProviderDTO objDistrictProviderDTO,final BindingResult result, final SessionStatus status,
			final HttpServletRequest request,final ModelMap model){
		System.out.println("Entro en el metodo de registro de distritos de proveedores");
		System.out.println("LOS VALORES SON LOS SIGUIENTES: "+objDistrictProviderDTO.getIdDistrict());
		objDistrictProviderDTO.setIdProvider(Integer.parseInt(idUser));
		String[] districts = objDistrictProviderDTO.getIdDistrict().split("-");
		
		String returnPage = "";
		for(String idDistrict : districts){
			objDistrictProviderDTO.setIdDistrict(idDistrict);
			ReturnService objReturnService = objProviderManager.saveProviderDistrict(objDistrictProviderDTO);
			System.out.println(objReturnService.getMessages());
			returnPage = objReturnService.getReturnPage();
		}

		return new ModelAndView(returnPage);
	}
	
	@ModelAttribute("listAllDepartment")
	public final List<UbigeoDepartmentDTO> departmentList(
	        final HttpServletRequest request) {
		try {
			List<UbigeoDepartmentDTO> listAllDepartment=userManager.listDepartment();
			System.out.println("Cantidad de areas  para cargar:"+listAllDepartment.size());
			return listAllDepartment;
		} catch (Exception e) {
			System.out.println("Error : "+e.toString());
		}
		return null;
	}
	
//	@RequestMapping(value="/getCheckValuesProvider.htm",method=RequestMethod.GET)
//	public @ResponseBody String getCheckValues(@RequestParam String idRestaurant,final ModelMap model){
//		System.out.println("getCheckValues-->Id Complaint : "+idRestaurant+"***");
//		List<VerificationRestaurant> listRestaurant=objProviderManager.getCheckRestaurantInformation(idRestaurant);
//		final CheckRestaurantDTO checkRest=new CheckRestaurantDTO();
//		model.addAttribute("checkRestForm", checkRest);
////		String rootProject=request.getSession().getServletContext().getRealPath("");
//		
////		List<ImageDTO> listSpecificDistrict=imageManager.getImageFromService(Integer.parseInt(id),rootProject);
//		System.out.println("Lo que va es : "+UtilMethods.fromObjectToString(listRestaurant));
//		return UtilMethods.fromObjectToString(listRestaurant);
//	}
	
}
