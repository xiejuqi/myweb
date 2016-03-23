package com.xiejuqi.test;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xiejuqi.base.BaseLogger;

/**
 * 
 * @Filename TestConfig.java
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
 * @Date: 2015年12月31日 下午4:59:41
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class TestConfig extends BaseLogger{
	
	public void test(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		System.out.println(new Date().getTime());
		String fileName = "班级表格";
		System.out.println(fileName);
		fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
		System.out.println("fileName:"+fileName);
		System.out.println(new String(fileName.getBytes(),"iso-8859-1"));
		
		
		String credentialsType = "2";
		if(null != credentialsType && credentialsType.length() != 0){
			switch (Integer.parseInt(credentialsType)) {
			case 1:
				credentialsType="京籍身份证";
				break;
			case 2:
				credentialsType="驻京军人证";
				break;
			case 3:
				credentialsType="驻京军人证";
				break;
			case 4:
				credentialsType="京籍身份证";
				break;
			default:
				credentialsType="证件类型非法！";
				break;
			}
		}
		System.out.println("credentialsType:"+credentialsType);
	}
	
}
