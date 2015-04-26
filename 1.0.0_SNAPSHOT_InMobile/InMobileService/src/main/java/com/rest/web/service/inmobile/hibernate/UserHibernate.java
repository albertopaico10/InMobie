package com.rest.web.service.inmobile.hibernate;

import org.springframework.stereotype.Service;

import com.rest.web.service.inmobile.hibernate.bean.UserDB;

@Service
public interface UserHibernate {
	public void saveUserDataBase(UserDB userBean)throws Exception;
	public int saveUserResponseId(UserDB userBean)throws Exception;
	public int findLastUser()throws Exception;
	public boolean existEmail(String email)throws Exception;
}
