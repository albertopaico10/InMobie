package com.rest.web.service.inmobile.hibernate;

import java.util.List;

import com.rest.web.service.inmobile.hibernate.bean.Presentation;

public interface PresentationHibernate {
	public List<Presentation> listAllPresentation()throws Exception;
}
