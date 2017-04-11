/**
 * 
 */
package com.poc.imageupload.validator;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import com.poc.imageupload.dto.ImageUploadDto;
import com.poc.imageupload.model.User;
import com.poc.imageupload.service.UserService;

/**
 * @author eotayde
 *
 */
@Component
public class ImageUploadValidator implements Validator {
	
	@Autowired
	private UserService userService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return ImageUploadDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ImageUploadDto imageUploadDto = (ImageUploadDto) target;
		
		if (imageUploadDto.getUser().getUsername() == null) {
			errors.rejectValue("user.username", "error.username.empty");
		}
		
		if (imageUploadDto.getUser().getUsername() != null && 
				imageUploadDto.getUser().getUsername().trim().length() <= 0) {
			errors.rejectValue("user.username", "error.username.empty");
		}
		
		User userFromDao = userService.findByUsername(imageUploadDto.getUser().getUsername());
		
		if (imageUploadDto.getUser().getUsername() != null && 
				imageUploadDto.getUser().getUsername().trim().length() > 0 && userFromDao == null) {
			errors.rejectValue("user.username", "error.username.notexists");
		}
		
		if (imageUploadDto.getUploadedPictures() == null) {
			errors.rejectValue("uploadedPictures", "file.empty");
		} 
		
		for (MultipartFile m : imageUploadDto.getUploadedPictures()) {

			if (m.getSize() <= 0) {
				errors.rejectValue("uploadedPictures", "file.empty");
			} else if (!getAllowedImageTypes().contains(m.getContentType())) {
				errors.rejectValue("uploadedPictures", "file.imagesonly");
			}
		}

	}

	protected List<String> getAllowedImageTypes() {
		List<String> imageList = new ArrayList<>();
		imageList.add("image/png");
		imageList.add("image/jpeg");
		imageList.add("image/jpg");
		
		return imageList;
	}
	
}
