/**
 * 
 */
package com.poc.imageupload.util;

import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

/**
 * @author eotayde
 *
 */
@Component
public final class MessageUtil {
	
	public static String getMessage(String key) {
		return getResourceBundle().getString(key);
	}
	
	private static ResourceBundle getResourceBundle() {
		return ResourceBundle.getBundle("messages/message");
	}
	
}
