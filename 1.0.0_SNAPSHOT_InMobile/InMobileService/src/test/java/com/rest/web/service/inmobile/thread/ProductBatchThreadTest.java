package com.rest.web.service.inmobile.thread;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.rest.web.service.inmobile.hibernate.ProductHibernate;

@ContextConfiguration(locations = {"/dispatcher-servlet.xml","/thread-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class ProductBatchThreadTest {

	@Autowired
	private ProductHibernate gProductHibernate;
//	private ProductBatchThread productBatchThread;
	
	@Test
	public void testThread()throws Exception{
		FileInputStream file = new FileInputStream(new File("D:\\batch.xlsx"));
		Workbook workbook = new XSSFWorkbook(file);
		Sheet firstSheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = firstSheet.iterator();
		ApplicationContext context = new ClassPathXmlApplicationContext("/thread-context.xml");
		ThreadPoolTaskExecutor taskExecutor = (ThreadPoolTaskExecutor) context.getBean("productBatchThread");
		taskExecutor.execute(new ProductBatchThread(rowIterator));

	}
	
	@Test
	public void processFile()throws Exception{
		FileInputStream file = new FileInputStream(new File("D:\\batch.xlsx"));
		try {
			Workbook workbook = new XSSFWorkbook(file);
			Sheet firstSheet = workbook.getSheetAt(0);
			// Iterate through each rows from first sheet
			Iterator<Row> rowIterator = firstSheet.iterator();
			while (rowIterator.hasNext()) {
				System.out.println("Entroooo");
				Row row = rowIterator.next();

				// For each row, iterate through each columns
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {

					Cell cell = cellIterator.next();

					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_BOOLEAN:
						System.out.print(cell.getBooleanCellValue() + "\n");
						break;
					case Cell.CELL_TYPE_NUMERIC:
						System.out.print(cell.getNumericCellValue() + "\n");
						break;
					case Cell.CELL_TYPE_STRING:
						System.out.print(cell.getStringCellValue() + "\n");
						break;
					}
				}
				System.out.println("");
			}
			file.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
