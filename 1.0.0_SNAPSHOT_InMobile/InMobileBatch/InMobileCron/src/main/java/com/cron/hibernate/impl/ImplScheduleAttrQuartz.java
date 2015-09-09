package com.cron.hibernate.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cron.hibernate.IScheduleAttrQuartz;
import com.cron.hibernate.bean.ScheduleAttrQuartz;

@Service
public class ImplScheduleAttrQuartz implements IScheduleAttrQuartz {

	@Autowired
	SessionFactory objSessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<ScheduleAttrQuartz> listAllJobs() throws Exception {
		String strQuery = "from ScheduleAttrQuartz";
		Session objSession = objSessionFactory.openSession();
		System.out.println(objSession);
		List<ScheduleAttrQuartz> lstScheduleAttrQuartzs = objSession.createQuery(strQuery).list();
		return lstScheduleAttrQuartzs;	
	}

}
