package com.spring.crudImage.service.util;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageHandler {
	public static String ImageProcessHandling(MultipartFile file) {
		Date currentDate = new Date();
		String imageName = currentDate.getTime() +"-"+ file.getOriginalFilename();
		try {
			Path pathForUpload = Paths.get("public/image");
			Files.createDirectories(pathForUpload);
			InputStream inputStream = file.getInputStream();
			Files.copy(inputStream,Paths.get("public/image",imageName));
			return imageName;
		} catch (Exception e) {
			return "Error"+ e.getMessage();
		}
	}
}
