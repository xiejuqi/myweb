package com.xiejuqi.oscache;
/**
 * 
 * @Filename News.java
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
 * @Date: 2015年12月4日 下午3:31:29
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class News {
	 private String id;
	 private String title;
	 private String content;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public News(String id, String title, String content) {
		  super();
		  this.id = id;
		  this.title = title;
		  this.content = content;
		 }
}
