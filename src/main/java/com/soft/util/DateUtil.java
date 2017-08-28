package com.soft.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 * @author wang
 *
 */
public class DateUtil {
	/**
	 * 获取当前时间
	 * @param format 需要的样式  如yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String getNow(String format) {
		return new SimpleDateFormat(format).format(new Date());
	}
}
