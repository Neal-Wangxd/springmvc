package com.springmvc.controller.validator;



import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.entity.User;


/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年4月24日 下午3:25:23 
* 类说明  数据验证的测试Controller
*/

@Controller
@RequestMapping(value="/validator")
public class ValidatorController {

	@RequestMapping("/toRegister")
	public String registerGo() throws Exception{
		return "/user/register";
	}
	
	@RequestMapping("/doRegister")
	public String  registerDo(@Valid User user,BindingResult errorResult,Map<String, Object> returnMap){
		String resultUrl = "";
		Map<String, Object> errorMap = new HashMap<String, Object>();
		int errorCount = errorResult.getErrorCount();
		if(errorCount > 0){
			FieldError usernameMsg = errorResult.getFieldError("username");
			FieldError passwordMsg = errorResult.getFieldError("password");
			FieldError phoneMsg = errorResult.getFieldError("phone");
			FieldError emailMsg = errorResult.getFieldError("email");
			FieldError ageMsg = errorResult.getFieldError("age");
			
			if (null != usernameMsg){
				errorMap.put("usernameMsg",usernameMsg.getDefaultMessage());
			}
			if (null != passwordMsg){
				errorMap.put("passwordMsg",passwordMsg.getDefaultMessage());
			}
			if (null != phoneMsg){
				errorMap.put("phoneMsg",phoneMsg.getDefaultMessage());
			}
			if (null != emailMsg){
				errorMap.put("emailMsg",emailMsg.getDefaultMessage());
			}
			if (null != ageMsg){
				errorMap.put("ageMsg",ageMsg.getDefaultMessage());
			}
			returnMap.put("errorMsgList", errorMap);
			returnMap.put("userInfo", user);
			resultUrl = "/user/register";
		}else{
			returnMap.put("userInfo", user);
			resultUrl = "/user/userInfo";
		}
		System.out.println(returnMap);
		return resultUrl;
	}
	
	
	
}
 