package com.whitesky.home.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.whitesky.home.common.Constant;
import com.whitesky.home.controller.common.BaseController;
import com.whitesky.home.utils.Md5Encrypt;
import com.whitesky.home.utils.StringUtil;

import net.coobird.thumbnailator.Thumbnails;

@Controller
@RequestMapping(value = "/photo", method = RequestMethod.GET)
public class PhotoController extends BaseController {

	@RequestMapping("")
	public String index() {
		return "/photo/photo";
	}

	@RequestMapping(value = "save",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> save(@RequestParam("file") CommonsMultipartFile file) throws IllegalStateException, IOException {
		if (file != null) {
			FileInputStream fis = (FileInputStream)file.getInputStream();
			String md5 = Md5Encrypt.getFileMD5String(fis, file.getSize());
			String prefix = StringUtil.getPrefix(file.getOriginalFilename());
			if(prefix != null){
				md5 += "."+prefix;
			}
			File realFile = new File(Constant.getImageResPath()+md5);
			if(!realFile.exists()){
				file.transferTo(realFile);
				Thumbnails.of(realFile).size(213, 160).toFile(Constant.getImageResPath()+"thumb/"+md5);
			}
		}
		return new HashMap<String, Object>();
	}

}
