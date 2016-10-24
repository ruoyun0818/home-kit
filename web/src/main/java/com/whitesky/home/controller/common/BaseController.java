package com.whitesky.home.controller.common;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.whitesky.home.model.DeviceLogin;
import com.whitesky.home.service.DeviceLoginService;

public abstract class BaseController {
	
	protected static final Logger logger = Logger.getLogger(new Object() {}.getClass().getEnclosingClass());
	
	public static final String LOGIN = "/login";
	public static final String DOLOGIN = "/doLogin";
	public static final String ERROR = "/error";
	public static final String DEVICE_NO_LOGIN_HTML = GlobalUtil.getServletContext().getContextPath()+"/static/html/noLogin.html";
	
	public static String error(HttpServletRequest request, String msg){
		request.setAttribute("title", "错误");
		request.setAttribute("message", msg);
		return ERROR;
	}
	
	@Autowired
	public static DeviceLoginService deviceLoginService;
	
	protected static Map<String, DeviceLogin> ipRegisterMap = Collections.synchronizedMap(new HashMap<String, DeviceLogin>());
	
}
