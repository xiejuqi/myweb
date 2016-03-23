package com.xiejuqi.domain;

import com.xiejuqi.base.BaseLogger;

/**
 * 
 * @Filename TmsUser.java
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
 * @Date: 2016年2月23日 上午10:31:15
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class TmsUser extends BaseLogger{
	
	private Integer sysId;
	
	private String account;
	
	private Integer roleId;

	public Integer getSysId() {
		return sysId;
	}

	public void setSysId(Integer sysId) {
		this.sysId = sysId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
}
