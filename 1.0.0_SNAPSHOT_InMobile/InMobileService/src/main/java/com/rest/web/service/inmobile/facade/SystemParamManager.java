package com.rest.web.service.inmobile.facade;

import com.rest.web.service.inmobile.bean.EmailBean;
import com.rest.web.service.inmobile.bean.ServiceBean;

public interface SystemParamManager {
	public EmailBean getEmailInSystemParam(String generalParam,String typeOperation);
	public ServiceBean getValuesForService(String generalParam);
}
