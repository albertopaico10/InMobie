package com.rest.web.service.inmobile.facade.impl;

import java.util.Random;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.web.service.inmobile.bean.user.UserRequest;
import com.rest.web.service.inmobile.bean.user.UserResponse;
import com.rest.web.service.inmobile.facade.UserManager;
import com.rest.web.service.inmobile.hibernate.UserHibernate;
import com.rest.web.service.inmobile.hibernate.bean.UserDB;
import com.rest.web.service.inmobile.util.CommonConstants;
import com.rest.web.service.inmobile.util.ConvertClass;
import com.rest.web.service.inmobile.util.MailUtil;
import com.rest.web.service.inmobile.util.UtilMethods;

@Service
public class UserManagerImpl implements UserManager{

	@Autowired
	private UserHibernate userHibernate;
	
	public UserResponse saveUserInformation(UserRequest userRequest) {
		System.out.println("Entreeeeee saveUserInformation");
		UserResponse userBeanResponse=new UserResponse();
		
		try {
			boolean validateEmail=userHibernate.existEmail(userRequest.getEmail());
			//--Verify if email exist in Data Base
			if(!validateEmail){
				//--Save information in Data Base
				UserDB userDataBase=ConvertClass.convertUserRequestToDataBase(userRequest);
				userHibernate.saveUserResponseId(userDataBase);
				int idUser=userHibernate.findLastUser();
				userBeanResponse.setIdUser(idUser);
				//--URL
	            String URL=buildURL(userDataBase.getId());
				//--Send Email with URL
				System.out.println("Before Mandar el correo");
				buidlEmailCreationUser(userRequest.getEmail(),idUser,URL);
				//--Build Response for web service client
				
				userBeanResponse.setCodeResponse("SUCCESS_INSERT_USER");
				userBeanResponse.setMessagesResponse("The user was created successfully.");
				userBeanResponse.setDescription("Url : "+URL);
			}else{
				userBeanResponse.setCodeResponse("EMAIL_EXIST");
				userBeanResponse.setMessagesResponse("The Email exist in our Data Base");
			}
			
		} catch (Exception e) {
			userBeanResponse.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_ERROR);
			userBeanResponse.setMessagesResponse(e.getMessage());
		} 
		return userBeanResponse;
	}
	
	public void buidlEmailCreationUser(String emilTo,int idUser,String URL)throws MessagingException{
		String body="<html>"
				+ "<body>"
				+ "<p>"
				+ "<b>InMobile Informa - Test Email</b>"
				+ "</p><br/>"
				+ "<p>Estimo Usario:</p><br/>"
				+ "<p>Se ha registrado correctamente como usuario en la aplication</p>"
				+ "<p>&#191;C&#243;mo funciona nuestro portal?</p>"
				+ "<p><b>Continuar</b>Tiene que dar click en el enlace, para continuar con su registro (Enlace de Prueba)</p>"
				+ "<a href='"+URL+"'>Aceptar</a>"
				+ "<p><b>Rechazar</b>Tiene que dar click en el enlace, para rechazar y no recivir información sobre nosotros.(Enlace de Prueba)<</p>"
				+ "<a href='http://www.peru21.pe'>Rechazar</a>"
				+ "</body>"
				+ "</html>";
		MailUtil.sendEmail(emilTo,CommonConstants.Email.SUBJECT_CREATION_USER,body);
	}

	public String buildURL(int idUser){
		String URL=CommonConstants.ValuesProject.URL_SERVER+CommonConstants.ValuesProject.PROJECT_VALUE+CommonConstants.ValuesProject.ACTION_CONTINUE;
		String encriptedValue=UtilMethods.encriptedPassword(String.valueOf(idUser), CommonConstants.EncriptedValues.ALGORITHM_MD5);
		URL=URL+encriptedValue;
		return URL;
	}
	
}
