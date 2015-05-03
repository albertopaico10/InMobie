package com.rest.web.service.inmobile.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.web.service.inmobile.bean.ubigeo.Ubigeo;
import com.rest.web.service.inmobile.bean.ubigeo.UbigeoResponse;
import com.rest.web.service.inmobile.facade.UbigeoManager;
import com.rest.web.service.inmobile.hibernate.UbigeoHibernate;
import com.rest.web.service.inmobile.hibernate.bean.Department;
import com.rest.web.service.inmobile.hibernate.bean.District;
import com.rest.web.service.inmobile.hibernate.bean.Province;
import com.rest.web.service.inmobile.util.CommonConstants;
import com.rest.web.service.inmobile.util.ConvertClass;

@Service
@Transactional
public class UbigeoManagerImpl implements UbigeoManager {
	
	
	@Autowired
	private UbigeoHibernate ubigeoHibernate;
	
	public UbigeoResponse listAllDepartments() {
		UbigeoResponse ubigeoBeanResponse=new UbigeoResponse();
		try {
			List<Department> beanDepartments=ubigeoHibernate.listDepartment();
			List<Ubigeo> ubigeoBean=ConvertClass.convertDataBasetoUbigeo(beanDepartments);
			ubigeoBeanResponse.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_SUCCESS_DEPARTMENT);
			ubigeoBeanResponse.setMessagesResponse("Retorna todos los departamentos");
			ubigeoBeanResponse.setUbigeoBean(ubigeoBean);
		} catch (Exception e) {
			ubigeoBeanResponse.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_ERROR);
			ubigeoBeanResponse.setMessagesResponse(e.getMessage());
		}
		return ubigeoBeanResponse;
	}

	public UbigeoResponse listAllProvince(int idDepartment) {
		UbigeoResponse ubigeoBeanResponse=new UbigeoResponse();
		try {
			List<Province> listProvince=ubigeoHibernate.listProvince(idDepartment);
			List<Ubigeo> ubigeoBean=ConvertClass.convertDataBaseProvincetoUbigeo(listProvince);
			ubigeoBeanResponse.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_SUCCESS_PROVINCE);
			ubigeoBeanResponse.setMessagesResponse("Retorna todos las provincias para la provincia de id "+idDepartment);
			ubigeoBeanResponse.setUbigeoBean(ubigeoBean);
		} catch (Exception e) {
			ubigeoBeanResponse.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_ERROR);
			ubigeoBeanResponse.setMessagesResponse(e.getMessage());
		}
		return ubigeoBeanResponse;
	}

	public UbigeoResponse listAllDistrict(int idProvince) {
		UbigeoResponse ubigeoBeanResponse=new UbigeoResponse();
		try {
			List<District> listDistrict=ubigeoHibernate.listDistrict(idProvince);
			List<Ubigeo> ubigeoBean=ConvertClass.convertDataBaseDistricttoUbigeo(listDistrict);
			ubigeoBeanResponse.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_SUCCESS_DISTRICT);
			ubigeoBeanResponse.setMessagesResponse("Retorna todos los distritos para el departamento de id "+idProvince);
			ubigeoBeanResponse.setUbigeoBean(ubigeoBean);
		} catch (Exception e) {
			ubigeoBeanResponse.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_ERROR);
			ubigeoBeanResponse.setMessagesResponse(e.getMessage());
		}
		return ubigeoBeanResponse;
	}

}
