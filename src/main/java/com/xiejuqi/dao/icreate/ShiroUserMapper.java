package com.xiejuqi.dao.icreate;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xiejuqi.domain.ShiroUser;

/**
 * 
 * @Filename ShiroUserMapper.java
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
 * @Date: 2015年12月31日 上午9:53:03
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public interface ShiroUserMapper {
	List<ShiroUser> findUserByUsername(String username); 
}
