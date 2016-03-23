package com.xiejuqi.designmode.proxymode;
/**
 * 
 * @Filename ProxyTest.java
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
 * @Date: 2015年12月18日 下午12:09:47
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class ProxyTest {
	public static void main(String[] args) {  
        Sourceable source = new Proxy();  
        source.method();  
	}  
}
