package com.whitesky.home.controller.common.interceptor;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.whitesky.home.common.WebConstants;
import com.whitesky.home.controller.common.BaseController;
import com.whitesky.home.controller.common.GlobalManager;
import com.whitesky.home.controller.common.GlobalUtil;

/**
 * @title 登陆Session过滤
 * @Description
 * @author whitesky
 * @date 2016年9月5日
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

	public static final Logger logger = Logger.getLogger(LoginInterceptor.class);
	
	protected static final Set<String> NO_CHECKURIS = new HashSet<String>(); 
	static{
		NO_CHECKURIS.add(BaseController.LOGIN);
		NO_CHECKURIS.add(BaseController.DOLOGIN);
	};//允许未登录访问的请求

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		final boolean login = GlobalManager.isLogin(request);
		if (!login) {
			if(request.getAttribute(WebConstants.LOGIN_ERROR) == null)//可能注销的时候会传递消息
				request.setAttribute(WebConstants.LOGIN_ERROR, "未登录");
			if(!GlobalManager.isDeviceRegister(GlobalUtil.getIpAddr(request))){
				response.sendRedirect(BaseController.DEVICE_NO_LOGIN_HTML);
			}else if(NO_CHECKURIS.contains(GlobalUtil.getRequestPath(request))){
				return true;
			}else if (GlobalUtil.isResRequest(request)) {
				response.sendError(HttpStatus.FORBIDDEN.value(), "资源未找到");
			} else {
				request.getRequestDispatcher("/login").forward(request, response);
			}
		}
		return login;
	}

}
