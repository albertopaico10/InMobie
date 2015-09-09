package com.cron.facade;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cron.hibernate.bean.ScheduleAttrQuartz;

@Service
public interface TaskScheduling {

	public void taskScheduling();
	
	public List<ScheduleAttrQuartz> listAllJobs();
}
