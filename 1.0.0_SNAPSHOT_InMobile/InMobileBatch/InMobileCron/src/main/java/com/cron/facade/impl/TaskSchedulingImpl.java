package com.cron.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cron.facade.TaskScheduling;
import com.cron.hibernate.IScheduleAttrQuartz;
import com.cron.hibernate.bean.ScheduleAttrQuartz;

@Service
public class TaskSchedulingImpl implements TaskScheduling{

	@Autowired
	private IScheduleAttrQuartz objIScheduleAttrQuartz;
	
	public void taskScheduling() {}

	public List<ScheduleAttrQuartz> listAllJobs() {
		// TODO Auto-generated method stub
		try {
			System.out.println("Valor: "+objIScheduleAttrQuartz);
			return objIScheduleAttrQuartz.listAllJobs();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
