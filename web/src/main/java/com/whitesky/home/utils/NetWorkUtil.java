package com.whitesky.home.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Title: 网络工具包
 * @Description: IP获取...
 * @author whitesky
 * @date 2016年5月10日
 */
public class NetWorkUtil {

	/**
	 * IP正则
	 */
	public static final String IP_REGEX = "(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])";
	
	/**
	 * 获取当前网络地址 (通过访问ip138接口获得)
	 * 
	 * @return
	 */
	public static String getNetIp() {
		String httpUrl = "http://1212.ip138.com/ic.asp";
		String ip = "";
		try {
			StringBuffer html = getHttp(httpUrl);
			Pattern pattern = Pattern.compile(IP_REGEX);
			Matcher matcher = pattern.matcher(html);
			if(matcher.find()){
				ip = matcher.group();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ip;
	}

	/**
	 * 简单的http_get
	 * gb2312
	 * 连接超时1秒
	 * 读取超时1秒
	 * @param httpUrl
	 *            网络地址
	 * @return
	 * @throws IOException
	 */
	public static StringBuffer getHttp(String httpUrl) throws IOException {
		URL url = new URL(httpUrl);
		URLConnection uc = url.openConnection();// 生成连接对象
		uc.setDoOutput(true);
		uc.setConnectTimeout(1000);//连接超时
		uc.setReadTimeout(1000);//读取超时
		uc.connect(); // 发出连接
		String temp;
		StringBuffer sb = new StringBuffer();
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(url.openStream(), "gb2312"));
			while ((temp = in.readLine()) != null) {
				sb.append("\n");
				sb.append(temp);
			} 
		} catch (Exception e) {
			throw e;
		} finally{
			try {
				if(in != null){
					in.close();
				}
			} catch (Exception e2) {
				//ignore
			}
		}
		return sb;
	}
}
