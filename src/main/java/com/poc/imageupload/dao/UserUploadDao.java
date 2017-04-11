/**
 * 
 */
package com.poc.imageupload.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poc.imageupload.model.User;
import com.poc.imageupload.model.UserUpload;

/**
 * @author Eraine
 *
 */
@Repository
public interface UserUploadDao extends JpaRepository<UserUpload, Long>{

	List<UserUpload> findByUserId(Long userId);
	
	List<UserUpload> findByUserOrderByUploadDateDesc(User user);
	
}
