package com.xiejuqi.designmode.commonfactory;
/**
 * 
 * @Filename SendFactory.java
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
 * @Date: 2015年12月18日 上午11:21:58
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class SendFactory {
	public Sender produce(String type) {  
        if ("mail".equals(type)) {  
            return new MailSender();  
        } else if ("sms".equals(type)) {  
            return new SmsSender();  
        } else {  
            System.out.println("请输入正确的类型!");  
            return null;  
        }  
        
        /**可以这样改进，以免类型传错出异常，为多个工厂方法模式*/
/*        public Sender produceMail(){  
            return new MailSender();  
        }  
          
        public Sender produceSms(){  
            return new SmsSender();  
        } */ 
    }  
}
