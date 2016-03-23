package com.xiejuqi.designmode.proxymode;
/**
 * 
 * @Filename Proxy.java
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
 * @Date: 2015年12月18日 下午12:08:38
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */


/**
 * 其实每个模式名称就表明了该模式的作用，代理模式就是多一个代理类出来，
 * 替原对象进行一些操作，比如我们在租房子的时候回去找中介，为什么呢？
 * 因为你对该地区房屋的信息掌握的不够全面，希望找一个更熟悉的人去帮你做，
 * 此处的代理就是这个意思。再如我们有的时候打官司，我们需要请律师，因为律师在法律方面有专长，可以替我们进行操作，表达我们的想法。
 *  @author xiejuqi
 * */
public class Proxy implements Sourceable {
	
	private Source source;  
	
    public Proxy(){  
        super();  
        this.source = new Source();  
    }  

	public void method() {
		// TODO Auto-generated method stub
		before();  
        source.method();  
        atfer();  
	}
	
	private void atfer() {  
        System.out.println("after proxy!");  
    }  
    private void before() {  
        System.out.println("before proxy!");  
    } 

}

/**
 * 应用场景
 *现实世界中，秘书就相当于一个代理，老板开会，那么通知员工开会时间、布置会场、会后整理会场等
 *等开会相关工作就可以交给秘书做，老板就只需要开会就行了，不需要亲自做那些事。
 *同理，在我们程序设计中也可使用代理模式来将由一系列无关逻辑组合在一起的代码进行解耦合，
 *比如业务代码中的日志代码就可以在代理中进行。Spring的AOP就是典型的动态代理应用。
 * */
