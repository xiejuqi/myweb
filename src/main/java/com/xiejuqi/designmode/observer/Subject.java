package com.xiejuqi.designmode.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Filename Subject.java
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
 * @Date: 2015年12月24日 上午9:25:48
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public abstract class Subject {
	/**
	 * 用来保存注册的观察者对象
	 */
	private List<Observer> list = new ArrayList<Observer>();

	/**
	 * 注册观察者对象
	 * 
	 * @param observer
	 *            观察者对象
	 */
	public void attach(Observer observer) {

		list.add(observer);
		System.out.println("Attached an observer");
	}

	/**
	 * 删除观察者对象
	 * 
	 * @param observer
	 *            观察者对象
	 */
	public void detach(Observer observer) {

		list.remove(observer);
	}

	/**
	 * 通知所有注册的观察者对象
	 */
	public void nodifyObservers(String newState) {

		for (Observer observer : list) {
			observer.update(newState);
		}
	}
}