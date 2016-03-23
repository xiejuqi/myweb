package com.xiejuqi.mongodb;

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
	private String firstname;
	private String lastname;
	private int age;
	
	public User(String id, String firstname, String lastname, int age) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
	}
}
