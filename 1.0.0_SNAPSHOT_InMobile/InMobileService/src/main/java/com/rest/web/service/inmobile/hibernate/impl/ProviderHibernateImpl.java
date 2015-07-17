package com.rest.web.service.inmobile.hibernate.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.web.service.inmobile.hibernate.ProviderHibernate;
import com.rest.web.service.inmobile.hibernate.bean.ClientRestaurant;
import com.rest.web.service.inmobile.hibernate.bean.DistrictProvider;
import com.rest.web.service.inmobile.hibernate.bean.Provider;

@Repository
public class ProviderHibernateImpl implements ProviderHibernate {
	
	@Autowired
	SessionFactory sessionfactory;

	public void saveProvider(Provider objProvider) throws Exception {
		System.out.println("Grabar Proveedor");
		Session session = sessionfactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(objProvider);
		System.out.println("Last ID : "+objProvider.getId());
		transaction.commit();
		session.close();
	}

	public void saveDistrictProvider(DistrictProvider objDistrictProvider)
			throws Exception {
		Session session = sessionfactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(objDistrictProvider);
		System.out.println("Last ID : "+objDistrictProvider.getId());
		transaction.commit();
		session.close();
	}

	public Provider getDataProviderByUserId(int idUser) throws Exception {
		Provider providerBean=null;
		String query="from Provider where status=1 and idUser='"+idUser+"'";
		System.out.println("query : "+query);
		Session session=sessionfactory.openSession();
		
		List<Provider> listProviderSpecific=session.createQuery(query).list();
		System.out.println("Cantidad de filas : "+listProviderSpecific.size());
		
		session.close();
		if(listProviderSpecific.size()>0){
			providerBean=listProviderSpecific.get(0);
		}
		return providerBean;
	}
	
}
