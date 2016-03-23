package com.xiejuqi.form;

import com.xiejuqi.comm.PagingCriteria;

/**
 * 
 * @Filename UserQueryForm.java
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
 * @Date: 2016年2月23日 上午10:43:57
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class UserQueryForm extends PagingCriteria {
	private Integer userId;
	private String userName;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
