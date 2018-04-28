package com.springmvc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.entity.User;


/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年4月26日 下午4:53:21 
* 类说明 
*/
@Mapper
public interface UserMapper {
	
	public List<User> findAll();
	
	public User findOne(long id);
	
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean addUser(User user);

	public boolean updateUser(User user);
	
	public boolean removeUser(long id);
	
	public boolean lessMoney(@Param("money")double money,@Param("id")long id);
	
	public boolean addMoney(@Param("money")double money,@Param("id")long id);
}
 