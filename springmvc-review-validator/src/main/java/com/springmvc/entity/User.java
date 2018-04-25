package com.springmvc.entity;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年4月24日 下午4:21:16 
* 类说明   User 实体对象
*/
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@NotNull
	@Size( min = 6, message = "名称至少6个字符")
	private String username;
	
	@NotNull
	@Size( min = 8, message = "名称至少8个字符")
	private String password;
	
	@NotNull
    @Pattern(regexp="^1[3,4,5,6,7,8,9]\\d{9}$",message="手机号码格式不正确")
	private String phone;
	
	@NotNull
	@Pattern(regexp="^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$",message="邮箱格式不正确")
	private String email;
	
	@NotNull
	@Max(value = 130,message="年龄太大")
	@Min(value = 1,message = "年龄太小")
	private Integer age;

	
	public User(){
		
	}
			
	public User(String username, String password, String phone, String email, Integer age) {
		super();
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.age = age;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", phone=" + phone + ", email=" + email + ", age="
				+ age + "]";
	}
	

}
 