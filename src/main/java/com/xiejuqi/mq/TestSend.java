package com.xiejuqi.mq;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

/**
 * 
 * @Filename TestSend.java
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
 * @Date: 2015年12月8日 下午3:01:55
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class TestSend
{

    /**
     * jms模板，封装链接工厂、队列、消息生产者
     */
    private JmsTemplate jmsTemplate;

    public TestSend()
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        jmsTemplate = (JmsTemplate)ctx.getBean("jmsTemplate");
    }

    /**
     * 发送消息
     * 
     * @param msg消息
     */
    public void showResult(String msg)
    {
        // Text消息
        MessageCreator messageCreator = createTxtMsg(msg);
        jmsTemplate.send("send",messageCreator);
        // Map消息
        messageCreator = createMapMsg(msg);
        jmsTemplate.send("send",messageCreator);
    }

    /**
     * 创建text消息
     * 
     * @param msg 消息
     * @return message
     */
    private MessageCreator createTxtMsg(final String msg)
    {
        return new MessageCreator()
        {

            public Message createMessage(Session session) throws JMSException
            {
                TextMessage textMessage = session.createTextMessage();
                textMessage.setText(msg);
                return textMessage;
            }
        };
    }

    /**
     * 创建map消息
     * 
     * @param msg消息
     * @return message
     */
    private MessageCreator createMapMsg(final String msg)
    {
        return new MessageCreator()
        {

            public Message createMessage(Session session) throws JMSException
            {
                MapMessage mapMessage = session.createMapMessage();
                mapMessage.setString("map", "javax.jms.MapMessage");
                mapMessage.setString("map1", msg);
                return mapMessage;
            }
        };
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        TestSend send = new TestSend();
        send.showResult("start, send!456");
    }

}
