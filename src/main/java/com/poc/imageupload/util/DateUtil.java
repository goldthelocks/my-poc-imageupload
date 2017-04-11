/**
 * 
 */
package com.poc.imageupload.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author eotayde
 *
 */
public final class DateUtil {

	public static String getStringTime() {
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyyhhmmss");
		return currentDateTime.format(formatter);
	}
}
