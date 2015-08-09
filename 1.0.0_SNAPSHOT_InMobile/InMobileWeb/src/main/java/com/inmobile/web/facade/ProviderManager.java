package com.inmobile.web.facade;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.canonical.bean.provider.VerificationProvider;
import com.inmobile.web.bean.DistrictProviderDTO;
import com.inmobile.web.bean.ProviderDTO;
import com.inmobile.web.bean.ReturnService;

@Service
public interface ProviderManager {

	public ReturnService saveProviderInformation(ProviderDTO beanDTO,MultipartFile file);
	public ReturnService saveProviderByDistrict(DistrictProviderDTO disProviderDTO);
	public List<VerificationProvider> getCheckProviderInformation(String idProvider);
}
