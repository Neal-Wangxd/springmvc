package com.springmvc.controller.hello;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
		return "/index";
	}
	
	//为当前方法配置一个对外访问的虚拟路径
	@RequestMapping("/helloJson")
	@ResponseBody
	public String HelloJson(@RequestParam(name="name",defaultValue="abc",required=true)String user){
		System.out.println("Hello SpringMVC..."+user);
		return "Hello SpringMVC..."+user;
	}
	
	//为当前方法配置一个对外访问的虚拟路径
	@RequestMapping("/userJson")
	@ResponseBody
	public User UserJson(){
		User user = new User();
		user.setName("曲蔚然");
		user.setAge(23);
		user.setPhone("12345678");
		user.setHeight(175.2f);
		user.setSalary(15000.00);
		return user;
	}
	
	@RequestMapping("/mapJson")
	@ResponseBody
	public Map<String,Object> mapJson(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("TREK", 18000.00);
		map.put("SPELIZED", 16000.00);
		map.put("GIANT", 10000.00);
		map.put("MERIDA", 8000.00);
		map.put("UCC", 7000.00);
		return map;
	}
	
	@RequestMapping("/listJson")
	@ResponseBody
	public List<String> listJson(){
		List<String> list = new ArrayList<String>();
		list.add("TREK");
		list.add("SPELIZED");
		list.add("GTANT");
		list.add("MERIDA");
		return list;
	}
	
	@RequestMapping("/json")
	@ResponseBody
	public List<Map<String,Object>> json(){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("TREK", 18000.00);
		map.put("SPELIZED", 16000.00);
		map.put("CUBE", 10000.00);
		map.put("BH", 8000.00);
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("GIANT", 10000.00);
		map1.put("MERIDA", 8000.00);
		map1.put("UCC", 7000.00);
		list.add(map);
		list.add(map1);
		return list;
	}
}
 