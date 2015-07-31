package com.rest.web.service.inmobile.hibernate;

import com.rest.web.service.inmobile.hibernate.bean.CheckActiveProvider;

public interface CheckActiveProviderHibernate {
	
	public int saveProviderCheckActivation(CheckActiveProvider beanData)throws Exception;
	
}
