package com.whitesky.home.controller.common;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.whitesky.home.common.WebConstants;
import com.whitesky.home.model.DeviceLogin;
import com.whitesky.home.service.DeviceLoginService;

/**
 * @Title:
 * @Description: 业务相关管理 
 * @author whitesky
 * @date 2016年10月24日
 */
public class GlobalManager {
	private GlobalManager(){}
	private static final Logger logger = Logger.getLogger(GlobalManager.class);
	protected static final GlobalManager INSTANCE = new GlobalManager();
	@Autowired
	protected static DeviceLoginService deviceLoginService;
	
	/** 当前登录信息 */
	protected static final Map<String, HttpSession> DEVICE_ONLINE_MAP = Collections.synchronizedMap(new HashMap<String, HttpSession>());
	/** 已注册未登录IP设备 */
	protected static final Map<String, DeviceLogin> IP_REGISTER_MAP = Collections.synchronizedMap(new HashMap<String, DeviceLogin>());
	
	public static final GlobalManager getInstance(){
		return INSTANCE;
	}
	
	/**
	 * 设备信息初始化
	 * @param event
	 */
	public static void deviceInit(){
		logger.info("device initialization started...");
		//复位登录状态
		deviceLoginService.resetStatus();
		logger.info("deviceInitialized...");
	}
	
	/**
	 * ip是否有登录设备
	 * @param ip
	 * @return
	 */
	public static boolean isDeviceRegister(String ip){
		return IP_REGISTER_MAP.containsKey(ip);
	}
	
	/**
	 * 登录设备
	 * @param ip
	 * @param password
	 * @return
	 */
	public static synchronized GlobalResult loginDevice(HttpServletRequest request, String password){
		final HttpSession session = request.getSession(true);
		final String ip = GlobalUtil.getIpAddr(request);
		DeviceLogin deviceLogin = IP_REGISTER_MAP.get(ip);
		if(deviceLogin.getRegisterCode().equals(password)){
			logger.info(String.format("%s[%s] login started...", deviceLogin.getDeviceId(), ip));
			
			//TODO 更新deviceLogin状态和登录时间
			
			IP_REGISTER_MAP.remove(ip);
			DEVICE_ONLINE_MAP.put(deviceLogin.getDeviceId(), session);
			session.setAttribute(WebConstants.SESSION_LOGIN_KEY, deviceLogin.getDeviceId());
			logger.info(String.format("%s[%s] logined...", deviceLogin.getDeviceId(), ip));
			return new GlobalResult(true, null);
		}else{
			return new GlobalResult(false, "注册码错误!");
		}
	}
	
	/**
	 * 注销在线设备
	 * @param deviceId 设备ID 
	 */
	public static synchronized void logOut(String deviceId){
		logger.info(String.format("logOut[%s]...", deviceId));
		HttpSession session = DEVICE_ONLINE_MAP.remove(deviceId);
		//TODO 更新deviceLogin状态
		if(session != null){
			logOut(session, false);
		}
	}
	
	/**
	 * 自动注销当前设备
	 * @param session
	 * @param popup 泡泡注销
	 */
	protected static synchronized void logOut(HttpSession session, boolean popup){
		if(popup){
			logger.info(String.format("popup logOut[%s]...", session.getId()));
			logOut(session.getAttribute(WebConstants.SESSION_LOGIN_KEY).toString());
		}else{
			logger.info(String.format("popup logOuted[%s]...", session.getId()));
			session.removeAttribute(WebConstants.SESSION_LOGIN_KEY);
		}
	}
	
	/**
	 * 泡泡注销注销当前设备
	 * @param session
	 */
	public static void logOut(HttpSession session){
		logOut(session, true);
	}
	
	/**
	 * 刷新设备信息
	 */
	@Scheduled(fixedRate = 5 * 60 * 1000)//间隔时间5分钟
	public static synchronized void refreshDevice(){
		logger.info("refreshDevice started...");
		overdueLoginClear();
		List<DeviceLogin> list = deviceLoginService.queryRegisterList();
		//TODO 检查当前登录设备信息
		IP_REGISTER_MAP.clear();
		if(list != null){
			for (DeviceLogin deviceLogin : list) {
				IP_REGISTER_MAP.put(deviceLogin.getIpAddr(), deviceLogin);
			}
		}
		logger.info(String.format("refreshDevice total [%d]...", list.size()));
	}
	
	/**
	 * 清除超过10分钟未登录的超时设备 
	 */
	protected static void overdueLoginClear() {
		logger.info("overdueLoginClear started...");
		int num = deviceLoginService.clearOverdueLogin();
		logger.info(String.format("overdueLoginCleared total [%d]...", num));
	}
	
	/**
	 * 当前是否登录
	 * 
	 * @param request
	 * @return
	 */
	public static boolean isLogin(HttpServletRequest request) {
		Object deviceId = request.getSession().getAttribute(WebConstants.SESSION_LOGIN_KEY);
		return deviceId != null && DEVICE_ONLINE_MAP.containsKey(deviceId);
	}
	
	
}
