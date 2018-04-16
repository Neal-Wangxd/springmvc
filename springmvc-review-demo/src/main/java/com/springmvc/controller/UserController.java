package com.springmvc.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.bean.User;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年4月12日 上午10:50:55 
* 类说明 
*/
@Controller
@RequestMapping("/user")
@Scope("prototype")  //scope="singleton"  单实例    scope="prototype"  多实例
public class UserController {
	
	@RequestMapping("/add")
	public String addUser(User user){
		return "/user/userAdd";
	}
	
	@RequestMapping(value="/addUser",method = RequestMethod.POST)
	public String addUserDo(User user){
		System.out.println(user+"------------");
		return null;
	}
	
	
	/**
	 * 
	 * @param username
	 * @param age
	 * @param phone
	 * @param salary
	 * @param height
	 * @return
	 * @RequestParam 设置参数
	 * name 名称要与页面上名称一致
	 * defaultValue 设置默认值
	 * required 设置是否是必填项
	 * 
	 * 默认是转发 forward
	 * 重定向 redirect (需要写全路径)
	 */
	@RequestMapping(value="/addUserPar",method = RequestMethod.POST)
	public String addUserDoPar(@RequestParam(name="name",defaultValue="abc",required=true) String username ,
			Integer age,String phone ,double salary ,float height){
		User user = new User();
		user.setName(username);
		user.setAge(age);
		user.setPhone(phone);
		user.setSalary(salary);
		user.setHeight(height);
		System.out.println(user+"------------");  ///page/user/userAdd
		return username.equals("admin") ? "/index" : "redirect:/page/user/hello.jsp";
	}

}
 