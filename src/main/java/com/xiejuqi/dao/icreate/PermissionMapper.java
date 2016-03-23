package com.xiejuqi.dao.icreate;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xiejuqi.domain.Permission;
import com.xiejuqi.domain.Resource;
import com.xiejuqi.domain.TmsUser;

/**
 * 
 * @Filename PermissionMapper.java
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
 * @Date: 2016年1月4日 下午12:05:48
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public interface PermissionMapper {
	Permission findPermissionById (Integer permissionid);
	
	/**
	 * 根据ID获取属性菜单
	 * 此处的入参可以加上参数 @Param("user"),并且可以为多个参数。
	 * 详情看：http://blog.csdn.net/liaoxiaohua1981/article/details/6862764 
	 * @param tmsUser
	 * @return
	 */
	List<Resource> findPermissionByUserId(TmsUser tmsUser);
}
