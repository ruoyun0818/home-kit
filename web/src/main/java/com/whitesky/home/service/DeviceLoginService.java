package com.whitesky.home.service;

import java.util.List;

import com.whitesky.home.dao.DeviceLoginMapper;
import com.whitesky.home.model.DeviceLogin;

public interface DeviceLoginService extends GenericService<DeviceLoginMapper> {
	/**
	 * 复位状态
	 * 清空已登录的状态
	 */
	public void resetStatus();
	
	/**
	 * 注册时间超过10分钟未登录的状态改变
	 * @return
	 */
	public int clearOverdueLogin();
	
	/**
	 * 查询已经注册的正常状态的IP
	 * @return
	 */
	public List<DeviceLogin> queryRegisterList();
	
	/**
	 * 注销
	 * @param deviceId
	 */
	public void logOut(String deviceId);
}
