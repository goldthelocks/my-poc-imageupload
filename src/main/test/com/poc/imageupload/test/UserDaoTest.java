/**
 * 
 */
package com.poc.imageupload.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.poc.imageupload.model.User;
import com.poc.imageupload.service.UserService;

/**
 * @author Eraine
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

	@Autowired
	private UserService imageUploadService;
	
	@Test
	public void testGet() {
		User user = imageUploadService.findByUsername("eraine");
		
		System.out.println(user.toString());
	}
	
	public void testAddUser() {
		User user = new User();
		user.setUsername("eraine");
		
		imageUploadService.save(user);
	}
}
