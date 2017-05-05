package com.whitesky.home.controller.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseController {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public static final String LOGIN = "/login";
	public static final String DOLOGIN = "/doLogin";
	public static final String ERROR = "/error";
	public static final String NOT_FOUND = "/notFound";
	public static final String DEVICE_NO_LOGIN_HTML = "/static/noLogin.html";
	
	@Autowired
	public HttpServletRequest request;
	@Autowired
	public HttpSession session;
	
	/**
	 * 获取请求ip
	 * @return
	 */
	protected String getIp(){
		return RequestUtil.getIpAddr(request);
	}
	
	/**
	 * 获取请求ip网卡
	 * @return
	 */
	protected String getMac(){
		return RequestUtil.getMacAddress(getIp());
	}
	
	protected String error(String msg){
		request.setAttribute("title", "错误");
		request.setAttribute("message", msg);
		return ERROR;
	}
	
}
