package com.xiejuqi.mq;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.StreamMessage;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import com.ibm.msg.client.wmq.v6.base.internal.MQC;
import com.ibm.msg.client.wmq.v6.base.internal.MQEnvironment;
import com.xiejuqi.base.BaseLogger;

/**
 * 
 * @Filename TestReceive.java
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
 * @Date: 2015年12月8日 上午10:41:03
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */

/**
 * MQ接收消息
 * @author 88183239
 *
 */
public class TestReceive extends BaseLogger
{
    /**
     * jms模板，封装链接工厂、队列、消息生产者
     */
    private JmsTemplate jmsTemplate;

    public TestReceive()
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        jmsTemplate = (JmsTemplate)ctx.getBean("jmsTemplate");
        MQEnvironment.properties.put(MQC.TRANSPORT_PROPERTY, MQC.TRANSPORT_MQSERIES_CLIENT);
    }

    /**
     * 接收消息
     * 
     * @param msg消息
     */
    public void showResult()
    {
        Message msg = jmsTemplate.receive();
        onMessage(msg);
        msg = jmsTemplate.receive();
        onMessage(msg);
    }

    @SuppressWarnings("unchecked")
    private void onMessage(Message msg)
    {
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
        else if (msg instanceof ObjectMessage)
        {
            ObjectMessage message = (ObjectMessage)msg;
            System.out.println(message.toString());
        }
        else if (msg instanceof MapMessage)
        {
            MapMessage message = (MapMessage)msg;
            try
            {
                Enumeration mapNames = message.getMapNames();
                while (mapNames.hasMoreElements())
                {
                    String data = (String)mapNames.nextElement();
                    System.out.println(data + ":" + message.getString(data));
                }
            }
            catch (JMSException e)
            {
                throw new RuntimeException("JMSException", e);
            }
        }
        else if (msg instanceof BytesMessage)
        {
            BytesMessage message = (BytesMessage)msg;
            try
            {
                System.out.println(message.getStringProperty("JMS_IBM_PutTime"));
            }
            catch (JMSException e)
            {
                throw new RuntimeException("JMSException", e);
            }

        }
        else if (msg instanceof StreamMessage)
        {

        }
        else
        {
            System.out.println(msg);
        }

    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        TestReceive send = new TestReceive();
        send.showResult();
    }

}