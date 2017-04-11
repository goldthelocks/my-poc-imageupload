/**
 * 
 */
package com.poc.imageupload.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @author Eraine
 *
 */
@Entity
@Table(name = "tbluser_upload")
@EntityListeners(AuditingEntityListener.class)
public class UserUpload extends BaseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "image_location")
	private String imageLocation;
	
	@ManyToOne
	@JoinTable(name = "tbluser_upload_mapping", joinColumns = @JoinColumn(name = "upload_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private User user;

	/**
	 * 
	 */
	public UserUpload() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param imageLocation
	 */
	public UserUpload(String imageLocation) {
		super();
		this.imageLocation = imageLocation;
	}


	/**
	 * @param imageLocation
	 * @param user
	 */
	public UserUpload(String imageLocation, User user) {
		super();
		this.imageLocation = imageLocation;
		this.user = user;
	}



	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the imageLocation
	 */
	public String getImageLocation() {
		return imageLocation;
	}

	/**
	 * @param imageLocation
	 *            the imageLocation to set
	 */
	public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}



	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}



	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	

}
