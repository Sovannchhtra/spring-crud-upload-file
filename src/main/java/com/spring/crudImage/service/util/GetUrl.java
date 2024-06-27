package com.spring.crudImage.service.util;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class GetUrl {
	
	public static String GetURLString(String path,String image) {
		String URL = ServletUriComponentsBuilder.fromCurrentContextPath().toUriString();
		return URL+"/"+path+"/"+image;
	}
}
