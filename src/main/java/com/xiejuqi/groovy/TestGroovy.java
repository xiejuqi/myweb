package com.xiejuqi.groovy;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;

/**
 * 
 * @Filename TestGroovy.java
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
 * @Date: 2015年12月25日 上午11:35:05
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class TestGroovy {
	public static void main(String[] args) {
//		String script = " a = (OrderVo.selfPickupFlag == ‘Y’);return a; ";
//		OrderVo orderVo = new OrderVo();
//		orderVo.setSelfPickupFlag("Y");
		Binding binding = new Binding();
//		binding.setVariable("OrderVo", orderVo);
//		GroovyShell shell = new GroovyShell(binding);
//		Boolean value = (Boolean)shell.evaluate(script);
//		System.out.println("value:"+value);
		
		OrderVo orderVo1 = new OrderVo();
		orderVo1.setAsnNum("1");
		
		OrderVo orderVo2 = new OrderVo();
		
		binding.setVariable("OrderVo", orderVo1);
		binding.setVariable("TNTVo", orderVo2);
		
		GroovyShell shell = new GroovyShell(binding);
		System.out.println(orderVo2.getAsnNum());
		System.out.println(orderVo1.getAsnNum());
		
	}
}
