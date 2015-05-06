package com.inmobile.web.facade;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.inmobile.web.bean.ProviderDTO;
import com.inmobile.web.bean.ReturnService;

@Service
public interface ProviderManager {

	public ReturnService saveProviderInformation(ProviderDTO beanDTO,MultipartFile file);
	
}
