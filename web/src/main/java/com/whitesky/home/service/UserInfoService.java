package com.whitesky.home.service;

import com.whitesky.home.model.UserInfo;

public interface UserInfoService extends GenericService<UserInfo> {
	public UserInfo getUserByLogin(String name, String password);
}
