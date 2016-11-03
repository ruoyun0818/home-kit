package com.whitesky.home.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.whitesky.home.common.Constant;
import com.whitesky.home.controller.common.BaseController;

@Controller
public class CommonController extends BaseController {
	@RequestMapping("/res/photo/{img:.+}")
	public String readImg(@PathVariable String img, HttpServletResponse response) throws IOException{
		File realFile = new File(Constant.getImageResPath()+img);
		if(!realFile.exists()){
			return NOT_FOUND;
		}else{
			FileInputStream fis = null;  
	        OutputStream os = null; 
	        try {  
	            fis = new FileInputStream(realFile);  
	            os = response.getOutputStream();  
	            int count = 0;  
	            byte[] buffer = new byte[1024 * 8];  
	            while ((count = fis.read(buffer)) != -1) {  
	                os.write(buffer, 0, count);  
	                os.flush();  
	            }  
	        } catch (Exception e) {  
	        }  
	        try {  
	            fis.close();  
	            os.close();  
	        } catch (IOException e) {  
	        }  
		}
		return null;
	}
}
