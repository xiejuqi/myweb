package com.xiejuqi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiejuqi.base.BaseLogger;
import com.xiejuqi.dao.icreate.PermissionMapper;
import com.xiejuqi.domain.TmsUser;
import com.xiejuqi.domain.Tree;
import com.xiejuqi.service.PermissionService;

/**
 * 
 * @Filename EasyUIPageController.java
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

@Controller
public class EasyUIPageController extends BaseLogger {
	
	@Autowired
	private PermissionService permissionService;

	@RequestMapping(value="/displayTree")
	public String displayTree(){
		return "easyUITree";
	}
	
	@RequestMapping(value="getTreeJson.json")
	@ResponseBody
	public List<Tree> userTree(){
		TmsUser tmsUser = new TmsUser();
		tmsUser.setSysId(1);
		List<Tree> treeList = permissionService.getTreeListById(tmsUser);
		return treeList;
	}
	
	
	
	/**
	 * 测试拦截器
	 * @return
	 */
	@RequestMapping(value="/handleRequest.html")
	public String handleRequest(){
		logger.info("[test SpringMVC Interceptor...]");
		return "uploadFile";
	}
	
	
	
	
}
