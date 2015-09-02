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
import com.rest.web.service.inmobile.util.UtilMethods;

@Component
@Scope("productBatchThread")
public class ProductBatchThread implements Runnable {
	private static final Logger LOGGER = LoggerFactory.getLogger(PresentationManagerImpl.class);

	private Iterator<Row> gRowIterator;
	@Autowired
	private ProductHibernate gProductHibernate;
	
	public ProductBatchThread(Iterator<Row> rowIterator) {
		gRowIterator = rowIterator;
	}
	
	public void run() {
		LOGGER.info(CommonConstants.Logger.LOGGER_START + "RUN");
		try {
			int rowNumber=0;
			while (gRowIterator.hasNext()) {
				System.out.println("Entroooo");
				Row row = gRowIterator.next();
				// For each row, iterate through each columns
				Iterator<Cell> cellIterator = row.cellIterator();
				int cellNumber=0;
				Product beanProduct=new Product();
				System.out.println("VALOR DEL Numero de Fila y columna : "+rowNumber+"***"+cellNumber);
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cellNumber) {
					case 0:
						LOGGER.error("Columna 0 : "+cell.getStringCellValue());
						beanProduct.setNameProduct(cell.getStringCellValue());
						break;
					case 1:
						LOGGER.error("Columna 1 : "+cell.getStringCellValue());
						beanProduct.setDescriptionProduct(cell.getStringCellValue());
						break;
					case 2:
						LOGGER.error("Columna 2 : "+cell.getStringCellValue());
						beanProduct.setBrand(cell.getStringCellValue());
						break;
					case 3:
						try {
							Double presentation=cell.getNumericCellValue();
							LOGGER.error("Columna 3 : "+presentation);
							beanProduct.setIdPresentation(presentation.intValue());
						} catch (Exception e) {
							LOGGER.error("Columna 3 : "+e.getMessage());
						}
						
						break;
					case 4:
						try {
							Double stock=cell.getNumericCellValue();
							LOGGER.error("Columna 4 : "+stock);
							beanProduct.setTotalStock(stock.intValue());
						} catch (Exception e) {
							LOGGER.error("Columna 4 : "+e.getMessage());
						}
						
						break;
					case 5:
						try {
							BigDecimal priceProduct=new BigDecimal(cell.getNumericCellValue());
							LOGGER.error("Columna 5 : "+priceProduct);
							beanProduct.setCostProduct(priceProduct);
						} catch (Exception e) {
							LOGGER.error("Columna 5 : "+e.getMessage());
						}
						
						break;
					case 6:
						try {
							Double category=cell.getNumericCellValue();
							LOGGER.error("Columna 6 : "+category);
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
				System.out.println("Termino Fila");
				if(rowNumber>1){
					//--Insert in DataBase
					LOGGER.info("Datos a grabar "+UtilMethods.fromObjectToString(beanProduct));
					gProductHibernate.saveOrUpdateProduct(beanProduct);
				}
				rowNumber++;
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.info("Error : "+e.getMessage());
			LOGGER.error("Error : "+e.getMessage(),e);
		}
		LOGGER.info(CommonConstants.Logger.LOGGER_END);
	}
}