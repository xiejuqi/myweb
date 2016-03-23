package com.xiejuqi.mq;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ibm.mq.jms.MQQueueConnectionFactory;
import com.ibm.msg.client.wmq.v6.jms.internal.JMSC;
import com.xiejuqi.base.BaseLogger;

/**
 * 
 * @Filename LocalHostMQTest.java
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
 * @Date: 2015年12月8日 上午9:35:05
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class LocalHostMQTest extends BaseLogger{
	
	public void test(){
//		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//		MQListener receiverLocalhostQueueListener = (MQListener) ac.getBean("receiverLocalhostQueueListener");
		
		  Connection connection = null;  
	        Session session = null;  
	        Destination destination = null;  
	        MessageProducer producer = null;  
	  
	        try {  
	            // Create a connection factory  
	            // objects  
	            MQQueueConnectionFactory factory = new MQQueueConnectionFactory();  
	            factory.setQueueManager("Queue_Send");  
	            factory.setHostName("10.144.32.161");  
	            factory.setTransportType(JMSC.MQJMS_TP_CLIENT_MQ_TCPIP);  
	            factory.setPort(1414);  
	            factory.setChannel("trans");  
	  
	            // Create JMS objects  
	            connection = factory.createConnection();  
	            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);  
	            destination = session.createQueue("WMQ1OutputQ");  
	            producer = session.createProducer(destination);  
	  
	            long uniqueNumber = System.currentTimeMillis() % 1000;  
	            TextMessage message = session  
	                    .createTextMessage("JmsProducer: Your lucky number today is " + uniqueNumber);  
	  
	            // Start the connection  
	            connection.start();  
	  
	            // And, send the message  
	            producer.send(message);  
	            System.out.println("Sent message:\n" + message);  
	  
	        } catch (JMSException jmsex) {  
	            jmsex.fillInStackTrace();  
	        } finally {  
	            try {  
	                producer.close();  
	                session.close();  
	                connection.close();  
	            } catch (JMSException e) {  
	                e.printStackTrace();  
	            }  
	        } 
	}
	
	public static void main(String[] args) {
		LocalHostMQTest hostMQTest = new LocalHostMQTest();
		hostMQTest.test();
	}
}
