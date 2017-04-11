/**
 * 
 */
package com.poc.imageupload.validator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.poc.imageupload.dto.UserDto;
import com.poc.imageupload.model.User;
import com.poc.imageupload.service.UserService;

/**
 * @author eotayde
 *
 */
@Component
public class UserValidator implements Validator {

	@Autowired
	private UserService userService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return UserDto.class.isAssignableFrom(clazz);
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object target, Errors errors) {
		UserDto userDto = (UserDto) target;
		
		if (userDto.getUser() == null || userDto.getUser().getUsername() == null) {
			errors.rejectValue("user.username", "error.username.empty");
		}
		
		if (userDto.getUser().getUsername().trim().length() <= 0) {
			errors.rejectValue("user.username", "error.username.empty");
		}
		
		if (userDto.getUser() != null && userDto.getUser().getUsername() != null) {
			// check if existing
			User userFromDao = userService.findByUsername(userDto.getUser().getUsername());
			
			if (userFromDao != null && userDto.getUser().getUsername().equals(userFromDao.getUsername())) {
				errors.rejectValue("user.username", "error.username.exists");
			}
		}
			
		
	}


}
