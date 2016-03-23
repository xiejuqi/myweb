package com.xiejuqi.quartz;

import java.util.Date;

import com.xiejuqi.base.BaseLogger;

/**
 * 
 * @Filename SpringQtz.java
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
 * @Date: 2015年12月9日 上午9:49:51
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class SpringQtz  extends BaseLogger{  
    private static int counter = 0;  
    protected void execute()  {  
        long ms = System.currentTimeMillis();  
        logger.info("[现在是：{}]",new Date(ms));
        logger.info("counter={}",counter++);
    }  
} 
