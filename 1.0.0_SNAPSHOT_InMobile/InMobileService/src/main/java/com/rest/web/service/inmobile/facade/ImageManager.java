package com.rest.web.service.inmobile.facade;

import com.rest.web.service.inmobile.bean.image.ImageRequest;
import com.rest.web.service.inmobile.bean.image.ImageResponse;

public interface ImageManager {

	public ImageResponse saveImage(ImageRequest beanRequest);
	
}
