package com.whitesky.home.controller.common.context;

import javax.servlet.ServletContextEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoaderListener;

import com.whitesky.home.controller.common.GlobalManager;

public class ContextInit extends ContextLoaderListener {
	
	protected final Logger logger = LoggerFactory.getLogger(GlobalManager.class);
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);
		logger.info("contextInitialized...");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		super.contextDestroyed(event);
		logger.info("contextDestroyed...");
	}
	
}
