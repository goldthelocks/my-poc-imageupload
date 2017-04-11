/**
 * 
 */
package com.poc.imageupload.dto;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.poc.imageupload.model.User;

/**
 * @author eotayde
 *
 */
@Component
public class ImageUploadDto {

	private MultipartFile[] uploadedPictures;
	private User user;

	public ImageUploadDto() {
		super();
	}

	/**
	 * @return the uploadedPictures
	 */
	public MultipartFile[] getUploadedPictures() {
		return uploadedPictures;
	}

	/**
	 * @param uploadedPictures
	 *            the uploadedPictures to set
	 */
	public void setUploadedPictures(MultipartFile[] uploadedPictures) {
		this.uploadedPictures = uploadedPictures;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

}
