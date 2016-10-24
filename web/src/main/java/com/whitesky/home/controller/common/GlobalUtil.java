package com.whitesky.home.controller.common;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.util.Assert;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.whitesky.home.utils.StringUtil;

/**
 * @Title: 请求访问部分工具
 * @Description: 
 * @author whitesky
 * @date 2016年10月24日
 */
public class GlobalUtil {
	public static WebApplicationContext getWebApplicationContext() {
		return ContextLoader.getCurrentWebApplicationContext();
	}

	public static ServletContext getServletContext() {
		WebApplicationContext webApplicationContext = getWebApplicationContext();
		ServletContext servletContext = webApplicationContext.getServletContext();
		return servletContext;
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
	 * 
	 * @param request
	 * @return
	 */
	public static String getRequestPath(HttpServletRequest request) {
		final String requestURI = request.getRequestURI();
		return requestURI.replaceFirst(getServletContext().getContextPath(), "");
	}

	public static String getIpAddr(HttpServletRequest request) {
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
