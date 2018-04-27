package com.springmvc.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.springmvc.entity.User;
import com.springmvc.mapper.UserMapper;
import com.springmvc.service.UserService;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年4月26日 下午4:49:22 
* 类说明 
*/
@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;
	
	@Override
	public List<User> list() {
		return userMapper.findAll();
	}

	@Override
	public boolean addUser(User user) {
		return userMapper.addUser(user);
	}

	@Override
	public User findOne(long id) {
		return userMapper.findOne(id);
	}

	@Override
	public boolean updateUser(User user) {
		return userMapper.updateUser(user);
	}

	@Override
	public boolean removeUser(long id) {
		return userMapper.removeUser(id);
	}

}
 