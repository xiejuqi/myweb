package com.xiejuqi.web;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/security")
public class SecurityController {
	


	@RequestMapping(value = "/login-process")
	public String loginProcess(@RequestParam("username") String username, @RequestParam("password") String password) {
		
		UsernamePasswordToken upt = new UsernamePasswordToken(username, password);
		Subject subject = SecurityUtils.getSubject();
		
		
		subject.login(upt);
		
		return "redirect:/home";
	}

}
