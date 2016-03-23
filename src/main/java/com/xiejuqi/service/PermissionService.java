package com.xiejuqi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiejuqi.dao.icreate.PermissionMapper;
import com.xiejuqi.domain.Resource;
import com.xiejuqi.domain.TmsUser;
import com.xiejuqi.domain.Tree;

/**
 * 
 * @Filename PermissionService.java
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
@Service
public class PermissionService {
	
	@Autowired
	private PermissionMapper permissionMapper;
	
	
	public List<Tree> getTreeListById(TmsUser tmsUser) {
		List<Resource> resourceList = permissionMapper.findPermissionByUserId(tmsUser);
		
		Map<Long,Tree> temp = convertResourceListToTreeMap(resourceList);
		
		// 存储顶级菜单
		List<Tree> topTreeList = new ArrayList<Tree>();
		
		// 构造子菜单及顶级菜单
		for (Resource resource : resourceList) {

			Tree tree = temp.get(resource.getSp_id());

			if (resource.getSp_parent_id() > 0) {

				Tree parentTree = temp.get(resource.getSp_parent_id());
				
				parentTree = (null==parentTree)?(new Tree()):parentTree;  //解决空指针报错  
				
					if (parentTree.getChildren() == null) {
						parentTree.setChildren(new ArrayList<Tree>());
					}
					parentTree.getChildren().add(tree);
					parentTree.setState("closed");// 默认关闭

			} else {
				topTreeList.add(tree);
			}
		}
		
		return topTreeList;
	}
	
	
	
	public static Map<Long,Tree> convertResourceListToTreeMap(List<Resource> resourceList) {
		Map<Long,Tree> result = new HashMap<Long,Tree>();
		for (Resource resource : resourceList) {
			Tree tree = new Tree(resource.getSp_id(),
					resource.getSp_parent_id(), resource.getSp_name(), "false",
					resource.getSys_id(), resource.getRank(),
					resource.getHref());
			tree.setState("open");
			result.put(tree.getId(), tree);
		}
		return result;
	}
	
}
