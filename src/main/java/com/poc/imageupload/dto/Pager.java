/**
 * 
 */
package com.poc.imageupload.dto;

import java.io.Serializable;

/**
 * @author eotayde
 *
 */
public class Pager implements Serializable {

	private static final long serialVersionUID = 7437967831449434773L;
	
	private int beginIndex;
	private int endIndex;
	private int currentIndex;
	private int totalPageCount;
	private String baseUrl;
	private int totalItems;

	/**
	 * 
	 */
	public Pager() {
		super();
	}

	/**
	 * @return the beginIndex
	 */
	public int getBeginIndex() {
		return beginIndex;
	}

	/**
	 * @param beginIndex
	 *            the beginIndex to set
	 */
	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}

	/**
	 * @return the endIndex
	 */
	public int getEndIndex() {
		return endIndex;
	}

	/**
	 * @param endIndex
	 *            the endIndex to set
	 */
	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	/**
	 * @return the currentIndex
	 */
	public int getCurrentIndex() {
		return currentIndex;
	}

	/**
	 * @param currentIndex
	 *            the currentIndex to set
	 */
	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}

	/**
	 * @return the totalPageCount
	 */
	public int getTotalPageCount() {
		return totalPageCount;
	}

	/**
	 * @param totalPageCount
	 *            the totalPageCount to set
	 */
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	/**
	 * @return the baseUrl
	 */
	public String getBaseUrl() {
		return baseUrl;
	}

	/**
	 * @param baseUrl
	 *            the baseUrl to set
	 */
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	/**
	 * @return the totalItems
	 */
	public int getTotalItems() {
		return totalItems;
	}

	/**
	 * @param totalItems
	 *            the totalItems to set
	 */
	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

}
