package com.whitesky.home.controller.common;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public abstract class BaseController {
	
	protected static final Logger logger = Logger.getLogger(new Object() {}.getClass().getEnclosingClass());
	
	public static final String LOGIN = "/login";
	public static final String DOLOGIN = "/doLogin";
	public static final String ERROR = "/error";
	public static final String DEVICE_NO_LOGIN_HTML = "/static/noLogin.html";
	
	public static String error(HttpServletRequest request, String msg){
		request.setAttribute("title", "错误");
		request.setAttribute("message", msg);
		return ERROR;
	}
}
