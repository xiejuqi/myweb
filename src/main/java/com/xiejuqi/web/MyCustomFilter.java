package com.xiejuqi.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.xiejuqi.base.BaseLogger;

/**
 * 
 * @Filename MyCustomFilter.java
 * 
 * @Description	过滤器，拦截器，监听器的区别在这里：http://www.cnblogs.com/wycnblogs/archive/2013/03/25/2980566.html
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年3月1日 上午11:11:48
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class MyCustomFilter extends BaseLogger implements Filter{

	public void destroy() {
		logger.info("[---MyCustomFilter.destroy()---]");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		logger.info("[---MyCustomFilter.doFilter()---]");
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("[---MyCustomFilter.init()---]");
		logger.info("encoding={}",filterConfig.getInitParameter("encoding"));
		logger.info("forceEncoding={}",filterConfig.getInitParameter("forceEncoding"));
	}
	
}
