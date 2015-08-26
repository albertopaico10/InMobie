package com.rest.web.service.inmobile.facade;

import com.canonical.bean.product.ExcelProductResponse;
import com.canonical.bean.product.ProductRequest;

public interface ProductManager {

	public ExcelProductResponse saveProductByExcelFile(ProductRequest productBeanRequest);
	
}
