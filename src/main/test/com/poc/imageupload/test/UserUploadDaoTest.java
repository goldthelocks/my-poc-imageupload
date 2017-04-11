/**
 * 
 */
package com.poc.imageupload.test;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.poc.imageupload.dao.UserUploadDao;
import com.poc.imageupload.model.User;
import com.poc.imageupload.model.UserUpload;
import com.poc.imageupload.service.ImageUploadService;
import com.poc.imageupload.service.UserService;
import com.poc.imageupload.service.impl.ImageUploadServiceImpl;

/**
 * @author Eraine
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserUploadDaoTest {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ImageUploadService imageUploadService;

	
	@Test
	public void testGetAll() {
		User user = userService.findByUsername("admin");
		
		List<UserUpload> list = imageUploadService.findByUser(user);
		
		for (UserUpload u : list) {
			System.out.println(u.toString());
		}
		
	}
	
	public void testGet() {
		User user = userService.findById(1L);
		
		Set<UserUpload> imageList = user.getUserUpload();
		
		for (UserUpload u : imageList) {
			System.out.println(u.toString());
		}
	}
	
	public void testAddUser() {
		User user = new User();
		user.setUsername("eraine");
		
		userService.save(user);
	}
}
