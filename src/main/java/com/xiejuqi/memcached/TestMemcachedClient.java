package com.xiejuqi.memcached;

import java.net.InetSocketAddress;

import net.spy.memcached.MemcachedClient;



/**
 * 
 * @Filename TestMemcachedClient.java
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
 * @Date: 2015年12月14日 上午10:36:56
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class TestMemcachedClient {
	public static void main(String[] args) throws Exception{  
        
        MemcachedClient client=new MemcachedClient(new InetSocketAddress("192.168.122.128", 11211));  
        //60是超时数，默认以秒为单位  
        client.set("test", 60, "1111测试memcache成功了吧");  
       
          
         System.out.println(client.get("test"));  
          client.shutdown();//关闭连接  
          
          
    }  
}
