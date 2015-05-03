package com.rest.web.service.inmobile.hibernate.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.web.service.inmobile.hibernate.UbigeoHibernate;
import com.rest.web.service.inmobile.hibernate.bean.Department;
import com.rest.web.service.inmobile.hibernate.bean.District;
import com.rest.web.service.inmobile.hibernate.bean.Province;

@Repository
public class UbigeoHibernateImpl implements UbigeoHibernate {

	@Autowired
	SessionFactory sessionfactory;
	
	public List<Department> listDepartment() throws Exception {
		String query="from Department";
		System.out.println("query : "+query);
		Session session=sessionfactory.openSession();
		
		List<Department> listDepartments=session.createQuery(query).list();
		System.out.println("Cantidad de filas : "+listDepartments.size());
		
		session.close();
		return listDepartments;
	}

	public List<Province> listProvince(int idDepartment) throws Exception {
		String query="from Province where departmentId='"+idDepartment+"'";
		System.out.println("query : "+query);
		Session session=sessionfactory.openSession();
		
		List<Province> listProvince=session.createQuery(query).list();
		System.out.println("Cantidad de filas : "+listProvince.size());
		
		session.close();
		return listProvince;
	}

	public List<District> listDistrict(int idProvince) throws Exception {
		String query="from District where provinceId='"+idProvince+"'";
		System.out.println("query : "+query);
		Session session=sessionfactory.openSession();
		
		List<District> listDistrict=session.createQuery(query).list();
		System.out.println("Cantidad de filas : "+listDistrict.size());
		
		session.close();
		return listDistrict;
	}

}
