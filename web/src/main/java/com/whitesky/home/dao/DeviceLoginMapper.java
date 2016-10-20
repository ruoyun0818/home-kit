package com.whitesky.home.dao;

import java.sql.Timestamp;
import java.util.List;

import com.whitesky.home.model.DeviceLogin;

public interface DeviceLoginMapper extends BaseMapper<DeviceLogin, Timestamp> {
	public List<DeviceLogin> queryRegisterList();
	
	public int resetStatus();
	
	public int clearOverdueLogin();
}
