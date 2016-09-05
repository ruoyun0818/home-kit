package com.whitesky.home.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @title 时间工具类
 * @Description	
 * @author whitesky
 * @date 2016年9月4日
 */
public class DateUtil {
	
	/**
	 * 比较时间间隔自然天数
	 * @param compare 比较日期
	 * @param base 基准日期
	 * @return
	 */
	public static int diffDay(Date compare, Date base){
		if(compare == null || base == null){
			//no compare
			return 0;
		}
		return getDateField(base, Calendar.DAY_OF_YEAR) - getDateField(compare, Calendar.DAY_OF_YEAR); 
	}
	
	/**
	 * 获取时间对应字段值
	 * @param date
	 * @param field java.util.Calendar
	 * @return
	 * @throws NullPointerException
	 */
	public static int getDateField(Date date, int field){
		if(date == null){
			throw new RuntimeException(new NullPointerException("date cannt be null!"));
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(field);
	}
}
