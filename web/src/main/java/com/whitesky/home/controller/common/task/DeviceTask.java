package com.whitesky.home.controller.common.task;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.whitesky.home.common.WebConstants;
import com.whitesky.home.controller.common.ContextUtil;
import com.whitesky.home.service.DeviceLoginService;

@Component
public class DeviceTask {
	
	public static final Logger logger = Logger.getLogger(DeviceTask.class);

	@Autowired
	DeviceLoginService deviceLoginService;

	/**
	 * 清除超过10分钟未登录的超时设备 间隔时间5分钟一次查询
	 */
	@Scheduled(fixedRate = 5 * 60 * 1000)
	public void overdueLoginClear() {
		logger.info("overdueLoginClear started...");
		int num = deviceLoginService.clearOverdueLogin();
		logger.info(String.format("overdueLoginCleared total [%d]...", num));
	}
	
	/**
	 * 刷新设备信息
	 */
	public synchronized void refreshDevice(){
		logger.info("overdueLoginClear started...");
		ContextUtil.getServletContext().setAttribute(WebConstants.CONTEXT_DEVICE_KEY, deviceLoginService.queryRegisterList());
		logger.info(String.format("overdueLoginCleared total [%d]...", 1));
	}
}
