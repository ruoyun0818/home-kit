package com.whitesky.home.controller.common;

import javax.servlet.ServletContext;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

public class ContextUtil {
	
	public static WebApplicationContext getWebApplicationContext(){
		return ContextLoader.getCurrentWebApplicationContext();
	}

	public static ServletContext getServletContext() {
		WebApplicationContext webApplicationContext = getWebApplicationContext();
		ServletContext servletContext = webApplicationContext.getServletContext();
		return servletContext;
	}
}
