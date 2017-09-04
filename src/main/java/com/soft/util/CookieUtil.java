package com.soft.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtil {
	public static String getCookie(HttpServletRequest request) {
		String str = "";
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("id")) {
					try {
						str = Base64.getFromBase64(URLDecoder.decode(cookie.getValue(), "utf8"));
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return str;
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		System.out.println(URLDecoder.decode("%3D", "utf8"));
	}
}
