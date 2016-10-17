package com.whitesky.home.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.whitesky.home.common.WebConstants;
import com.whitesky.home.controller.common.interceptor.LoginInterceptor;
import com.whitesky.home.service.DeviceService;

@Controller
public class LoginController {
	
	@Autowired
	DeviceService deviceService;
	
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
		return "/login";
	}
	
	/**
	 * 注销
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request){
		request.getSession().invalidate();
		request.getSession(true).setAttribute(WebConstants.SESSION_NO_LOGIN, "已注销");
		return "/login";
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
		
		return "redirect:/console";
	}
}
