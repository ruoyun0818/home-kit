package com.whitesky.home.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
	
	@ExceptionHandler
	public String exception(Exception e, ModelMap modelMap){
		modelMap.put("error", e);
		return "/error";
	}
	
	
}
