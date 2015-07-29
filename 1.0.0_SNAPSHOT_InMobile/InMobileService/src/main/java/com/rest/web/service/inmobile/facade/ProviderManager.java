package com.rest.web.service.inmobile.facade;

import org.springframework.stereotype.Service;

import com.canonical.bean.provider.DistrictProviderRequest;
import com.canonical.bean.provider.DistrictProviderResponse;
import com.canonical.bean.provider.ListProvider;
import com.canonical.bean.provider.ProviderRequest;
import com.canonical.bean.provider.ProviderResponse;


@Service
public interface ProviderManager {

	public ProviderResponse saveProvider(ProviderRequest objProviderRequest);
	public DistrictProviderResponse saveDistrictProvider(DistrictProviderRequest objDistrictProviderRequest);
	public ListProvider listProviderPendingActive();
}
