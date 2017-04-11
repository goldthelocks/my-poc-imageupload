/**
 * 
 */
package com.poc.imageupload.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @author eotayde
 *
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseModel {

	@CreatedDate
	@Column(name = "upload_date", nullable = false, updatable = false)
	private Date uploadDate;

	/**
	 * 
	 */
	public BaseModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the uploadDate
	 */
	public Date getUploadDate() {
		return uploadDate;
	}

	/**
	 * @param uploadDate
	 *            the uploadDate to set
	 */
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

}
