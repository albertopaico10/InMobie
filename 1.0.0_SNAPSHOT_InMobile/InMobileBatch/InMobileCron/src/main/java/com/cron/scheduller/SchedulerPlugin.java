package com.cron.scheduller;

import java.util.ArrayList;
import java.util.Date;

import org.quartz.CronTrigger;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.cron.facade.TaskScheduling;
import com.cron.facade.impl.TaskSchedulingImpl;
import com.cron.hibernate.bean.ScheduleAttrQuartz;
import com.cron.util.Contants;

public class SchedulerPlugin extends QuartzJobBean  {
	
	//private static final int NO_REMOBABLE_JOB = 0;
	@Autowired
	private TaskScheduling objTaskScheduling;
	
	@Override
	protected void executeInternal(JobExecutionContext jobContext)
			throws JobExecutionException {
		// TODO Auto-generated method stub
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		System.out.println(new Date()+ "--> HOLA ME ESTOY EJECUTANDO :D");
		configureJobs(jobContext.getScheduler());
	}
	
	
	public void configureJobs(Scheduler scheduler){
		try {
			//List<Matcher<TriggerKey>> lstKeys = new ArrayList<Matcher<TriggerKey>>();
			TaskScheduling objTaskScheduling2 = new TaskSchedulingImpl();
			System.out.println(objTaskScheduling+" vs "+objTaskScheduling2);
			ArrayList<ScheduleAttrQuartz> lstScheduleAttrQuartzs = (ArrayList<ScheduleAttrQuartz>) objTaskScheduling.listAllJobs();
			if (lstScheduleAttrQuartzs != null) {
				for (int i = 0; i < lstScheduleAttrQuartzs.size(); i++) {
					ScheduleAttrQuartz jobBean = lstScheduleAttrQuartzs.get(i);
					if(Contants.FLAG_YES.equals(jobBean.getEnabled())){
						JobDetail jobKey = scheduler.getJobDetail(jobBean.getName(), "Group" + jobBean.getId());
						if(jobKey != null){
							if(validateChangesJob(scheduler, jobBean)){
								System.out.println("JOB MODIFICADO: "+jobBean.getId());
								createJob(scheduler, jobBean, jobKey);
							}
						}else{
							System.out.println("JOB CREADO: "+jobBean.getId());
							createJob(scheduler, jobBean, jobKey);
						}
					}else{
						//if(jobBean.getId() != NO_REMOBABLE_JOB){
							System.out.println("NO ESTA HABILIDADO JOB: "+jobBean.getId());
							//TriggerKey trigerKey = new TriggerKey("TriggerJob" + jobBean.getScheduleId(),"Group" + jobBean.getScheduleId());;
							if(scheduler.getTrigger("TriggerJob" + jobBean.getId(),"Group" + jobBean.getId()) != null){
								System.out.println("LO SAQUE DEL SCHEDULE: "+jobBean.getId());
								scheduler.unscheduleJob("TriggerJob" + jobBean.getId(),"Group" + jobBean.getId());
							}
						//}
					}
				}
				//if(lstKeys.size() > 0){
				//	scheduler.getListenerManager().addTriggerListener(new QuartsPluginDataReportingTriggerListener(), lstKeys);
				//}
			} else {
				System.out.println("There are not any jobs ready to run");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean validateChangesJob(Scheduler scheduler, ScheduleAttrQuartz jobBean){
		boolean hasJobChanged = false;
		ScheduleAttrQuartz bean2 = null;

		try {
			JobDetail jobKey = scheduler.getJobDetail(jobBean.getName(), "Group" + jobBean.getId());
			if(jobKey != null){
				JobDataMap jobData2 = jobKey.getJobDataMap();
				bean2 = (ScheduleAttrQuartz)jobData2.get("bean");
			}
			
			if(bean2 != null){
				if(!jobBean.getClassname().equals(bean2.getClassname())){
					hasJobChanged = true;
				}else if(!jobBean.getCron_expression().equals(bean2.getCron_expression())){
					hasJobChanged = true;
				}	
			}
			
			if(hasJobChanged){
				System.out.println("JOB ELIMINADO: "+jobBean.getId());
				scheduler.deleteJob(jobBean.getName(), "Group" + jobBean.getId());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hasJobChanged;
	}
	
	public static void createJob(Scheduler scheduler, ScheduleAttrQuartz jobBean, JobDetail jobKey){
		try {
			JobDataMap jobData = new JobDataMap();
			jobData.put("bean", jobBean);
			@SuppressWarnings("rawtypes")
			Class jobClass = Class.forName(jobBean.getClassname());
			
			JobDetail job = new JobDetail(jobBean.getName(), "Group" + jobBean.getId(), jobClass);
			job.setJobDataMap(jobData);

			CronTrigger trigger = new CronTrigger("TriggerJob" + jobBean.getId(),"Group" + jobBean.getId());
			trigger.setCronExpression(jobBean.getCron_expression());
			trigger.setJobDataMap(jobData);

			//lstKeys.add(KeyMatcher.keyEquals(trigerKey));
			scheduler.start();
			scheduler.scheduleJob(job, trigger);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
