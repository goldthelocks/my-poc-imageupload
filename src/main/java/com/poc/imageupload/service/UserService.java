/**
 * 
 */
package com.poc.imageupload.service;

import java.util.List;

import com.poc.imageupload.model.User;

/**
 * @author Eraine
 *
 */
public interface UserService {

	void save(User user);
	
	User findByUsername(String username);
	
	User findById(Long id);
	
	List<User> findAll();
	
}
