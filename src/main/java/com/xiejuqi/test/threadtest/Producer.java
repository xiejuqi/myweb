package com.xiejuqi.test.threadtest;
/**
 * 
 * @Filename Producer.java
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
 * @Date: 2016年3月4日 上午9:41:36
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class Producer implements Runnable {
    
    private QueueBuffer q;

    Producer(QueueBuffer q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }

    public void run() {
        int i = 0;
        while (true) {
            q.put(i++);
        }
    }

}