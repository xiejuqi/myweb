package com.xiejuqi.testShiro;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.xiejuqi.dao.icreate.ShiroUserMapper;
import com.xiejuqi.domain.ShiroUser;
import com.xiejuqi.domain.User;
import com.xiejuqi.service.ShiroUserService;
import com.xiejuqi.service.UserService;

/**
 * 
 * @Filename TestConfig.java
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
 * @Date: 2015年12月31日 上午10:22:29
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */

@ContextConfiguration({
	"classpath:applicationContext.xml"
})

public class TestConfig extends AbstractJUnit4SpringContextTests{

	@Autowired
	private ShiroUserService shiroUserService;
	
	@Autowired
	private UserService userService;

	@Test
	public  void test() throws Exception {
		ShiroUser user = shiroUserService.findUserByUsername("yingzhuo");
		System.out.println(user.getRoleSet().iterator().next().getPermissionSet().size());
		
		User uu =  userService.findUserByName("xiejuqi");
		System.out.println(uu.getUserName());
	}

}
