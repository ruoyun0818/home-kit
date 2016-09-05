package com.whitesky.home.service.impl;

import java.util.List;

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

	@Override
	public UserInfo getUserByLogin(String name, String password) {
		UserInfo info = new UserInfo();
		info.setUname(name);
		info.setPassword(password);
		List<UserInfo> list = ((UserInfoMapper) genericMapper).queryList(info);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}
	
}
