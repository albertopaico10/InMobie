package com.rest.web.service.inmobile.facade;

import org.springframework.stereotype.Service;

import com.canonical.bean.ubigeo.UbigeoResponse;


@Service
public interface UbigeoManager {

	public UbigeoResponse listAllDepartments();
	public UbigeoResponse listAllProvince(int idDepartment);
	public UbigeoResponse listAllDistrict(int idProvince);
}
