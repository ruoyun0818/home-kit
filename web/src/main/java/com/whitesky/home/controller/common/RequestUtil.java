package com.whitesky.home.controller.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.Assert;
import org.springframework.web.util.WebUtils;

import com.whitesky.home.common.WebConstants;
import com.whitesky.home.utils.StringUtil;

public class RequestUtil {
	/**
	 * 当前是否登录
	 * 
	 * @param request
	 * @return
	 */
	public static boolean isLogin(HttpServletRequest request) {
		return WebUtils.getSessionAttribute(request, WebConstants.SESSION_LOGIN_KEY) != null;
	}
	
	public static  void login(HttpServletRequest request){
		WebUtils.setSessionAttribute(request, WebConstants.SESSION_LOGIN_KEY, getIpAddr(request));
	}

	/**
	 * 是否请求的资源路径 {@code /res/**}
	 * 
	 * @param requestURI
	 * @return
	 */
	public static boolean isResRequest(HttpServletRequest request) {
		return getRequestPath(request).startsWith("/res/");
	}
	
	/**
	 * 获取相对路径,不包括项目根目录
	 * @param request
	 * @return
	 */
	public static String getRequestPath(HttpServletRequest request){
		final String requestURI = request.getRequestURI();
		return requestURI.replaceFirst(ContextUtil.getServletContext().getContextPath(), "");
	}
	
	public static String getIpAddr(HttpServletRequest request){
		if (request == null) {  
			Assert.isNull(request, "getIpAddr method HttpServletRequest Object is null");
	    }  
	    String ipString = request.getHeader("x-forwarded-for");  
	    if (StringUtil.isBlank(ipString) || "unknown".equalsIgnoreCase(ipString)) {  
	        ipString = request.getHeader("Proxy-Client-IP");  
	    }  
	    if (StringUtil.isBlank(ipString) || "unknown".equalsIgnoreCase(ipString)) {  
	        ipString = request.getHeader("WL-Proxy-Client-IP");  
	    }  
	    if (StringUtil.isBlank(ipString) || "unknown".equalsIgnoreCase(ipString)) {  
	        ipString = request.getRemoteAddr();  
	    }  
	  
	    // 多个路由时，取第一个非unknown的ip  
	    final String[] arr = ipString.split(",");  
	    for (final String str : arr) {  
	        if (!"unknown".equalsIgnoreCase(str)) {  
	            ipString = str;  
	            break;  
	        }  
	    }  
	  
	    return ipString;  
	}
}
