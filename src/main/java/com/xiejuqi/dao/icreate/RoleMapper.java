package com.xiejuqi.dao.icreate;

import java.util.List;

import com.xiejuqi.domain.Role;

/**
 * 
 * @Filename RoleMapper.java
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
 * @Date: 2016年1月4日 下午12:04:14
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public interface RoleMapper {
	Role findRoleByRoleId(Integer roleid);
}
