package com.xiejuqi.easymock;
/**
 * 
 * @Filename UserServiceImpl.java
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
 * @Date: 2015年12月30日 下午2:30:26
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class UserServiceImpl implements UserService {
	
	 private UserDao userDao; 
     

	public User query(String userId) {
		// TODO Auto-generated method stub
		return userDao.getById(userId);
	}
	
	public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

}
