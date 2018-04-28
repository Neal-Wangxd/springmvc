package com.springmvc.controller.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年4月28日 上午10:01:52 
* 类说明  统一异常处理类
*/
@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(Exception.class)
	public String errorView(Exception ex){
		ex.printStackTrace();
		return "/error/error_500";
	}
}
 