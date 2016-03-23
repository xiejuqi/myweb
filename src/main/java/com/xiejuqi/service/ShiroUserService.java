package com.xiejuqi.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiejuqi.dao.icreate.PermissionMapper;
import com.xiejuqi.dao.icreate.RoleMapper;
import com.xiejuqi.dao.icreate.ShiroUserMapper;
import com.xiejuqi.domain.Permission;
import com.xiejuqi.domain.Role;
import com.xiejuqi.domain.ShiroUser;

/**
 * 
 * @Filename ShiroUserService.java
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
 * @Date: 2016年1月4日 上午11:26:59
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
@Service
public class ShiroUserService {
	
	@Autowired
	private ShiroUserMapper shiroUserMapper;
	
	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	private PermissionMapper permissionMapper;
	
	public ShiroUser	findUserByUsername(String username){
		/**使用MyBatis不能使用GroupBY，使用Java代码分组*/
		List<ShiroUser> userList = shiroUserMapper.findUserByUsername(username);
		
		ShiroUser shiroUser = userList.get(0);
		
		if(userList.isEmpty()){
			return new ShiroUser();
		}
		
		Set<Role> roleList = new HashSet<Role>();
		Set<Permission> allPermissionSet = new HashSet<Permission>();
		
		for(ShiroUser s : userList){
			if(!roleList.contains(s.getRoleId())){
				Role role = roleMapper.findRoleByRoleId(s.getRoleId());
				roleList.add(role);
			}
			if(!allPermissionSet.contains(s.getPermissionId())){
				Permission permission = permissionMapper.findPermissionById(s.getPermissionId());
				permission.setRoleId(s.getRoleId());
				allPermissionSet.add(permission);
			}
		}
		
		shiroUser.setRoleSet(roleList);
		
		for(Role r : roleList){
			Set<Permission> permissionList = r.getPermissionSet();
			for(Permission p : allPermissionSet){
				if(r.getId() == p.getRoleId()){
					permissionList.add(p);
				}
			}
		}
		
		return shiroUser;
	}
}
