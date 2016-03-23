package com.xiejuqi.dao.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.RuntimeErrorException;

import org.apache.commons.collections.ListUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.xiejuqi.base.BaseDao;
import com.xiejuqi.comm.Page;
import com.xiejuqi.dao.icreate.UserMapper;
import com.xiejuqi.domain.User;
import com.xiejuqi.domain.UserExample;
import com.xiejuqi.domain.UserExample.Criteria;
import com.xiejuqi.form.UserQueryForm;

/**
 * 
 * @Filename UserDaoImple.java
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
 * @Date: 2015��11��30�� ����3:31:50
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
@Repository
public class UserDao  extends BaseDao {
	
	@Autowired
	private UserMapper mapper;
	
	@Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){  
        super.setSqlSessionFactory(sqlSessionFactory);  
    } 
	
	public User findUserById(int userId){
		UserExample ue = new UserExample();
		ue.createCriteria().andUserIdEqualTo(userId);
		List<User> list = mapper.selectByExample(ue);
		if(list.isEmpty()){
			throw new RuntimeException("User is not exist by this id��");
		}else{
			return list.get(0);
		}
	}
	
	/**
	 * δ��ҳ
	 * @param userName
	 * @return
	 */
	public User findUserByName(String userName){
		Map<String, Object> params = new HashMap<String, Object>();
	    params.put("userName",userName);
		return getSqlSession().selectOne("SELECT-USER-BY-USERNAME", params);
	}
	
	/**
	 * ��ҳ��ѯ
	 * @param userName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Page<User> findPageUserByName(UserQueryForm queryForm){
		
		return queryForPagination("SELECT-USER-PAGE-BY-USERNAME",
                "SELECT-USER-COUNT-BY-USERNAME",
                queryForm);
	}
	
	/**
	 * 插入一个用户
	 * @return
	 */
	public int insertUser(){
		int n = getSqlSession().insert("INSERT-USER");
		return 5/0;
	}
}
