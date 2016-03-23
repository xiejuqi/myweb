package com.xiejuqi.myenum;
/**
 * 
 * @Filename LightEnumTest.java
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
 * @Date: 2016年3月2日 下午5:47:50
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class LightEnumTest {
	public static void main(String[] args) {
		System.out.println(LightEnum.GREEN);
		System.out.println(LightEnum.YELLOW);
		System.out.println(LightEnum.getName(LightEnum.YELLOW));
		
		System.out.println(16>>3);
	}
}
