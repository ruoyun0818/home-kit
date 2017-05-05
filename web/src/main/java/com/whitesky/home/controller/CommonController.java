package com.whitesky.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.whitesky.home.controller.common.BaseController;

@Controller
public class CommonController extends BaseController {
	
	/**
	 * 资源id文件读取
	 * @param resId
	 * @param thumb
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/res/{resId:[^\\.]*}")
	public String photoRes(@PathVariable String resId, @RequestParam(required=false) String thumb) throws Exception {
		logger.info("res: {}", resId);
		return "redirect:/res/123.gif";
	}
}
