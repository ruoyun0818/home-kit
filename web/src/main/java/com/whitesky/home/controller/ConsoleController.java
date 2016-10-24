package com.whitesky.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.whitesky.home.controller.common.BaseController;

@Controller
@RequestMapping(value = "/console", method = RequestMethod.GET)
public class ConsoleController extends BaseController {

	@RequestMapping("")
	public String index(ModelMap modelMap,
			@RequestParam(value="error", required=false) String error){
		if(error != null && error.length() > 1){
			throw new RuntimeException(new Exception("控制台抛出了一个异常!"));
		}
		return "/console";
	}
}
