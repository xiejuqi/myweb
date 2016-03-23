package com.xiejuqi.easymock;
/**
 * 
 * @Filename UserDaoImpl.java
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
 * @Date: 2015年12月30日 下午2:37:50
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class UserDaoImpl implements UserDao {

    public User getById(String id) {
        User user = new User("1", "John", 5);
        //execute database query
        return user;
    }
}
