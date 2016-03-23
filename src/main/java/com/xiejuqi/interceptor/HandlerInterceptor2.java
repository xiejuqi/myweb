package com.xiejuqi.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 
 * @Filename HandlerInterceptor1.java
 * 
 * @Description	http://jinnianshilongnian.iteye.com/blog/1670856
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年2月19日 下午4:56:34
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */

/**
 * preHandle：预处理回调方法，实现处理器的预处理（如登录检查），第三个参数为响应的处理器（如我们上一章的Controller实现）；
 *              返回值：true表示继续流程（如调用下一个拦截器或处理器）；
 *              false表示流程中断（如登录检查失败），不会继续调用其他的拦截器或处理器，此时我们需要通过response来产生响应；
 * postHandle：后处理回调方法，实现处理器的后处理（但在渲染视图之前），此时我们可以通过modelAndView（模型和视图对象）对模型数据进行处理或对视图进行处理，modelAndView也可能为null。
 * afterCompletion：整个请求处理完毕回调方法，即在视图渲染完毕时回调，如性能监控中我们可以在此记录结束时间并输出消耗时间，还可以进行一些资源清理，类似于try-catch-finally中的finally，
 *                    但仅调用处理器执行链中preHandle返回true的拦截器的afterCompletion。
 * @author xiejuqi
 *
 */
@Component
public class HandlerInterceptor2 extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("[HandlerInterceptor2 preHandle...]");
		
		/*//流程中断的话需要我们进行响应的处理 
		response.getWriter().print("break;");
				
		//返回false表示流程中断   
		return false;*/
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("[HandlerInterceptor2 postHandle...]");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("[HandlerInterceptor2 afterCompletion...]");
	}
	
	
}
