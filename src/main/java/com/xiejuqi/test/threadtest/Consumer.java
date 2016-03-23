package com.xiejuqi.test.threadtest;

/**
 * 
 * @Filename Consumer.java
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
 * @Date: 2016年3月4日 上午9:42:02
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class Consumer implements Runnable {

	private QueueBuffer q;

	Consumer(QueueBuffer q) {
		this.q = q;
		new Thread(this, "Consumer").start();
	}

	public void run() {
		while (true) {
			q.get();
		}
	}

	public static void main(String[] args) {
		QueueBuffer q = new QueueBuffer();
		new Producer(q);
		new Consumer(q);
		System.out.println("Press Control-C to stop.");
	}

}
