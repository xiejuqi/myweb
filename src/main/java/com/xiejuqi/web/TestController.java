package com.xiejuqi.web;

import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@RequiresUser
	@ResponseBody
	@RequestMapping(value = "/home", method = { RequestMethod.GET })
	public String home() {
		return "Hello, Shiro !";
	}

}
