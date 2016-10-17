package com.whitesky.home.controller.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.whitesky.home.common.WebConstants;

/**
 * @title 登陆Session过滤
 * @Description	
 * @author whitesky
 * @date 2016年9月5日
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean login = isLogin(request.getSession());
		if(!login){
			request.getSession().setAttribute(WebConstants.SESSION_NO_LOGIN, WebConstants.SESSION_NO_LOGIN_INFO);
			response.sendRedirect(request.getContextPath()+"/login");
		}
		return login;
	}
	
	public static boolean isLogin(HttpSession session){
		return session.getAttribute(WebConstants.SESSION_LOGIN_KEY) != null;
	}
	
}
