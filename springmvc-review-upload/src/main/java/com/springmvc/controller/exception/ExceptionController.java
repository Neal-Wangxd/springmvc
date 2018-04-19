package com.springmvc.controller.exception;

import org.springframework.beans.TypeMismatchException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年4月18日 上午11:03:40 
* 类说明  全局异常处理类
*/
@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(Exception.class)
	public String errorView(Exception ex){
		ex.printStackTrace();
		return "/error/error_500";
	}
	
	
	@ExceptionHandler(TypeMismatchException.class)
	public String errorView(TypeMismatchException ex){
		ex.printStackTrace();
		return "/error/error_400";
	}
}
 