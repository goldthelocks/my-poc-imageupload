/**
 * 
 */
package com.poc.imageupload.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.imageupload.model.User;

/**
 * @author eotayde
 *
 */
public interface UserDao extends JpaRepository<User, Long> {

	User findByUsername(String username);
}
