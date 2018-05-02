package com.springmvc.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.springmvc.util.validator.DateFormat;
import com.springmvc.util.validator.Money;


/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年4月26日 下午4:45:03 
* 类说明 
*/
@SuppressWarnings("serial")
public class User implements Serializable {
	
	private Integer id;
	@NotNull
	@Size( min = 2, message = "名称至少2个字符")
	private String username;
	@NotNull
    @Pattern(regexp="^1[3,4,5,6,7,8,9]\\d{9}$",message="手机号码格式不正确")
	private String phone;
	@Money(message="薪资格式不正确")
	private Double salary;
	@NotNull
	@Max(value = 130,message="年龄太大")
	@Min(value = 1,message = "年龄太小")
	private Integer age;
	@Max(value = 250,message="身高太高了")
	@Min(value = 50,message = "身高太小了")
	private Float hight;
	@NotNull
	@DateFormat(message="日期格式不正确 yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date birthday;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Float getHight() {
		return hight;
	}
	public void setHight(Float hight) {
		this.hight = hight;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public User() {
		super();
	}
	public User(Integer id, String username, String phone, Double salary, Integer age, Float hight,Date birthday) {
		super();
		this.id = id;
		this.username = username;
		this.phone = phone;
		this.salary = salary;
		this.age = age;
		this.hight = hight;
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", phone=" + phone + ", salary=" + salary + ", age=" + age
				+ ", hight=" + hight + ", birthday=" + birthday + "]";
	}
	
	
	
}
 