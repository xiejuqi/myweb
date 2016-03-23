package com.xiejuqi.designmode.observer;
/**
 * 
 * @Filename ConcreteObserver.java
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
 * @Date: 2015年12月24日 上午9:27:39
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class ConcreteObserver implements Observer {
    //观察者的状态
    private String observerState;
    
    public void update(String state) {
        /**
         * 更新观察者的状态，使其与目标的状态保持一致
         */
        observerState = state;
        System.out.println("状态为："+observerState);
    }

}