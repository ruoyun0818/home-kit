package com.whitesky.home.controller.common;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/console", method = RequestMethod.GET)
public class ConsoleController {

	@RequestMapping("")
	public String index(HttpSession session){
		
		return "/common/console";
	}
}
