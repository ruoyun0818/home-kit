package com.whitesky.home.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.whitesky.home.dao.DeviceLoginMapper;
import com.whitesky.home.model.DeviceLogin;
import com.whitesky.home.service.DeviceLoginService;

@Service
public class DeviceLoginServiceImpl extends GenericServiceImpl<DeviceLoginMapper> implements DeviceLoginService {
	
	@Override
	public int clearOverdueLogin() {
		return 0;
	}
	
	@Override
	public List<DeviceLogin> queryRegisterList() {
		return getMapper().queryRegisterList();
	}
	
	@Override
	public void resetStatus() {
	}

	@Override
	public void logOut(String deviceId) {
	}
	
}
