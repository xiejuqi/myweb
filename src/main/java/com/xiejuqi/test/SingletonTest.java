package com.xiejuqi.test;
/**
 * 
 * @Filename SingletonTest.java
 * 
 * @Description	经过优化的单例模式，保证1个实例只创建1次
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年3月17日 下午6:14:56
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class SingletonTest  
{  
	
    private SingletonTest(){}  
   
    private static class Inner{   //私有的静态内部类    
        static SingletonTest singletonTest = new SingletonTest();  
    }  
   
    public static SingletonTest getInstance(){  
        return Inner.singletonTest;  
    }  
    
    public static void main(String[] args) {
    	
	}
}
