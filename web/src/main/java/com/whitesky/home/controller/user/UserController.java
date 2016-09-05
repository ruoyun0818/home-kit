package com.whitesky.home.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("")
	public String index(){
		return "/user/userInfo";
	}
	
}
