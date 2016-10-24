package com.whitesky.home.controller.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@ControllerAdvice
public class GlobalExceptionHandler extends BaseController {
	@ExceptionHandler
	public String globalException(HttpServletRequest request, Exception e){
		return error(request, e.getLocalizedMessage());
	}
}
