/**
 * 
 */
package com.chnjan.activemq.producer;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
//import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

/**
 * @author chenjian
 * @date 2018年10月31日
 * 消息产生测试类
 */
public class ProducerTest {

	//queue消息发送测试
	@Test
	public void queueProducerTest() throws JMSException {
		//消息服务器地址
		String brokerUrl = "tcp://127.0.0.1:61616";
		//创建一个连接工厂对象
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(brokerUrl);
		//创建一个connection连接对象
		Connection connection = connectionFactory.createConnection();
		//开启连接
		connection.start();
		//创建会话,参数：true开启事务，第二个参数会忽略；false不使用事务，第二个参数为消息的应答模式,自动应答
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//创建一个消息队列,参数为消息队列的名字
		Queue queue = session.createQueue("test mq query");
		//创建一条文本消息
		TextMessage textMessage = session.createTextMessage("a hello message 3");
		//创建一个消息发送对象
		MessageProducer producer = session.createProducer(queue);
		//发送
		producer.send(textMessage);
		//关闭资源
		producer.close();
		session.close();
		connection.close();
	}
	
	
	//topic消息发送测试
	@Test
	public void topicProducerTest() throws JMSException {
		//消息服务器地址
		String brokerUrl = "tcp://127.0.0.1:61616";
		//创建一个连接工厂对象
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(brokerUrl);
		//创建一个connection连接对象
		Connection connection = connectionFactory.createConnection();
		//开启连接
		connection.start();
		//创建会话,参数：true开启事务，第二个参数会忽略；false不使用事务，第二个参数为消息的应答模式,自动应答
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//创建一个消息topic,参数为消息主题的名字
		Topic topic = session.createTopic("test mq topic");
		//创建一条文本消息
		TextMessage textMessage = session.createTextMessage("a hello topic message1");
		//创建一个消息发送对象
		MessageProducer producer = session.createProducer(topic);
		//设置消息的发送模式，不设置默认就是持久模式
		//producer.setDeliveryMode(DeliveryMode.PERSISTENT);
		//发送
		producer.send(textMessage);
		//关闭资源
		producer.close();
		session.close();
		connection.close();
	}
}
