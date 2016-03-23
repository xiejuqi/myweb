package com.xiejuqi.dao.icreate;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.xiejuqi.domain.User;
import com.xiejuqi.domain.UserExample;
import com.xiejuqi.domain.UserExample.Criteria;

/**
 * 
 * @Filename UserDao.java
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
 * @Date: 2015��11��30�� ����3:22:19
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer userId);

    int updateByExampleSelective( User record,  UserExample example);

    int updateByExample( User record,  UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
}
