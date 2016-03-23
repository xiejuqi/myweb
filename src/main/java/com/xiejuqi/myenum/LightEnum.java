package com.xiejuqi.myenum;

import java.util.EnumMap;
import java.util.EnumSet;

/**
 * 
 * @Filename LightEnum.java
 * 
 * @Description	演示枚举类型的使用，相关博客链接：http://blog.csdn.net/wgw335363240/article/details/6359614
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年3月2日 下午5:42:33
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public enum LightEnum {

	// 构造函数传参
	RED(1), GREEN(3), YELLOW(2);

	// 定义私有变量
	private int nCode;

	// 构造函数，枚举类型只能为私有
	private LightEnum(int _nCode) {
		this.nCode = _nCode;
	}

	// 普通方法
	public static Integer getName(LightEnum name) {
		for (LightEnum c : LightEnum.values()) {
			if (c == name) {
				return c.ordinal();
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return String.valueOf(this.nCode);
	}

	public static void main(String[] args) {

		// 1. 遍历枚举类型
		System.out.println(" 演示枚举类型的遍历 ......");
		testTraversalEnum();

		// 2. 演示 EnumMap 对象的使用
		System.out.println(" 演示 EnmuMap 对象的使用和遍历 .....");
		testEnumMap();

		// 3. 演示 EnmuSet 的使用
		System.out.println(" 演示 EnmuSet 对象的使用和遍历 .....");
		testEnumSet();

	}

	/**
	 * 
	 * 演示枚举类型的遍历
	 * 
	 */
	private static void testTraversalEnum() {

		LightEnum[] allLight = LightEnum.values();

		for (LightEnum aLight : allLight) {

			System.out.println(" 当前灯 name ： " + aLight.name());

			System.out.println(" 当前灯 ordinal ： " + aLight.ordinal());

			System.out.println(" 当前灯： " + aLight);

		}
	}

	/**
	 * 
	 * 演示 EnumMap 的使用， EnumMap 跟 HashMap 的使用差不多，只不过 key 要是枚举类型
	 * 
	 */
	private static void testEnumMap() {

		// 1. 演示定义 EnumMap 对象， EnumMap 对象的构造函数需要参数传入 , 默认是 key 的类的类型
		EnumMap<LightEnum, String> currEnumMap = new EnumMap<LightEnum, String>(

				LightEnum.class);

		currEnumMap.put(LightEnum.RED, " 红灯 ");

		currEnumMap.put(LightEnum.GREEN, " 绿灯 ");

		currEnumMap.put(LightEnum.YELLOW, " 黄灯 ");

		// 2. 遍历对象
		for (LightEnum aLight : LightEnum.values()) {
			System.out.println("[key=" + aLight.name() + ",value="
					+ currEnumMap.get(aLight) + "]");
		}

	}
	
	 /**
     * 演示 EnumSet 如何使用， EnumSet 是一个抽象类，获取一个类型的枚举类型内容 <BR/>
     * 可以使用 allOf 方法
     */
   private static void testEnumSet() {
      EnumSet<LightEnum> currEnumSet = EnumSet.allOf (LightEnum.class);

      for (LightEnum aLightSetElement : currEnumSet) {
          System. out .println( " 当前 EnumSet 中数据为： " + aLightSetElement);
      }
      
   } 

}
