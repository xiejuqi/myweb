package com.xiejuqi.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.xiejuqi.domain.Student;
import com.xiejuqi.domain.User;

/**
 * 
 * @Filename HighchartsController.java
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
 * @Date: 2016年3月2日 下午3:28:56
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
@Controller
public class HighchartsController {
	/**
	 * 展示柱状图页面
	 * @param code
	 * @param callback
	 * @return
	 */
	@RequestMapping(value="/displayHistogram.html")
	public String displayHistogram(String code,String callback){
		
		return "histogram";
	}
	
	/**
	 * 返回柱状图所需要的Json数据
	 * @return
	 */
	@RequestMapping(value="/getJsonString.html")
	@ResponseBody
	public String getJsonString(){
		return getJsonData();
	}
	
	

	private String getJsonData() {
		List<Student> list = new ArrayList<Student>();
		
		Student s1 = new Student();
		s1.setName("冯毅林");
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(78);
		l1.add(28);
		l1.add(668);
		
		s1.setData(l1);
		
		list.add(s1);
		
		Student s2 = new Student();
		s2.setName("屈浩");
		List<Integer> l2 = new ArrayList<Integer>();
		l2.add(15);
		l2.add(34);
		l2.add(78);
		
		s2.setData(l2);
		
		list.add(s2);
		
		Student s3 = new Student();
		s3.setName("武波");
		List<Integer> l3 = new ArrayList<Integer>();
		l3.add(154);
		l3.add(44);
		l3.add(328);
		s3.setData(l3);
		
		list.add(s3);
		
		Gson gson = new Gson();
		
		return gson.toJson(list);
	}
}
