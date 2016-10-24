package com.whitesky.home.controller.common.context;

import javax.servlet.ServletContextEvent;

import org.apache.log4j.Logger;
import org.springframework.web.context.ContextLoaderListener;

import com.whitesky.home.common.WebConstants;
import com.whitesky.home.controller.common.ContextUtil;
import com.whitesky.home.service.DeviceLoginService;

public class ContextInit extends ContextLoaderListener {
	
	public final static Logger logger = Logger.getLogger(ContextInit.class);
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);
		logger.info("contextInitialized...");
		ContextUtil.deviceInit();
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		super.contextDestroyed(event);
		logger.info("contextDestroyed...");
	}
	
}
