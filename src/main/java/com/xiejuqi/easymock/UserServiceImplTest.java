package com.xiejuqi.easymock;

import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.Test;

/**
 * 
 * @Filename UserServiceImplTest.java
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
 * @Date: 2015年12月30日 下午2:40:51
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class UserServiceImplTest {

	@Test
	public void test() {
		User expectedUser = new User("1001", "user-1001", 30);
		UserDao userDao = EasyMock.createMock(UserDao.class);
		EasyMock.expect(userDao.getById("1001")).andReturn(expectedUser);
		EasyMock.replay(userDao);

		UserServiceImpl service = new UserServiceImpl();
		service.setUserDao(userDao);
		User user = service.query("1001");
		assertNotNull(user);
		assertEquals("1001", user.getId());
		assertEquals(30, user.getAge());
		assertEquals("user-1001", user.getName());

		EasyMock.verify(userDao);
	}

}
