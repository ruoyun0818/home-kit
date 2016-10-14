package com.whitesky.home.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.whitesky.home.env.WebConstants;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("")
	public String index(ModelMap modelMap, HttpSession session){
		modelMap.put("userInfo", session.getAttribute(WebConstants.SESSION_USER));
		return "/user/userInfo";
	}
	
}
