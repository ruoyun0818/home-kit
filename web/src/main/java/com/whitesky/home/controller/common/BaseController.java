package com.whitesky.home.controller.common;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
	public static final String LOGIN = "/login";
	public static final String ERROR = "/error";
	
	public static String error(HttpServletRequest request, String msg){
		request.setAttribute("title", "错误");
		request.setAttribute("message", msg);
		return ERROR;
	}
}
