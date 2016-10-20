package com.whitesky.home.service;

import java.util.List;

import com.whitesky.home.dao.DeviceLoginMapper;
import com.whitesky.home.model.DeviceLogin;

public interface DeviceLoginService extends GenericService<DeviceLoginMapper> {
	/**
	 * 复位状态
	 * 清空已登录的状态
	 * 注册时间超过10分钟未登录的状态改变
	 */
	public void resetStatus();
	
	public int clearOverdueLogin();
	
	/**
	 * 查询已经注册的正常状态的IP
	 * @return
	 */
	public List<DeviceLogin> queryRegisterList();
	
	public String register(String deviceId, String ip);
	
	public String login(String ip, String sessionId);
}
