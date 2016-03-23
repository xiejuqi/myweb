package com.xiejuqi.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.xiejuqi.domain.Student;

/**
 * 
 * @Filename GetDate.java
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
 * @Date: 2016年2月20日 上午10:23:48
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class GetDate {
	public static void main(String[] args) {
//		System.out.println(new Date().getTime());
		
List<Student> list = new ArrayList<Student>();
		
		Student s1 = new Student();
		s1.setName("张三");
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(78);
		l1.add(28);
		l1.add(668);
		
		s1.setData(l1);
		
		list.add(s1);
		
		Student s2 = new Student();
		s2.setName("李四");
		List<Integer> l2 = new ArrayList<Integer>();
		l2.add(15);
		l2.add(34);
		l2.add(78);
		
		s2.setData(l2);
		
		list.add(s2);
		
		Student s3 = new Student();
		s3.setName("王五");
		List<Integer> l3 = new ArrayList<Integer>();
		l3.add(154);
		l3.add(44);
		l3.add(328);
		s3.setData(l3);
		
		list.add(s3);
		
		Gson gson = new Gson();
		
		System.out.println(gson.toJson(list));
	}
}
