package com.rest.web.service.inmobile.hibernate.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.rest.web.service.inmobile.bean.user.UserRequest;
import com.rest.web.service.inmobile.facade.ReqRespManager;
import com.rest.web.service.inmobile.util.CommonConstants;

@ContextConfiguration(locations = {"/dispatcher-servlet.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class ReqRespHibernateImplTest {
	@Autowired
	ReqRespManager beanManager;
	
	@Test
	public void insertReqResp()throws Exception{
		UserRequest beanRequest=new UserRequest();
		beanRequest.setEmail("alberto_j10@hotmail.com");
		beanRequest.setPassword("1234566");
		beanRequest.setTypeCustomer("1");
		beanManager.saveOrUpdate(beanRequest, CommonConstants.TypeOperationReqResp.OPERATION_CREATE_USER, 0,0);
	}
}
