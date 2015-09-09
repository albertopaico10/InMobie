package com.rest.web.service.inmobile.hibernate;

import java.util.List;

import com.rest.web.service.inmobile.hibernate.bean.SystemParam;

public interface SystemParamHibernate {
	public List<SystemParam> listsByParam(String generalParam);
}
