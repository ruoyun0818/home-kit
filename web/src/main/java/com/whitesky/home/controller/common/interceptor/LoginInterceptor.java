package com.whitesky.home.controller.common.interceptor;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.whitesky.home.controller.common.BaseController;
import com.whitesky.home.controller.common.GlobalManager;
import com.whitesky.home.controller.common.RequestUtil;

/**
 * @title 登陆Session过滤
 * @Description
 * @author whitesky
 * @date 2016年9月5日
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

	protected final Logger logger = LoggerFactory.getLogger(GlobalManager.class);

	protected static final Set<String> NO_CHECKURIS = new HashSet<String>();

	static {
		NO_CHECKURIS.add(BaseController.LOGIN);
		NO_CHECKURIS.add(BaseController.DOLOGIN);
	};// 允许未登录访问的请求

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		final boolean login = GlobalManager.isLogin(request);
		if (!login) {
			if (!GlobalManager.isDeviceRegister(RequestUtil.getIpAddr(request))) {
				response.sendRedirect(request.getContextPath() + BaseController.DEVICE_NO_LOGIN_HTML);
			} else if (NO_CHECKURIS.contains(RequestUtil.getRequestPath(request))) {
				return true;
			} else if(RequestUtil.isResRequest(request)){
				return true;
			} else {
				response.sendRedirect(request.getContextPath() + BaseController.LOGIN);
			}
		}
		return login;
	}

}
