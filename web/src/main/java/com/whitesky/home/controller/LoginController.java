package com.whitesky.home.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.whitesky.home.common.WebConstants;
import com.whitesky.home.controller.common.BaseController;
import com.whitesky.home.controller.common.ContextUtil;
import com.whitesky.home.controller.common.RequestUtil;
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
		if (RequestUtil.isLogin(request)) {
			return "redirect:/console";
		}
		return LOGIN;
	}

	/**
	 * 注销
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		request.setAttribute(WebConstants.LOGIN_ERROR, "已注销");
		return LOGIN;
	}

	/**
	 * do login
	 * 
	 * @param modelMap
	 * @return showUserInfo
	 */
	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public String doLogin(@RequestParam(value = "password", required = true) String password,
			HttpServletRequest request) {
		if (RequestUtil.isLogin(request)) {
			return "redirect:/console";
		}
		final String ip = RequestUtil.getIpAddr(request);
		String loginMsg = ContextUtil.loginDevice(ip, password);
		if(loginMsg == null){
			RequestUtil.login(request);
			return "redirect:/console";
		}else{
			request.setAttribute(WebConstants.LOGIN_ERROR, loginMsg);
			return LOGIN;
		}
	}
}
