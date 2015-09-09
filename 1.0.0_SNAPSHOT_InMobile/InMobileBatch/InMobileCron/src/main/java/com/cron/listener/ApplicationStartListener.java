package com.cron.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationStartListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
		
	}

	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		System.out.println("Init context of Quartz");
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("scheduler-config.xml");
	}


}
