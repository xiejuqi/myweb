package com.xiejuqi.service;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.spy.memcached.MemcachedClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiejuqi.base.BaseLogger;
import com.xiejuqi.comm.Page;
import com.xiejuqi.domain.User;
import com.xiejuqi.dao.dao.*;
import com.xiejuqi.form.UserQueryForm;

/**
 * 
 * @Filename UserService.java
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
 * @Date: 2016年2月16日 上午11:43:24
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
@Service
public class UserService extends BaseLogger{
	
	@Autowired UserDao userDao;
	
	private boolean flag = true;
	
	public  User findUserById(int userId){
		return userDao.findUserById(userId);
	}
	
	
	public User findUserByName(String userName) throws Exception{
		return userDao.findUserByName(userName);
	}
	
	
	/**
	 * 测试Spring的事务回滚机制，需要注意的是：
	 * 1.如果同类之中的A方法调用B方法，B方法发生异常，并且B方法配置事务，这种情况下该事务不会回滚。
	 * 2.使用Spring的事务回滚需要在配置文件中配置启用事务管理器。
	 * 
	 * @throws Exception
	 */
	public void insert() throws Exception{
		try {
			userDao.insertUser();
		} catch (Exception e) {
			logger.info("[CatCh...]");
			throw e;
		}
		
	}
	
	public Page<User> findPageUserByName(UserQueryForm queryForm) throws IOException{
//		MemcachedClient client=new MemcachedClient(new InetSocketAddress("192.168.122.128", 11211));  
		if(this.flag){
			Page<User> list = userDao.findPageUserByName(queryForm);
			//60是超时数，默认以秒为单位  
//	        client.set("test", 60, list);  
	        logger.info("[flag={}]",this.flag);
//	        this.flag = false;
	        logger.info("[这里的数据是从数据库中得到的]");
			return list;
		}else{
			logger.info("[flag={}]",this.flag);
			logger.info("[这里的数据是从Memcached得到的]");
//			return (Page<User>) client.get("test");
			return null;
		}
	}
}
