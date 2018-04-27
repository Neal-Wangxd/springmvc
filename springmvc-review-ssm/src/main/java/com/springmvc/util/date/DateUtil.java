package com.springmvc.util.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年4月27日 下午3:11:56 
* 类说明 
*/
public class DateUtil {

	/**
	  * 默认日期格式
	  */
	 private static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

	 /**
	  * 日期格式化
	  * @param date
	  * @param format
	  * @return
	  */
	 public static String DateFormat(Date date,String format){
		 SimpleDateFormat sdf = null;
		 if(null != format && format.length() > 0){
			 sdf = new SimpleDateFormat(format);
		 }else{
			 sdf = new SimpleDateFormat(DEFAULT_FORMAT);
		 }
		 return sdf.format(date);
	 }
	 
	 /**
	  * 字符串转为日期
	  * @param str
	  * @return
	  */
	 public Date strToDate(String str){
		 SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_FORMAT); 
		 Date date = null; 
		 try{ 
			 date = sdf.parse(str); 
		 }catch(ParseException e) { 
		    e.printStackTrace(); 
		 } 
		 return date; 
	 }
	 
	 
	 
	 
	 
}
 