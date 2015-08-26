package com.rest.web.service.inmobile.thread;

import java.math.BigDecimal;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.rest.web.service.inmobile.facade.impl.PresentationManagerImpl;
import com.rest.web.service.inmobile.hibernate.ProductHibernate;
import com.rest.web.service.inmobile.hibernate.bean.Product;
import com.rest.web.service.inmobile.hibernate.impl.ProductHibernateImplTest;
import com.rest.web.service.inmobile.util.CommonConstants;

@Component
@Scope("productBatchThread")
public class ProductBatchThread implements Runnable {
	private static final Logger LOGGER = LoggerFactory.getLogger(PresentationManagerImpl.class);

	private Iterator<Row> gRowIterator;
	private ProductHibernate gProductHibernate;
	
	public ProductBatchThread(Iterator<Row> rowIterator,ProductHibernate productHibernate) {
		gRowIterator = rowIterator;
		gProductHibernate=productHibernate;
	}
	
	public void run() {
		LOGGER.info(CommonConstants.Logger.LOGGER_START + "RUN");
		try {
			while (gRowIterator.hasNext()) {
				System.out.println("Entroooo");
				Row row = gRowIterator.next();
				// For each row, iterate through each columns
				Iterator<Cell> cellIterator = row.cellIterator();
				int i=0;
				while (cellIterator.hasNext()) {
					Product beanProduct=new Product();
					Cell cell = cellIterator.next();
					System.out.println("VALOR DEL I : "+i);
					switch (i) {
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
						Double presentation=cell.getNumericCellValue();
						beanProduct.setIdPresentation(presentation.intValue());
						break;
					case 4:
						Double stock=cell.getNumericCellValue();
						beanProduct.setTotalStock(stock.intValue());
						break;
					case 5:
						BigDecimal priceProduct=new BigDecimal(cell.getNumericCellValue());
						beanProduct.setCostProduct(priceProduct);
						break;
					case 6:
						Double category=cell.getNumericCellValue();
						beanProduct.setIdCategory(category.intValue());
						break;
					default:
						break;
					}
					//--Insert in DataBase
					gProductHibernate.saveOrUpdateProduct(beanProduct);
					i++;
				}
				System.out.println("");
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.info("Error : "+e.getMessage());
			LOGGER.error("Error : "+e.getMessage(),e);
		}
		LOGGER.info(CommonConstants.Logger.LOGGER_END);
	}
}