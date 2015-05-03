package com.rest.web.service.inmobile.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rest.web.service.inmobile.bean.ubigeo.UbigeoResponse;
import com.rest.web.service.inmobile.facade.UbigeoManager;
import com.rest.web.service.inmobile.util.CommonConstants;

@Controller
public class UbigeoController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UbigeoManager ubigeoManager;
	
	@RequestMapping(value = CommonConstants.ValueRequestMapping.LIST_DEPARTMENTS, method = RequestMethod.GET)
	public @ResponseBody UbigeoResponse getDepartmentsList() {
		logger.info("Entre getDepartmentsList");
		UbigeoResponse beanResponse=ubigeoManager.listAllDepartments();
		return beanResponse;
	}
	
	@RequestMapping(value = CommonConstants.ValueRequestMapping.LIST_PROVINCE, method = RequestMethod.GET)
	public @ResponseBody UbigeoResponse getListProvince(@PathVariable("id") int idDepartment) {
		logger.info("Start Department ID="+idDepartment);
		UbigeoResponse beanResponse=ubigeoManager.listAllProvince(idDepartment);
		return beanResponse;
	}
	
	@RequestMapping(value = CommonConstants.ValueRequestMapping.LIST_DISTRICT, method = RequestMethod.GET)
	public @ResponseBody UbigeoResponse getListDistrict(@PathVariable("id") int idProvince) {
		logger.info("Start Province ID="+idProvince);
		UbigeoResponse beanResponse=ubigeoManager.listAllDistrict(idProvince);
		return beanResponse;
	}
}