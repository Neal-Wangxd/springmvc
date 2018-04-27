package com.springmvc.service;

import java.util.List;

import com.springmvc.entity.User;


/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年4月26日 下午4:47:54 
* 类说明 
*/
public interface UserService {
	
	public List<User> list();
	
	public boolean addUser(User user);

	public User findOne(long id);
	
	public boolean updateUser(User user);
	
	public boolean removeUser(long id);
}
 