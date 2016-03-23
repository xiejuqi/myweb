package com.xiejuqi.designmode.commonfactory;
/**
 * 
 * @Filename FactoryTest.java
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
 * @Date: 2015年12月18日 上午11:23:35
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class FactoryTest {
	public static void main(String[] args) {
		SendFactory factory = new SendFactory();  
		//普通工厂模式，根据传入的不同类型决定生产不同类型的内容返回给调用者。
        Sender sender = factory.produce("sms");  
        sender.Send(); 
	}
}
