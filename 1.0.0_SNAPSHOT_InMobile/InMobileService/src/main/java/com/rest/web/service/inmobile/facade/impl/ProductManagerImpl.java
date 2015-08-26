package com.rest.web.service.inmobile.facade.impl;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.canonical.bean.product.ExcelProductResponse;
import com.canonical.bean.product.ProductRequest;
import com.rest.web.service.inmobile.facade.ProductManager;
import com.rest.web.service.inmobile.hibernate.ProductHibernate;
import com.rest.web.service.inmobile.hibernate.bean.Product;
import com.rest.web.service.inmobile.thread.ProductBatchThread;
import com.rest.web.service.inmobile.util.CommonConstants;
import com.rest.web.service.inmobile.util.UtilMethods;

@Service
@Transactional
public class ProductManagerImpl implements ProductManager {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductManagerImpl.class);
	
	@Qualifier("taskExecutor")
	private TaskExecutor taskExecutor;
	@Autowired
	private ProductHibernate productHibernate;
	
	public ExcelProductResponse saveProductByExcelFile(ProductRequest productBeanRequest) {
		LOGGER.info(CommonConstants.Logger.LOGGER_START);
		ExcelProductResponse beanResponse=new ExcelProductResponse();
		try {
			FileInputStream file = new FileInputStream(new File("D:\\batch.xlsx"));
			Workbook workbook = new XSSFWorkbook(file);
			Sheet firstSheet = workbook.getSheetAt(0);
			final Iterator<Row> rowIterator = firstSheet.iterator();
			System.out.println("Antes de la tarea");
			processExcelFile(rowIterator);
			System.out.println("Despues de la tarea");
			beanResponse.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_EXCEL_PROCESS_FILE);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(),e);
		}
		
		
		LOGGER.info(CommonConstants.Logger.LOGGER_END);
		return beanResponse;
	}
	
	@Async
	private void processExcelFile(Iterator<Row> rowIterator) {
		LOGGER.info(CommonConstants.Logger.LOGGER_START + "RUN");
		try {
			int rowNumber=0;
			while (rowIterator.hasNext()) {
				System.out.println("Entroooo");
				Row row = rowIterator.next();
				// For each row, iterate through each columns
				Iterator<Cell> cellIterator = row.cellIterator();
				int cellNumber=0;
				Product beanProduct=new Product();
				System.out.println("VALOR DEL Numero de Fila y columna : "+rowNumber+"***"+cellNumber);
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cellNumber) {
					case 0:
						beanProduct.setNameProduct(cell.getStringCellValue());
						break;
					case 1:
						beanProduct.setDescriptionProduct(cell.getStringCellValue());
						break;
					case 2:
						beanProduct.setBrand(cell.getStringCellValue());
						break;
					case 3:
						try {
							Double presentation=cell.getNumericCellValue();
							beanProduct.setIdPresentation(presentation.intValue());
						} catch (Exception e) {
							LOGGER.error("Columna 3 : "+e.getMessage());
						}
						
						break;
					case 4:
						try {
							Double stock=cell.getNumericCellValue();
							beanProduct.setTotalStock(stock.intValue());
						} catch (Exception e) {
							LOGGER.error("Columna 4 : "+e.getMessage());
						}
						
						break;
					case 5:
						try {
							BigDecimal priceProduct=new BigDecimal(cell.getNumericCellValue());
							beanProduct.setCostProduct(priceProduct);
						} catch (Exception e) {
							LOGGER.error("Columna 5 : "+e.getMessage());
						}
						
						break;
					case 6:
						try {
							Double category=cell.getNumericCellValue();
							beanProduct.setIdCategory(category.intValue());
						} catch (Exception e) {
							LOGGER.error("Columna 6: "+e.getMessage());
						}
						
						break;
					default:
						break;
					}
					cellNumber++;
				}
				//--Insert in DataBase
				if(rowNumber>1){
					LOGGER.info("Datos a grabar "+UtilMethods.fromObjectToString(beanProduct));
					productHibernate.saveOrUpdateProduct(beanProduct);
				}
				rowNumber++;
			}
		} catch (Exception e) {
//			LOGGER.info("Error : "+e.getMessage());
			LOGGER.error("Error : "+e.getMessage(),e);
		}
		LOGGER.info(CommonConstants.Logger.LOGGER_END);
	}
	
	
}
