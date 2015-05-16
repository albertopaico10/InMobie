package com.rest.web.service.inmobile.hibernate;

import com.rest.web.service.inmobile.hibernate.bean.DistrictProvider;
import com.rest.web.service.inmobile.hibernate.bean.Provider;

public interface ProviderHibernate {

	public void saveProvider(Provider objProvider)throws Exception;
	public void saveDistrictProvider(DistrictProvider objDistrictProvider)throws Exception;
}
