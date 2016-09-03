package com.whitesky.home.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whitesky.home.dao.UserInfoMapper;
import com.whitesky.home.model.UserInfo;
import com.whitesky.home.service.UserInfoService;

@Service("userInfoService")
public class UserInfoServiceImpl extends GenericServiceImpl<UserInfo>
			implements UserInfoService{

	@Autowired
	public UserInfoServiceImpl(UserInfoMapper userInfoMapper) {
		super(userInfoMapper);
	}

}
