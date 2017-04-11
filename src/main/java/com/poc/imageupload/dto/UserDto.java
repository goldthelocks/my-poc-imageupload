/**
 * 
 */
package com.poc.imageupload.dto;

import org.springframework.stereotype.Component;

import com.poc.imageupload.model.User;

/**
 * @author eotayde
 *
 */
@Component
public class UserDto {

	private User user;

	/**
	 * @param user
	 */
	public UserDto() {
		super();
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
