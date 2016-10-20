package com.whitesky.home.model;

import java.sql.Timestamp;
import com.whitesky.home.common.model.ModelBase;

public class DeviceLogin extends ModelBase {
	private static final long serialVersionUID = -4465107254112906696L;

	private Integer id;
	private String deviceId;
	private String ipAddr;
	private Integer status = 1;//-1复位 -2超时 1注册2登录10注销
	private Timestamp registerTime;
	private Timestamp loginTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Timestamp getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}

	public Timestamp getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}
}
