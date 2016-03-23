package com.xiejuqi.test.threadtest;

import com.xiejuqi.domain.Student;

/**
 * 
 * @Filename ThreadTest3.java
 * 
 * @Description	测试对象的Wait和Notify以及NotifyAll()方法，见http://www.cnblogs.com/techyc/p/3272321.html
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年3月3日 下午2:21:27
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 * 这三个方法，都是Java语言提供的实现线程间阻塞(Blocking)和控制进程内调度(inter-process communication)的底层机制。在解释如何使用前，先说明一下两点：
 * 1. 正如Java内任何对象都能成为锁(Lock)一样，任何对象也都能成为条件队列(Condition queue)。而这个对象里的wait(), notify()和notifyAll()则是这个条件队列的固有(intrinsic)的方法。
 * 2. 一个对象的固有锁和它的固有条件队列是相关的，为了调用对象X内条件队列的方法，你必须获得对象X的锁。这是因为等待状态条件的机制和保证状态连续性的机制是紧密的结合在一起的。
 * 3. 为什么在执行wait, notify时，必须获得该对象的锁？
 * 	    这是因为，如果没有锁，wait和notify有可能会产生竞态条件(Race Condition)。考虑以下生产者和消费者的情景：
 *     1.1生产者检查条件（如缓存满了）-> 1.2生产者必须等待
 *     2.1消费者消费了一个单位的缓存 -> 2.2重新设置了条件（如缓存没满） -> 2.3调用notifyAll()唤醒生产者
 *     我们希望的顺序是： 1.1->1.2->2.1->2.2->2.3
 * 但在多线程情况下，顺序有可能是 1.1->2.1->2.2->2.3->1.2。也就是说，在生产者还没wait之前，消费者就已经notifyAll了，这样的话，生产者会一直等下去。
 * 
 */
public class ThreadTest3 {
	public static void main(String[] args) throws InterruptedException  {
		test2();
	}
	
	/**
	 * (1)如果一个对象执行wait()或者notify()时不获取锁将会抛出java.lang.IllegalMonitorStateException异常
	 * @throws InterruptedException、
	 */
	private static void test1() throws InterruptedException{
		Student student = new Student();
		student.wait();
		student.notify();
	}
	
	/**
	 * (2)如果一个对象执行wait()或者notify()时不获取[对象锁]将会抛出java.lang.IllegalMonitorStateException异常
	 * @throws InterruptedException
	 */
	private static void test2()throws InterruptedException{
		Student s1 = new Student();
		Student s2 = new Student();
		
		synchronized (s1) {
			s2.wait();
			s2.notify();
		}
	}
	
}
