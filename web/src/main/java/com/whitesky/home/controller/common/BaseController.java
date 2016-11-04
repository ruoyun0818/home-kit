package com.whitesky.home.controller.common;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseController {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public static final String LOGIN = "/login";
	public static final String DOLOGIN = "/doLogin";
	public static final String ERROR = "/error";
	public static final String NOT_FOUND = "/notFound";
	public static final String DEVICE_NO_LOGIN_HTML = "/static/noLogin.html";
	
	public static String error(HttpServletRequest request, String msg){
		request.setAttribute("title", "错误");
		request.setAttribute("message", msg);
		return ERROR;
	}
	
}
