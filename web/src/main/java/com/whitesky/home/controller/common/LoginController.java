package com.whitesky.home.controller.common;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.whitesky.home.controller.interceptor.LoginInterceptor;
import com.whitesky.home.model.UserInfo;
import com.whitesky.home.service.UserInfoService;
import com.whitesky.home.util.Constants;

@Controller
public class LoginController {
	
	@Autowired
	UserInfoService userInfoService;
	
	/**
	 * login page
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("/login")
	public String login(HttpSession session){
		if(LoginInterceptor.isLogin(session)){
			return "redirect:/console";
		}
		return "/common/login";
	}
	
	/**
	 * 注销
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		session.setAttribute(Constants.SESSION_NO_LOGIN, "已注销");
		return "/common/login";
	}
	
	/**
	 * do login
	 * @param modelMap
	 * @return showUserInfo
	 */
	@RequestMapping(value="/doLogin",method=RequestMethod.POST)
	public String doLogin(@RequestParam(value="name",required=true) String name,
			@RequestParam(value="password",required=true) String password,
			HttpSession session){
		if(LoginInterceptor.isLogin(session)){
			return "redirect:/console";
		}
		UserInfo user = userInfoService.getUserByLogin(name, password);
		if(user == null){
			session.setAttribute(Constants.SESSION_NO_LOGIN, "用户名不存在或者密码不正确");
			return "redirect:/login";
		}else{
			session.setAttribute(Constants.SESSION_USER, user);
			return "redirect:/console";
		}
	}
}
