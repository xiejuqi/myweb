package com.xiejuqi.domain;

/**
 * 
 * @Filename Note.java
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
 * @Date: 2016年1月25日 下午4:04:29
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class Note {
	private String title;
	private String description;

	public Note(String title, String description) {
		this.title = title;
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}
}
