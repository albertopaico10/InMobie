package com.cron.hibernate;

import java.util.List;

import com.cron.hibernate.bean.ScheduleAttrQuartz;

public interface IScheduleAttrQuartz {
	
	public List<ScheduleAttrQuartz> listAllJobs() throws Exception;
	
}
