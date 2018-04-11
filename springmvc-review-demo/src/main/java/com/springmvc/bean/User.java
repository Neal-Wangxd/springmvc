package com.springmvc.bean; 
/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年4月11日 下午7:46:29 
* 类说明 
*/
public class User {
	
	private String name;
	private int age;
	private String phone;
	private double salary;
	private float height;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public User(String name, int age, String phone, double salary, float height) {
		super();
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.salary = salary;
		this.height = height;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", phone=" + phone + ", salary=" + salary + ", height=" + height
				+ "]";
	}
	
}
 