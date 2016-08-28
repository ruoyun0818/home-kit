package com.whitesky.home.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whitesky.home.model.UserInfo;
import com.whitesky.home.service.UserInfoService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserInfoService userInfoService;
	
	@RequestMapping("/showInfo/{userId}")
	public String showUserInfo(ModelMap modelMap, @PathVariable int userId){
		UserInfo userInfo = userInfoService.getModelById(userId);
		modelMap.addAttribute("userInfo", userInfo);
		return "/user/showInfo";
	}
	
	@RequestMapping("/showInfos")
	public @ResponseBody Object showUserInfos(){
		List<UserInfo> userInfos = userInfoService.getModelList();
		return userInfos;
	}
}
