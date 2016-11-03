package com.whitesky.home.utils;

public class StringUtil {
	public static boolean isBlank(String str) {
		return str == null || str.trim().equals("");
	}

	public static String getPrefix(String path) {
		if(path != null && path.contains("//.")){
			return path.substring(path.lastIndexOf("."), path.length());
		}
		return null;
	}
}
