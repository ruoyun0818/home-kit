package com.whitesky.home.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.whitesky.home.common.Constant;
import com.whitesky.home.controller.common.BaseController;
import com.whitesky.home.utils.MultipartFileSender;

@Controller
public class CommonController extends BaseController {
	
	/**
	 * 相册资源类文件获取,支持range
	 * @param res
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/res/photo/{res:.+}")
	public void photoRes(@PathVariable String res, HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("相册资源类文件获取,支持range:"+request.getMethod());
		File file = new File(Constant.getImageResPath() + res);
		try {
			MultipartFileSender.fromFile(file).with(request).with(response).serveResource();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
