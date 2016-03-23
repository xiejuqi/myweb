package com.xiejuqi.service;

import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.stereotype.Service;

/**
 * 
 * @Filename TestService.java
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
 * @Date: 2016年2月3日 上午11:26:55
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
@Service
public class TestService implements SameInterface{

	public void say() {
		System.out.println("[TestService....]");
	}
	
}
