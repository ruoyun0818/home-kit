package com.whitesky.home.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.whitesky.home.common.WebConstant;
import com.whitesky.home.controller.common.BaseController;
import com.whitesky.home.controller.common.GlobalManager;
import com.whitesky.home.controller.common.GlobalResult;
import com.whitesky.home.service.DeviceService;

@Controller
public class LoginController extends BaseController {

	@Autowired
	DeviceService deviceService;

	/**
	 * 登录界面 已经登录直接跳转到控制台
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(LOGIN)
	public String login(HttpServletRequest request) {
		if (GlobalManager.isLogin(request)) {
			return "redirect:/console";
		}
		return LOGIN;
	}

	/**
	 * 登录注销
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		
		/*
		 * 注销流程
		 * 1.注销设备
		 * 2.取消设置登录标识(session ip)
		 * 3.注销成功并提示设备未登录
		 */
		
		GlobalManager.logOut(request.getSession());
		return DEVICE_NO_LOGIN_HTML;
	}

	/**
	 * 登录
	 * @param password 密码
	 * @param request
	 * @return
	 */
	@RequestMapping(value = DOLOGIN, method = RequestMethod.POST)
	public String doLogin(@RequestParam(value = "password", required = true) String password,
			HttpServletRequest request) {
		if (GlobalManager.isLogin(request)) {
			return "redirect:/console";
		}
		
		/*
		 * 登录流程
		 * 1.登录设备,验证密码
		 * 2.设置登录标识(session ip)
		 * 3.登录成功跳转到主页
		 */
		
		GlobalResult result = GlobalManager.loginDevice(request, password);
		if(result.isCorrect()){
			return "redirect:/console";
		}else{
			request.setAttribute(WebConstant.LOGIN_ERROR, result.getResult());
			return LOGIN;
		}
	}
}
