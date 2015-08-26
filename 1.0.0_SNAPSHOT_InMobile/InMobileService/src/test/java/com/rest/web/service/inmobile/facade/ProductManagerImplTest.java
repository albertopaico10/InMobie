package com.rest.web.service.inmobile.facade;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations = {"/dispatcher-servlet.xml","/thread-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class ProductManagerImplTest {
	@Autowired
	private ProductManager productManager;
	
	@Test
	public void saveFileWithExcel()throws Exception{
		
		productManager.saveProductByExcelFile(null);
	}
	
}
