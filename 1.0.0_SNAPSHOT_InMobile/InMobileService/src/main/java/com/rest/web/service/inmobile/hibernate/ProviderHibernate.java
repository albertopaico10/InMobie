package com.rest.web.service.inmobile.hibernate;

import java.util.List;

import com.rest.web.service.inmobile.hibernate.bean.DistrictProvider;
import com.rest.web.service.inmobile.hibernate.bean.Provider;

public interface ProviderHibernate {

	public void saveProvider(Provider objProvider)throws Exception;
	public void saveDistrictProvider(DistrictProvider objDistrictProvider)throws Exception;
	public Provider getDataProviderByUserId(int idUser)throws Exception;
	public List<Provider> listRestaurantPendingActive()throws Exception;
	public Provider getDataProviderById(int idProvider) throws Exception;
}

