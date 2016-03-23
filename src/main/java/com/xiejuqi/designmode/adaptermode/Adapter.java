package com.xiejuqi.designmode.adaptermode;
/**
 * 
 * @Filename Adapter.java
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
 * @Date: 2015年12月18日 上午11:32:40
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class Adapter extends Source implements Targetable {

	public void method2() {
		// TODO Auto-generated method stub
		System.out.println("this is the targetable method!");  
	}
	
}
