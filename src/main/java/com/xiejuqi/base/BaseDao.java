package com.xiejuqi.base;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.xiejuqi.comm.Page;
import com.xiejuqi.comm.PagingCriteria;

/**
 * 
 * @Filename BaseDao.java
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
 * @Date: 2016年2月23日 上午10:43:57
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public abstract class BaseDao extends SqlSessionDaoSupport {

	protected  Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired  
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){  
        super.setSqlSessionFactory(sqlSessionFactory);  
    }  
	
//	@Autowired
    protected SqlSession    sqlSession;

    public static final int MAX_BATCH_SIZE = 10000;

    /**
     * @param countStatementName
     * @param queryStatementName
     * @param query
     * @return ��ҳ���
     */
    protected Page queryForPagination(String queryStatementName, String countStatementName,
                                      PagingCriteria pagingCriteria) {
    	SqlSession sqlSession =  	this.getSqlSession();
        Integer totalCount = sqlSession.selectOne(countStatementName, pagingCriteria);

        if (totalCount != null && totalCount.intValue() > 0) {
            List items = sqlSession.selectList(queryStatementName, pagingCriteria);

            if (items != null && !items.isEmpty()) {
                return Page.createInstance(items, totalCount, pagingCriteria);
            }
        }

        return Page.emptyPage();
    }

/*    *//**
     * <pre>
     * ����Mapper���磺
     * 
     *   BlogMapper mapper = session.getMapper(BlogMapper.class); 
     *   Blog blog = mapper.selectBlog(101);
     * </pre>
     * 
     * @param clazz
     * @return
     *//*
    protected <T> T getMapper(Class<T> clazz) {
        return sqlSession.getMapper(clazz);
    }*/
}
