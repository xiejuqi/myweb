package com.xiejuqi.designmode.adaptermode;
/**
 * 
 * @Filename AdapterTest.java
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
 * @Date: 2015年12月18日 上午11:33:21
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */

/**适配器（变压器）模式：把一个类的接口变换成客户端所期待的另一种接口，
 * 从而使原本因接口原因不匹配而无法一起工作的两个类能够一起工作。
 * 适配类可以根据参数返还一个合适的实例给客户端。   */
public class AdapterTest {
	public static void main(String[] args) {  
        Targetable target = new Adapter();  
        target.method1();  
        target.method2();  
    }  
}
