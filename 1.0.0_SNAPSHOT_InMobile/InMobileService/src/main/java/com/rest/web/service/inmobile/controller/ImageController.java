package com.rest.web.service.inmobile.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.canonical.bean.image.ImageRequest;
import com.canonical.bean.image.ImageResponse;
import com.rest.web.service.inmobile.facade.ImageManager;
import com.rest.web.service.inmobile.util.CommonConstants;

@Controller
public class ImageController {
	private static final Logger logger = LoggerFactory.getLogger(ImageController.class);
	
	@Autowired
	private ImageManager imageManager;
	
	@RequestMapping(value = CommonConstants.ValueRequestMapping.SAVE_IMAGE, method = RequestMethod.POST)
	public @ResponseBody ImageResponse saveImage(@RequestBody ImageRequest beanRequest) {
		ImageResponse beanResponse=imageManager.saveImage(beanRequest);
		return beanResponse;
	}
}
