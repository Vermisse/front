package com.soft.util;

public class Black {
	public static String passwd(String password) {
		String passwd = Text.crc32(password + (char) 10);
		passwd += Text.sha1((char) 800 + password);
		return Text.md5(passwd);
	}
}
