package com.rest.web.service.inmobile.facade;

import org.springframework.stereotype.Service;

import com.canonical.bean.user.UserRequest;
import com.canonical.bean.user.UserResponse;

@Service
public interface UserManager {
	public UserResponse saveUserInformation(UserRequest userRequest);
	public UserResponse validateUser(UserRequest userRequest);
	public UserResponse activeAccount(String idUserEncripted);
}
