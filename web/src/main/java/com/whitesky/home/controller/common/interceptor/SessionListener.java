package com.whitesky.home.controller.common.interceptor;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.whitesky.home.controller.common.GlobalManager;

public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		GlobalManager.logOut(se.getSession());
	}

}
