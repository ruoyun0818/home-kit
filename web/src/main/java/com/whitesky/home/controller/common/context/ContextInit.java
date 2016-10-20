package com.whitesky.home.controller.common.context;

import javax.servlet.ServletContextEvent;

import org.apache.log4j.Logger;
import org.springframework.web.context.ContextLoaderListener;

import com.whitesky.home.common.WebConstants;
import com.whitesky.home.controller.common.ContextUtil;
import com.whitesky.home.service.DeviceLoginService;

public class ContextInit extends ContextLoaderListener {
	
	public final static Logger LOGGER = Logger.getLogger(ContextInit.class);
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);
		LOGGER.info("contextInitialized...");
		deviceLoginService = ContextUtil.getWebApplicationContext().getBean(DeviceLoginService.class);
		deviceInit();
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		super.contextDestroyed(event);
		LOGGER.info("contextDestroyed...");
	}
	
	DeviceLoginService deviceLoginService;
	
	/**
	 * 设备信息初始化
	 * @param event
	 */
	private void deviceInit(){
		LOGGER.info("device initialization started...");
		//复位登录状态
		deviceLoginService.resetStatus();
		LOGGER.info("deviceInitialized...");
	}
}
