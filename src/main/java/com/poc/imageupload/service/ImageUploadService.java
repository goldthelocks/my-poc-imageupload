/**
 * 
 */
package com.poc.imageupload.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.poc.imageupload.model.User;
import com.poc.imageupload.model.UserUpload;

/**
 * @author Eraine
 *
 */
public interface ImageUploadService {

	void saveImages(User user, MultipartFile[] multipartFile) throws IllegalStateException, IOException;
	
	List<UserUpload> findAll();
	
	List<UserUpload> findByUser(User user);
	
	User findById(Long id);

}
