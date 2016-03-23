package com.xiejuqi.test.threadtest;
/**
 * 
 * @Filename OutputThread.java
 * 
 * @Description	利用wait()和notify()交替输出1，2
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年3月4日 上午10:09:31
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class OutputThread implements Runnable {

    private int num;
    private Object lock;
    
    public OutputThread(int num, Object lock) {
        super();
        this.num = num;
        this.lock = lock;
    }

    public void run() {
        try {
            while(true){
                synchronized(lock){
                    lock.notifyAll();
                    lock.wait();
                    System.out.println(num);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
    
    public static void main(String[] args){
        final Object lock = new Object();
        
        Thread thread1 = new Thread(new OutputThread(1,lock));
        Thread thread2 = new Thread(new OutputThread(2, lock));
        
        thread1.start();
        thread2.start();
    }

}
