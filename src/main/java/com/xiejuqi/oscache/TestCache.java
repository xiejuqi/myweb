package com.xiejuqi.oscache;
/**
 * 
 * @Filename TestCache.java
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
 * @Date: 2015年12月4日 下午3:32:29
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class TestCache {
	/**
	  * @param args
	  */
	 public static void main(String[] args) {

	  
	  CacheManager cm=CacheManager.getInstance();
	  News n1=new News("1","111","111");
	  cm.putNews(n1);
	  News n1_c=cm.getNews("1");
	  System.out.println("c1:"+n1_c.getContent());
	  
	  News n2=new News("1","111","222");
	  cm.putNews(n2);
	  System.out.println("c1:"+cm.getNews("1").getContent());
	  
	  cm.removeNews("1");
	  
	  System.out.println("c1:"+cm.getNews("1").getContent());
	  
	  BaseCache countCache = new BaseCache("count",1800);
	  
	  countCache.put("1100454", 10);
	  countCache.put("1100455", 11);
	  countCache.put("1100456", 3);
	  
	  try {
	   Integer cachedCount = (Integer)countCache.get("1100454");

	   System.out.println("cachedCount:"+cachedCount);
	  } catch (Exception e) {
	   // TODO Auto-generated catch block
	   e.printStackTrace();
	  }
	 }
}
