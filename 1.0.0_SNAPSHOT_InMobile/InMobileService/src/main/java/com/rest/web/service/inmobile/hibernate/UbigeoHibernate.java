package com.rest.web.service.inmobile.hibernate;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rest.web.service.inmobile.hibernate.bean.Department;
import com.rest.web.service.inmobile.hibernate.bean.District;
import com.rest.web.service.inmobile.hibernate.bean.Province;

@Service
public interface UbigeoHibernate {
	List<Department> listDepartment() throws Exception;
	Department getDepartmentById(int idDepartment) throws Exception;
	List<Province> listProvince(int idDepartment) throws Exception;
	Province getProvinceById(int idProvince) throws Exception;
	List<District> listDistrict(int idProvince) throws Exception;
	District getDistrictById(int idDistrict) throws Exception;
}
