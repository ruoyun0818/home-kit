package com.whitesky.home.controller.common;

import org.apache.catalina.connector.ClientAbortException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@ControllerAdvice
public class GlobalExceptionHandler extends BaseController {
	@ExceptionHandler
	public String globalException(Exception e){
		if(e instanceof ClientAbortException){
			return null;
		}
		return error(e.getLocalizedMessage());
	}
}
