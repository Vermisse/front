package com.soft.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtil {
	public static String getCookie(HttpServletRequest request) {
		String str = "";
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("id")) {
					str = Base64.getFromBase64(cookie.getValue());
				}
			}
		}
		return str;
	}
}
