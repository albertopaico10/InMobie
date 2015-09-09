package com.rest.web.service.inmobile.facade;

import com.canonical.bean.image.ImageRequest;
import com.canonical.bean.image.ImageResponse;


public interface ImageManager {

	public ImageResponse saveImage(ImageRequest beanRequest);
	
}
