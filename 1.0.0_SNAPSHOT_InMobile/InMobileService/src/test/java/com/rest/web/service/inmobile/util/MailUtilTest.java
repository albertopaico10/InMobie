package com.rest.web.service.inmobile.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.rest.web.service.inmobile.facade.impl.UserManagerImpl;

@ContextConfiguration(locations = {"/dispatcher-servlet.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class MailUtilTest {
	
	@Test
	public void testSendMail()throws Exception{
		String URL="http://localhost:8080/InMobile/continuar.htm?id=j3d34tfef5t35fe65tef24345fsarvs5y4654745";
		String body="<html>"
				+ "<body>"
				+ "<p>"
				+ "<b>InMobile Informa - Test Email</b>"
				+ "</p><br/>"
				+ "<p>Estimo Usario:</p><br/>"
				+ "<p>Se ha registrado correctamente como usuario en la aplication</p>"
				+ "<p>&#191;C&#243;mo funciona nuestro portal?</p>"
				+ "<p><b>Continuar</b>Tiene que dar click en el enlace, para continuar con su registro</p>"
//				+ "<a href='"+URL+"'>Aceptar :)</a>"
				+ "<a href='"+URL+"'>Aceptar :)</a>"
				+ "<p><b>Rechazar</b>Tiene que dar click en el enlace, para rechazar y no recivir información sobre nosotros.</p>"
				+ "<a href='http://www.peru21.pe'>Rechazar :/</a>"
				+ "</body>"
				+ "</html>";
		MailUtil.sendEmail("alberto_j10@hotmail.com", CommonConstants.Email.SUBJECT_CREATION_USER, body);
	}
	
	
	@Test
	public void testBuildURL()throws Exception{
		UserManagerImpl userManagerImpl=new UserManagerImpl();
		String URL=userManagerImpl.buildURL(60467);
		System.out.println("URL : "+URL);
	}
	
	@Test
	public void testEncriptionPassword()throws Exception{
		String password="12345678";
		String encriptedValue=UtilMethods.encriptedPassword(password, CommonConstants.EncriptedValues.ALGORITHM_MD5);
		System.out.println("encriptedValue : "+encriptedValue);
		String descriptedValue=UtilMethods.descriptionPassword(encriptedValue, CommonConstants.EncriptedValues.ALGORITHM_MD5);
		System.out.println("descriptedValue : "+descriptedValue);
		Assert.assertEquals(descriptedValue, password);
	}
	@Test
	public void testDesencriptorValue()throws Exception{
		String value="V9OTH1hwPVn/OS6ofpfIYg==";
		String descriptedValue=UtilMethods.descriptionPassword(value, CommonConstants.EncriptedValues.ALGORITHM_MD5);
		System.out.println("descriptedValue : "+descriptedValue);
		
	}
	
	@Test
	public void testRecoverValues()throws Exception{
		String value="content://media/external/images/media/7887";
		String newValue="";
		String arrayStr[]=value.split("content://");
		System.out.println("*** "+arrayStr[0].toString()+"*** "+arrayStr[1].toString());
	}
}
