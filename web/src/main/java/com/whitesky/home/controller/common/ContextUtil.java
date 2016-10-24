package com.whitesky.home.controller.common;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.whitesky.home.model.DeviceLogin;
import com.whitesky.home.service.DeviceLoginService;

public class ContextUtil {
	
	public static final Logger logger = Logger.getLogger(ContextUtil.class);
	
	@Autowired
	public static DeviceLoginService deviceLoginService;
	
	protected static Map<String, DeviceLogin> ipRegisterMap = Collections.synchronizedMap(new HashMap<String, DeviceLogin>());
	
	public static WebApplicationContext getWebApplicationContext(){
		return ContextLoader.getCurrentWebApplicationContext();
	}

	public static ServletContext getServletContext() {
		WebApplicationContext webApplicationContext = getWebApplicationContext();
		ServletContext servletContext = webApplicationContext.getServletContext();
		return servletContext;
	}
	
	/**
	 * 设备信息初始化
	 * @param event
	 */
	public static void deviceInit(){
		logger.info("device initialization started...");
		//复位登录状态
		//deviceLoginService.resetStatus();
		for (int i = 0; i < 10; i++) {
			DeviceLogin login = new DeviceLogin();
			login.setIpAddr("192.168.1.10"+i);
			login.setRegisterTime(new Timestamp(System.currentTimeMillis()));
			login.setStatus(1);
			login.setDeviceId("test"+i);
			login.setRegisterCode("test"+i);
			ipRegisterMap.put(login.getIpAddr(), login);
		}
		logger.info("deviceInitialized...");
	}
	
	/**
	 * ip是否有登录设备
	 * @param ip
	 * @return
	 */
	public static boolean isDeviceRegister(String ip){
		return ipRegisterMap.containsKey(ip);
	}
	
	public static synchronized String loginDevice(String ip, String password){
		DeviceLogin deviceLogin = ipRegisterMap.get(ip);
		if(deviceLogin.getRegisterCode().equals(password)){
			logger.info(String.format("%s[%s] login started...", deviceLogin.getDeviceId(), ip));
			ipRegisterMap.remove(ip);
			//更新数据
			refreshDevice();
			logger.info(String.format("%s[%s] logined...", deviceLogin.getDeviceId(), ip));
			return null;
		}else{
			return "注册码错误!";
		}
	}
	
	public static synchronized void loginOut(String ip){
		
	}
	
	/**
	 * 刷新设备信息
	 */
	public static synchronized void refreshDevice(){
		logger.info("refreshDevice started...");
//		List<DeviceLogin> list = deviceLoginService.queryRegisterList();
//		ipRegisterMap.clear();
//		if(list != null){
//			for (DeviceLogin deviceLogin : list) {
//				ipRegisterMap.put(deviceLogin.getIpAddr(), deviceLogin);
//			}
//		}
//		logger.info(String.format("refreshDevice total [%d]...", list.size()));
	}
	
	/**
	 * 清除超过10分钟未登录的超时设备 间隔时间5分钟一次查询
	 */
	@Scheduled(fixedRate = 5 * 60 * 1000)
	public void overdueLoginClear() {
		logger.info("overdueLoginClear started...");
//		int num = deviceLoginService.clearOverdueLogin();
//		logger.info(String.format("overdueLoginCleared total [%d]...", num));
	}
}
