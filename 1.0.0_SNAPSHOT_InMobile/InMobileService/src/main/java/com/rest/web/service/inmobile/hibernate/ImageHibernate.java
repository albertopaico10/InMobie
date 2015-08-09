package com.rest.web.service.inmobile.hibernate;

import com.rest.web.service.inmobile.hibernate.bean.Image;

public interface ImageHibernate {

	public int saveImageId(Image imageBean) throws Exception;
	public Image getImageById(int id) throws Exception;
	
}
