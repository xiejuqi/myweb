package com.xiejuqi.guava;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.Maps;
import com.xiejuqi.base.BaseLogger;

/**
 * 
 * @Filename GuavaDemo.java
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
 * @Date: 2016年1月12日 下午6:24:35
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class GuavaDemo extends BaseLogger{
	public void test(){
		Map<String,Integer> jdkMap = new HashMap<String, Integer>();
		
		Map<String,Integer> guavaMap = Maps.newHashMap();
		
		
	}
	
	public static void main(String[] args) {
		
	}
}
