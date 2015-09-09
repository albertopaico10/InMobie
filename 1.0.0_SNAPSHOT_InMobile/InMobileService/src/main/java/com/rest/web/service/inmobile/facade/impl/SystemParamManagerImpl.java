package com.rest.web.service.inmobile.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.web.service.inmobile.bean.EmailBean;
import com.rest.web.service.inmobile.bean.ServiceBean;
import com.rest.web.service.inmobile.facade.SystemParamManager;
import com.rest.web.service.inmobile.hibernate.SystemParamHibernate;
import com.rest.web.service.inmobile.hibernate.bean.SystemParam;
import com.rest.web.service.inmobile.util.CommonConstants;

@Service
@Transactional
public class SystemParamManagerImpl implements SystemParamManager {

	@Autowired
	private SystemParamHibernate systemParamHibernate;
	
	public EmailBean getEmailInSystemParam(String generalParam,String typeOperation) {
		EmailBean beanEmail=new EmailBean();
		List<SystemParam> listSystemParam=systemParamHibernate.listsByParam(generalParam);
		for(SystemParam beanSystemParam:listSystemParam){
			if(CommonConstants.SystemParam.SYSTEM_PARAM_EMAIL_FROM.equals(beanSystemParam.getNameParam())){
				beanEmail.setEmailFrom(beanSystemParam.getValueParam());
			}else if(CommonConstants.SystemParam.SYSTEM_PARAM_EMAIL_PORT_GMAIL.equals(beanSystemParam.getNameParam())){
				beanEmail.setEmailPort(beanSystemParam.getValueParam());
			}else if(CommonConstants.SystemParam.SYSTEM_PARAM_EMAIL_SMTP_GMAIL.equals(beanSystemParam.getNameParam())){
				beanEmail.setEmailSmtp(beanSystemParam.getValueParam());
			}else if(CommonConstants.SystemParam.SYSTEM_PARAM_EMAIL_TRUE.equals(beanSystemParam.getNameParam())){
				beanEmail.setEmailTrue(beanSystemParam.getValueParam());
			}else if(CommonConstants.SystemParam.SYSTEM_PARAM_PASSWORD_FROM.equals(beanSystemParam.getNameParam())){
				beanEmail.setPasswordFrom(beanSystemParam.getValueParam());
			}else if(CommonConstants.SystemParam.SYSTEM_PARAM_SUBJECT_CREATION_USER.equals(beanSystemParam.getNameParam())&&CommonConstants.Email.TYPE_OPERATION_CREATE_USER.equals(typeOperation)){
				beanEmail.setSubjectEmail(beanSystemParam.getValueParam());
			}else if(CommonConstants.SystemParam.SYSTEM_PARAM_BODY_EMAIL_CREATION_USER.equals(beanSystemParam.getNameParam())&&CommonConstants.Email.TYPE_OPERATION_CREATE_USER.equals(typeOperation)){
				beanEmail.setBodyEmail(beanSystemParam.getValueParam());
			}else if(CommonConstants.SystemParam.SYSTEM_PARAM_SUBJECT_CREATION_USER.equals(beanSystemParam.getNameParam())&&CommonConstants.Email.TYPE_OPERATION_REFORWARD_LINK_USER.equals(typeOperation)){
				beanEmail.setSubjectEmail(beanSystemParam.getValueParam());
			}else if(CommonConstants.SystemParam.SYSTEM_PARAM_BODY_EMAIL_ACTIVATION_USER.equals(beanSystemParam.getNameParam())&&CommonConstants.Email.TYPE_OPERATION_REFORWARD_LINK_USER.equals(typeOperation)){
				beanEmail.setBodyEmail(beanSystemParam.getValueParam());
			}else if(CommonConstants.SystemParam.SYSTEM_PARAM_BODY_EMAIL_FINAL_STEP_USER.equals(beanSystemParam.getNameParam())&&CommonConstants.Email.TYPE_OPERATION_REGISTER_COMPLETE_BY_USER.equals(typeOperation)){
				beanEmail.setBodyEmail(beanSystemParam.getValueParam());
			}else if(CommonConstants.SystemParam.SYSTEM_PARAM_SUBJECT_FINAL_STEP_USER.equals(beanSystemParam.getNameParam())&&CommonConstants.Email.TYPE_OPERATION_REGISTER_COMPLETE_BY_USER.equals(typeOperation)){
				beanEmail.setSubjectEmail(beanSystemParam.getValueParam());
			}else if(CommonConstants.SystemParam.SYSTEM_PARAM_BODY_EMAIL_COMPLETE_BY_ADMIN.equals(beanSystemParam.getNameParam())&&CommonConstants.Email.TYPE_OPERATION_REGISTER_COMPLETE_BY_ADMIN.equals(typeOperation)){
				beanEmail.setBodyEmail(beanSystemParam.getValueParam());
			}else if(CommonConstants.SystemParam.SYSTEM_PARAM_SUBJECT_COMPLETE_BY_ADMIN.equals(beanSystemParam.getNameParam())&&CommonConstants.Email.TYPE_OPERATION_REGISTER_COMPLETE_BY_ADMIN.equals(typeOperation)){
				beanEmail.setSubjectEmail(beanSystemParam.getValueParam());
			}
		}
		return beanEmail;
	}
	
	public ServiceBean getValuesForService(String generalParam){
		ServiceBean serviceBean=new ServiceBean();
		List<SystemParam> listSystemParam=systemParamHibernate.listsByParam(generalParam);
		for(SystemParam beanSystemParam:listSystemParam){
			if(CommonConstants.SystemParam.SYSTEM_PARAM_URL_SERVER.equals(beanSystemParam.getNameParam())){
				serviceBean.setUrlService(beanSystemParam.getValueParam());
			}else if(CommonConstants.SystemParam.SYSTEM_PARAM_PROJECT_VALUE.equals(beanSystemParam.getNameParam())){
				serviceBean.setProjectName(beanSystemParam.getValueParam());
			}else if(CommonConstants.SystemParam.SYSTEM_PARAM_ACTION_CONTINUE.equals(beanSystemParam.getNameParam())){
				serviceBean.setActionName(beanSystemParam.getValueParam());
			}
		}
		return serviceBean;		
	}
	
	
}
