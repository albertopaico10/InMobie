package com.rest.web.service.inmobile.thread;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations = {"/dispatcher-servlet.xml","/thread-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class ProductBatchThreadTest {

	//	@Autowire
//	private ProductBatchThread productBatchThread;
	
	@Test
	public void testThread()throws Exception{
		System.out.println("Empezooooo");
		ProductBatchThread productBatchThread2 = new ProductBatchThread( "Thread-1");
		productBatchThread2.start();
	      
//	      ThreadDemo T2 = new ThreadDemo( "Thread-2");
//	      T2.start();
	}
	
}
