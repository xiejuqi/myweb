package com.xiejuqi.domain;

import java.util.HashSet;
import java.util.Set;

import com.xiejuqi.base.BaseLogger;

/**
 * 
 * @Filename ShiroUser.java
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
 * @Date: 2015年12月31日 上午9:53:38
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class ShiroUser extends BaseLogger {
	private static final long serialVersionUID = -3289647832586158010L;

	private Integer id;
	private String username;
	private String password;
	
	private Set<Role> roleSet = new HashSet<Role>();
	private Integer roleId;
	private String roleName;
	private Integer permissionId;
	private String permisiionName;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoleSet() {
		return roleSet;
	}

	public void setRoleSet(Set<Role> roleSet) {
		this.roleSet = roleSet;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	public String getPermisiionName() {
		return permisiionName;
	}

	public void setPermisiionName(String permisiionName) {
		this.permisiionName = permisiionName;
	}
}
