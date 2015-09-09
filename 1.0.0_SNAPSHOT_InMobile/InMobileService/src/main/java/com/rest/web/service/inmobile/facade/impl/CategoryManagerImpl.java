package com.rest.web.service.inmobile.facade.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.canonical.bean.category.CategoryResponse;
import com.canonical.bean.category.ListCategoryResponse;
import com.rest.web.service.inmobile.facade.CategoryManager;
import com.rest.web.service.inmobile.hibernate.CategoryHibernate;
import com.rest.web.service.inmobile.hibernate.bean.Category;
import com.rest.web.service.inmobile.util.CommonConstants;
import com.rest.web.service.inmobile.util.ConvertClass;
@Service
@Transactional
public class CategoryManagerImpl implements CategoryManager {
	private static final Logger logger = LoggerFactory.getLogger(CategoryManagerImpl.class);
	
	@Autowired
	private CategoryHibernate categoryHibernate;
	
	public ListCategoryResponse listAllCategories() {
		logger.info(CommonConstants.Logger.LOGGER_START);
		ListCategoryResponse listCategoryResponse=new ListCategoryResponse();
		try {   
			List<Category> listCategory=categoryHibernate.listAllCategory();
			List<CategoryResponse> listConvCategoryResponse=ConvertClass.convertListCategoryToListCategoryResponse(listCategory);
			if(listConvCategoryResponse.size()>0){
				listCategoryResponse.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_SUCCESS_LIST_CATEGORY);
				listCategoryResponse.setListCategoryResponse(listConvCategoryResponse);
			}else{
				logger.info("There is not Category");
				listCategoryResponse.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_EMPTY_LIST_CATEGORY);
			}
		} catch (Exception e) {
			listCategoryResponse.setCodeResponse(CommonConstants.CodeResponse.CODE_RESPONSE_ERROR);
			logger.error(e.getMessage());
			
		}
		logger.info(CommonConstants.Logger.LOGGER_END);
		return listCategoryResponse;
	}

}
