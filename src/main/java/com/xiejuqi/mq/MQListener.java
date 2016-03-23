package com.xiejuqi.mq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xiejuqi.base.BaseLogger;

/**
 * 
 * @Filename MQListener.java
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
 * @Date: 2015年12月7日 下午3:51:58
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */

@Component(value = "receiverLocalhostQueueListener")
public class MQListener extends BaseLogger  implements MessageListener{

	public void onMessage(Message message) {
		String msg = "";
		if (message instanceof TextMessage) {
			try {
				msg = ((TextMessage) message).getText();
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			logger.info("[本地队列中的消息为：msg={}]",msg);
		} else {
			logger.info("[本地队列中的消息不是text类型的消息]",msg);
		}
	}

}
