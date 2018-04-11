package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.bean.User;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年4月11日 下午7:13:03 
* 类说明 
*/

//若一个普通类添加@Controller注解，则这个类变为一个servlet
@Controller
@RequestMapping("/hello")
public class HelloController {

	//为当前方法配置一个对外访问的虚拟路径
	@RequestMapping("/sayHello")
	public String Hello(User user){
		System.out.println("Hello SpringMVC..."+user);
		return "/page/jsp/index";
	}
}
 