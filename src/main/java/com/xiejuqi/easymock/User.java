package com.xiejuqi.easymock;

import com.xiejuqi.base.BaseLogger;

/**
 * 
 * @Filename User.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2015年12月29日 下午3:47:59
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class User extends BaseLogger{
	private String id;
	private String name;
	private int age;
	
	public User(String id,String name, int age) {
		super();
		this.id = id;
		this.name=name;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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
	
	
}
