package com.rest.web.service.inmobile.facade;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.rest.web.service.inmobile.bean.EmailBean;
import com.rest.web.service.inmobile.util.CommonConstants;


@ContextConfiguration(locations = {"/dispatcher-servlet.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class SystemParamManagerTest {

	@Autowired
	private SystemParamManager systemParamManager;
	
	@Test
	public void testSystemParam()throws Exception{
		EmailBean emailBean=systemParamManager.getEmailInSystemParam(CommonConstants.SystemParam.SYSTEM_PARAM_GENERAL_EMAIL,
				CommonConstants.Email.TYPE_OPERATION_REGISTER_COMPLETE_BY_ADMIN);
		System.out.println("DATOS : ");
		System.out.println("* "+emailBean.getSubjectEmail());
		System.out.println("* "+emailBean.getBodyEmail());
		System.out.println("* "+emailBean.getEmailFrom());
		System.out.println("* "+emailBean.getPasswordFrom());
	}
	
}
