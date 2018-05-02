package com.springmvc.controller.user;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.entity.User;
import com.springmvc.service.UserService;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年4月26日 下午4:58:24 
* 类说明  
*/
@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/getAll")
	public String getAll(Model model) throws Exception{
		List<User> userList = userService.list();
		if(null != userList){
			model.addAttribute("userList",userList);
		}
		return "/user/userShow";
	}
	
	@RequestMapping("/getAllJson")
	@ResponseBody
	public List<User> getAllJson(Model model) throws Exception{
		System.out.println(userService.list());
		return userService.list();
	}
	
	@RequestMapping("/getOneJson")
	@ResponseBody
	public User getOneJson(@RequestParam(value="id",required=true) long id){
		User user = userService.findOne(id);
		return user;
	}
	
	@RequestMapping("/addUserJsonParam")
	@ResponseBody
	public User addUserJson(@RequestParam(value="username",required=true) String username,
			@RequestParam(value="phone",required=true) String phone,
			@RequestParam(value="salary",required=true) Double salary,
			@RequestParam(value="age",required=true) Integer age,
			@RequestParam(value="hight",required=true) Float hight,
			@RequestParam(value="birthday",required=true) Date birthday){
		User user = new User();
		user.setUsername(username);
		user.setPhone(phone);
		user.setSalary(salary);
		user.setAge(age);
		user.setHight(hight);
		user.setBirthday(birthday);
		userService.addUser(user);
		return user;
	}
	
	/*@RequestMapping(value="/addUserJsonBody",method=RequestMethod.POST)
	@ResponseBody
	public String addUserJson(@RequestBody Map<String, Object> params){
		for(Entry<String, Object> entry:params.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
		return "----------";
	}*/
	
	@RequestMapping(value="/addUserJsonBody",method=RequestMethod.POST)
	@ResponseBody
	public User addUserJson(@RequestBody User user){
       if(null != user){
    	   userService.addUser(user); 
       }
		return user;
	}
	
	@RequestMapping("/getOne")
	public String getOne(long id,Model model){
		User user = userService.findOne(id);
		if(null != user){
			model.addAttribute("userInfo", user);
		}
		System.out.println(user);
		return "/user/userShow";
	}
	
	@RequestMapping("/updateUser")
	public String updateUser(@Valid User user,BindingResult errorResult,Map<String, Object> returnMap){
		String resultUrl = "";
		Map<String, Object> errorMap = new HashMap<String, Object>();
		int errorCount = errorResult.getErrorCount();
		if(errorCount > 0){
			FieldError usernameMsg = errorResult.getFieldError("username");
			FieldError salaryMsg = errorResult.getFieldError("salary");
			FieldError phoneMsg = errorResult.getFieldError("phone");
			FieldError birthdayMsg = errorResult.getFieldError("birthday");
			FieldError ageMsg = errorResult.getFieldError("age");
			FieldError hightMsg = errorResult.getFieldError("hight");
			
			if (null != usernameMsg){
				errorMap.put("usernameMsg",usernameMsg.getDefaultMessage());
			}
			if (null != salaryMsg){
				errorMap.put("salaryMsg",salaryMsg.getDefaultMessage());
			}
			if (null != phoneMsg){
				errorMap.put("phoneMsg",phoneMsg.getDefaultMessage());
			}
			if (null != birthdayMsg){
				errorMap.put("birthdayMsg",birthdayMsg.getDefaultMessage());
			}
			if (null != ageMsg){
				errorMap.put("ageMsg",ageMsg.getDefaultMessage());
			}
			if (null != hightMsg){
				errorMap.put("hightMsg",hightMsg.getDefaultMessage());
			}
			returnMap.put("errorMsgList", errorMap);
			returnMap.put("userInfo", user);
			resultUrl = "/user/userUpdate";
		}else{
			userService.updateUser(user);
			resultUrl = "redirect:/user/getAll";
		}
		return resultUrl;
	}
	
	
	@RequestMapping("/removeUser")
	public String removeUser(long id){
		userService.removeUser(id);
		return "redirect:/user/getAll";
	}
	
	@RequestMapping("/toAddUser")
	public String toAddUser(){
		return "/user/userAdd";
	}
	
	
	@RequestMapping("/toAddUserJson")
	public String toAddUserJson(){
		return "/user/userAddJson";
	}
	
	@RequestMapping("/addUser")
	public String addUser(@Valid User user,BindingResult errorResult,Map<String, Object> returnMap){
		String resultUrl = "";
		Map<String, Object> errorMap = new HashMap<String, Object>();
		int errorCount = errorResult.getErrorCount();
		if(errorCount > 0){
			FieldError usernameMsg = errorResult.getFieldError("username");
			FieldError salaryMsg = errorResult.getFieldError("salary");
			FieldError phoneMsg = errorResult.getFieldError("phone");
			FieldError birthdayMsg = errorResult.getFieldError("birthday");
			FieldError ageMsg = errorResult.getFieldError("age");
			FieldError hightMsg = errorResult.getFieldError("hight");
			
			if (null != usernameMsg){
				errorMap.put("usernameMsg",usernameMsg.getDefaultMessage());
			}
			if (null != salaryMsg){
				errorMap.put("salaryMsg",salaryMsg.getDefaultMessage());
			}
			if (null != phoneMsg){
				errorMap.put("phoneMsg",phoneMsg.getDefaultMessage());
			}
			if (null != birthdayMsg){
				errorMap.put("birthdayMsg",birthdayMsg.getDefaultMessage());
			}
			if (null != ageMsg){
				errorMap.put("ageMsg",ageMsg.getDefaultMessage());
			}
			if (null != hightMsg){
				errorMap.put("hightMsg",hightMsg.getDefaultMessage());
			}
			
			returnMap.put("errorMsgList", errorMap);
			returnMap.put("userInfo", user);
			resultUrl = "/user/userAdd";
		}else{
			userService.addUser(user);
			resultUrl = "redirect:/user/getAll";
		}
		return resultUrl;
	}
	
	@RequestMapping("/toUserAccount")
	public String toUserAccount(){
		return "/user/userAccount";
	}
	
	@RequestMapping("/userAccount")
	public String userAccount(long addId, long lessId,double money){
		userService.userAccount(money, addId, lessId);
		return "redirect:/user/getAll";
	}
}
 