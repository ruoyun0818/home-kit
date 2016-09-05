package com.whitesky.home.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.whitesky.home.util.Constants;

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
			request.getSession().setAttribute(Constants.SESSION_NO_LOGIN, "未登陆或者登陆超时");
			response.sendRedirect(request.getContextPath()+"/login");
		}
		return login;
	}
	
	public static boolean isLogin(HttpSession session){
		return session.getAttribute(Constants.SESSION_USER) != null;
	}
	
}
