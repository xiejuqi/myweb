package com.xiejuqi.scheduler;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 
 * @Filename ScheduledTaskManager.java
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
 * @Date: 2015年12月23日 下午4:28:06
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
@Component("scheduledTaskManager")  
public class ScheduledTaskManager {  
    /** 
     * cron表达式：* * * * * *（共6位，使用空格隔开，具体如下） 
     * cron表达式：*(秒0-59) *(分钟0-59) *(小时0-23) *(日期1-31) *(月份1-12或是JAN-DEC) *(星期1-7或是SUN-SAT) 
     */  
  
    /** 
     * 定时卡点计算。每天凌晨 02:00 执行一次 
     */  
    @Scheduled(cron = "0 0 2 * * *")  
    public void autoCardCalculate() {  
        System.out.println("定时卡点计算... " + new Date());  
    }  
  
    /** 
     * 心跳更新。启动时执行一次，之后每隔1分钟执行一次 
     */  
    @Scheduled(fixedRate = 1000*60*1)  
    public void heartbeat() {  
        System.out.println("心跳更新... " + new Date());  
    }  
  
    /** 
     * 卡点持久化。启动时执行一次，之后每隔2分钟执行一次 
     */  
    @Scheduled(fixedRate = 1000*60*2)  
    public void persistRecord() {  
        System.out.println("卡点持久化... " + new Date());  
    }  
} 
