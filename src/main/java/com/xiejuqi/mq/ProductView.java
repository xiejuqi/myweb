package com.xiejuqi.mq;

import java.util.Enumeration;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.StreamMessage;
import javax.jms.TextMessage;

import com.xiejuqi.base.BaseLogger;

/**
 * 
 * @Filename ProductView.java
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
 * @Date: 2015年12月8日 上午11:04:23
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class ProductView extends BaseLogger implements MessageListener
{

    @SuppressWarnings("unchecked")
    public void onMessage(Message msg)
    {
        // text消息
        if (msg instanceof TextMessage)
        {
            TextMessage message = (TextMessage)msg;
            try
            {
                String data = message.getText();
                logger.info("[本地队列中的消息为：msg={}]",data);
            }
            catch (JMSException e)
            {
                throw new RuntimeException("JMSException", e);
            }
        }
        // 对象消息
        else if (msg instanceof ObjectMessage)
        {

        }
        // map消息
        else if (msg instanceof MapMessage)
        {
            MapMessage message = (MapMessage)msg;
            try
            {
                Enumeration mapNames = message.getMapNames();
                while (mapNames.hasMoreElements())
                {
                    String data = (String)mapNames.nextElement();
                    System.out.println(data);
                }
            }
            catch (JMSException e)
            {
                throw new RuntimeException("JMSException", e);
            }
        }
        // bytes消息
        else if (msg instanceof BytesMessage)
        {

        }
        // stream消息
        else if (msg instanceof StreamMessage)
        {

        }
    }

}
