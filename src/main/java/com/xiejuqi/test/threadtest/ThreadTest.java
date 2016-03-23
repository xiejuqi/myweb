package com.xiejuqi.test.threadtest;

/**
 * 
 * @Filename ThreadTest.java
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
 * @Date: 2016年1月27日 上午9:50:06
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */

/**
 * @author xiejuqi 
 * 
 * http://www.cnblogs.com/mengdd/archive/2013/02/16/2913806.html
 * 
 * 1.是否在execute()方法前加上synchronized关键字，这个例子程序的执行结果会有很大的不同。
 *   如果不加synchronized关键字，则两个线程同时执行execute()方法，输出是两组并发的。
 *   如果加上synchronized关键字，则会先输出一组0到9，然后再输出下一组，说明两个线程是顺次执行的。
 *   
 * 2.如果一个对象有多个synchronized方法，某一时刻某个线程已经进入到了某个synchronized方法，那么在该方法没有执行完毕前，其他线程是无法访问该对象的任何synchronized方法的。
 *   结论：
 *　 当synchronized关键字修饰一个方法的时候，该方法叫做同步方法。
 *　 Java中的每个对象都有一个锁（lock），或者叫做监视器（monitor），当一个线程访问某个对象的synchronized方法时，将该对象上锁，其他任何线程都无法再去访问该对象的synchronized
 *   方法了（这里是指所有的同步方法，而不仅仅是同一个方法），直到之前的那个线程执行方法完毕后（或者是抛出了异常），才将该对象的锁释放掉，其他线程才有可能再去访问该对象的synchronized方法。
 *　 注意这时候是给对象上锁，如果是不同的对象，则各个对象之间没有限制关系。
 *　 尝试在代码中构造第二个线程对象时传入一个新的Example对象，则两个线程的执行之间没有什么制约关系。
 *
 * 3.当一个synchronized关键字修饰的方法同时又被static修饰，之前说过，非静态的同步方法会将对象上锁，但是静态方法不属于对象，而是属于类，它会将这个方法所在的类的Class对象上锁。
 *   一个类不管生成多少个对象，它们所对应的是同一个Class对象。
 *   所以如果是静态方法的情况（execute()和execute2()都加上static关键字），即便是向两个线程传入不同的Example对象，这两个线程仍然是互相制约的，必须先执行完一个，再执行下一个。
 *   结论：如果某个synchronized方法是static的，那么当线程访问该方法时，它锁的并不是synchronized方法所在的对象，而是synchronized方法所在的类所对应的Class对象。
 *   Java中，无论一个类有多少个对象，这些对象会对应唯一一个Class对象，因此当线程分别访问同一个类的两个对象的两个static，synchronized方法时，它们的执行顺序也是顺序的，
 *   也就是说一个线程先去执行方法，执行完毕后另一个线程才开始。
 *   
 * 4.例子程序4所达到的效果和例子程序2的效果一样，都是使得两个线程的执行顺序进行，而不是并发进行，当一个线程执行时，将object对象锁住，另一个线程就不能执行对应的块。
 *    synchronized方法实际上等同于用一个synchronized块包住方法中的所有语句，然后在synchronized块的括号中传入this关键字。当然，如果是静态方法，需要锁定的则是class对象。
 *    可能一个方法中只有几行代码会涉及到线程同步问题，所以synchronized块比synchronized方法更加细粒度地控制了多个线程的访问，只有synchronized块中的内容不能同时被多个线程所访问，
 *    方法中的其他语句仍然可以同时被多个线程所访问（包括synchronized块之前的和之后的）。
 *    注意：被synchronized保护的数据应该是私有的。
 *    
 * 结论：synchronized方法是一种粗粒度的并发控制，某一时刻，只能有一个线程执行该synchronized方法；
 * 		  synchronized块则是一种细粒度的并发控制，只会将块中的代码同步，位于方法内、synchronized块之外的其他代码是可以被多个线程同时访问到的。
 */
public class ThreadTest {
	public static void main(String[] args) {
		Example example = new Example();

		Thread t1 = new Thread1(example);
//		Thread t2 = new Thread1(example);
		/**2.*/
		example = new Example();
		Thread t2 = new Thread2(example);

		t1.start();
		t2.start();
	}

}

class Example {
	public synchronized static   void execute(Thread t) {
		for (int i = 0; i < 10; ++i) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Hello: " + i + ":" + t.getName());
		}
	}
	
	/**
	 * (2)将程序改动一下，Example类中再加入一个方法execute2()。
     *   之后再写一个线程类Thread2，Thread2中的run()方法执行的是execute2()。Example类中的两个方法都是被synchronized关键字修饰的。
	 * **/
	public synchronized static   void execute2(Thread t) {
		for (int i = 0; i < 20; ++i) {
			try {
//				Thread.sleep((long) Math.random() * 1000);
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("World: " + i+ ":" + t.getName());
		}
	}
	
	/**
	 * (4) 
	 * */
	/*public void execute2()
    {
        synchronized (object)
        {
            for (int i = 0; i < 20; ++i)
            {
                try
                {
                    Thread.sleep((long) Math.random() * 1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                System.out.println("World: " + i);
            }

        }
    }*/

}

class Thread1 extends Thread {
	private Example example;

	public Thread1(Example example) {
		this.example = example;
	}

	@Override
	public void run() {
		example.execute(this);
	}
}

/**
 * (2)
 * */
class Thread2 extends Thread {
	private Example example;

	public Thread2(Example example) {
		this.example = example;
	}

	@Override
	public void run() {
		example.execute2(this);
	}

}
