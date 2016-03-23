package com.xiejuqi.oscache;
/**
 * 
 * @Filename CacheManager.java
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
 * @Date: 2015年12月4日 下午3:30:54
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class CacheManager {
	private BaseCache newsCache; 
	 
    
    private static CacheManager instance; 
    private static Object lock = new Object(); 
     
    public CacheManager() { 
        //这个根据配置文件来，初始BaseCache而已; 
        newsCache = new BaseCache("news",1800);      
    } 
     
    public static CacheManager getInstance(){ 
        if (instance == null){ 
            synchronized( lock ){ 
                if (instance == null){ 
                    instance = new CacheManager(); 
                } 
            } 
        } 
        return instance; 
    } 
 
    public void putNews(News news) { 
        // TODO 自动生成方法存根 
        newsCache.put(news.getId(),news); 
    } 
 
    public void removeNews(String newsID) { 
        // TODO 自动生成方法存根 
        newsCache.remove(newsID); 
    } 
 
    public News getNews(String newsID) { 
        // TODO 自动生成方法存根 
        try { 
            return (News) newsCache.get(newsID); 
        } catch (Exception e) { 
            // TODO 自动生成 catch 块 
            System.out.println("getNews>>newsID["+newsID+"]>>"+e.getMessage()); 
           // News news = new News(newsID); 
           
            News news = new News(newsID,"aaa","bbb");
            this.putNews(news); 
            return news; 
        } 
    } 
 
    public void removeAllNews() { 
        // TODO 自动生成方法存根 
        newsCache.removeAll(); 
    }  
}
