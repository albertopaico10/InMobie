package com.cron.scheduller;

import org.springframework.stereotype.Component;

@Component("myBean")
public class SchedulerProcess {
	public void printMessage() {
		System.out.println("I am called by Spring scheduler");
	}
}
