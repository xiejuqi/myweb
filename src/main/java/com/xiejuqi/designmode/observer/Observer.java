package com.xiejuqi.designmode.observer;
/**
 * 
 * @Filename Observer.java
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
 * @Date: 2015年12月24日 上午9:27:16
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public interface Observer {
    /**
     * 更新接口
     * @param state    更新的状态
     */
    public void update(String state);
}