package com.whitesky.home.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whitesky.home.dao.DeviceMapper;
import com.whitesky.home.model.Device;
import com.whitesky.home.service.DeviceService;

@Service("deviceService")
public class DeviceServiceImpl extends GenericServiceImpl<Device>
			implements DeviceService{

	@Autowired
	public DeviceServiceImpl(DeviceMapper deviceMapper) {
		super(deviceMapper);
	}

	@Override
	public Device login(int deviceId, String code) {
		return null;
	}
	
}
