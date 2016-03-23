package com.xiejuqi.web;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.xiejuqi.base.BaseLogger;
import com.xiejuqi.comm.Page;
import com.xiejuqi.dao.icreate.ShiroUserMapper;
import com.xiejuqi.domain.Permission;
import com.xiejuqi.domain.Role;
import com.xiejuqi.domain.ShiroUser;
import com.xiejuqi.domain.User;
import com.xiejuqi.form.UserQueryForm;
import com.xiejuqi.service.ShiroUserService;
import com.xiejuqi.service.UserService;

/**
 * 
 * @Filename InInController.java
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
public class IndexController extends BaseLogger {
	
	@Autowired
	private UserService userService;
	
	@Value("${mq.hostname}")
	private String aa;
	
	@Autowired
	private ShiroUserService shiroUserService;
	
	@RequestMapping(value="/helloJsp.html")
	public String InitJspIndexPage(ModelMap m,UserQueryForm queryForm,HttpServletRequest request) throws Exception{
		/*m.addAttribute("abc", "123");
		User u =	userService.findUserById(1);
		logger.info("[user={}]",u);*/
		
		User uu =  userService.findUserByName("xiejuqi");
		logger.info("[uu={}]",uu);
		logger.info("aa={}",aa);
		
		
		/*ShiroUser shiroUser = shiroUserService.findUserByUsername("yingzhuo");
		System.out.println(shiroUser.getRoleSet().iterator().next().getPermissionSet().size());*/
		
		
		/*for(Role r : shiroUser.getRoleSet()){
			logger.info("[r={}]",r.getName());
			Set<Permission> permissionSet = r.getPermissionSet();
			for(Permission p : permissionSet){
				logger.info("[r里的p={}]",p.getName());
			}
		}
		
		queryForm.setUserName("admin");
		
		Page<User> userList = userService.findPageUserByName(queryForm);
		logger.info("[userList={}]",userList);
		
		m.addAttribute("newsList", userList);*/
		
		return "hello";
	}
	
	public String login(User user){
		Subject subject = SecurityUtils.getSubject();
		return null;
	}
	
	/**
	 * 跨域请求
	 * @param code
	 * @param callback
	 * @return
	 */
	@RequestMapping(value="/crossDomain.html")
	@ResponseBody
	public String crossDomain(String code,String callback){
		
		User u = new User();
		u.setUserName("Jhon");
		u.setPassword("123");
		
		Gson gson = new Gson();
		
		String s = callback+"("+gson.toJson(u)+")";
		
		return s;
	}
}
	
