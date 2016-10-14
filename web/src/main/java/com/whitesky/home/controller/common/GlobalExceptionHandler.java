package com.whitesky.home.controller.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler
	public ModelAndView globalException(Exception e){
		ModelAndView view = new ModelAndView("/error");
		view.addObject("title", "系统发生错误");
		view.addObject("message", e.getLocalizedMessage());
		return view;
	}
	
	
}
