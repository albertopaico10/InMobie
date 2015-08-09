package com.inmobile.web.facade;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inmobile.web.bean.RegisterUserDTO;
import com.inmobile.web.bean.ReturnService;
import com.inmobile.web.bean.UbigeoDepartmentDTO;
import com.inmobile.web.bean.UbigeoDistrictDTO;
import com.inmobile.web.bean.UbigeoProvinceDTO;

@Service
public interface UserManager {

	public ReturnService registerUserInMobile(RegisterUserDTO beanUser);
	public ReturnService validateUser(RegisterUserDTO beanUser);
	public ReturnService activeAccountUser(String idUser);
	public List<UbigeoDepartmentDTO> listDepartment();
	public List<UbigeoProvinceDTO> listProvinceByDepartment(String idDepartment);
	public List<UbigeoDistrictDTO> listDistrictByProvince(String idProvince);
}
