package com.rest.web.service.inmobile.hibernate;

import org.springframework.stereotype.Service;

import com.rest.web.service.inmobile.bean.user.UserResponse;
import com.rest.web.service.inmobile.hibernate.bean.User;

@Service
public interface UserHibernate {
	public void saveUserDataBase(User userBean)throws Exception;
	public int saveUserResponseId(User userBean)throws Exception;
	public int findLastUser()throws Exception;
	public boolean existEmail(String email)throws Exception;
	public User validateUser(String email,String password)throws Exception;
	public User findUSerBean(String idUser)throws Exception;
	public User findUSerBeanActiveAccount(String idUser)throws Exception;
}
