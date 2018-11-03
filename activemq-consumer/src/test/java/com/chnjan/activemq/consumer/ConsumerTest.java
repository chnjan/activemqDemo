/**
 * 
 */
package com.chnjan.activemq.consumer;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

/**
 * @author chenjian
 * @date 2018年11月1日
 * 消息消费测试类
 */
public class ConsumerTest {

	//queue消息消费者测试
	@Test
	public void queueConsumerTest() throws JMSException {
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
		//创建一个消息队列,参数为消息队列的名字,名字要和发送时的消息队列名相同
		Queue queue = session.createQueue("test mq query");
		//创建一个消息消费者,参数为指定的队列
		MessageConsumer consumer = session.createConsumer(queue);
		//设置消息监听,参数为匿名内部类
		consumer.setMessageListener(new MessageListener() {
			
			@Override
			public void onMessage(Message message) {
				if (message instanceof TextMessage) {
					TextMessage msg = (TextMessage) message;
					try {
						String textMsg = msg.getText();
						System.out.println("消息内容：");
						System.out.println(textMsg);
					} catch (JMSException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		try {
			//阻塞主线程，保证测试一直处于消息监听状态，输入任意键后执行下面的关闭资源代码
			System.in.read();
			//关闭资源
			consumer.close();
			session.close();
			connection.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//topic消息消费者1测试
	@Test
	public void topicConsumerTest() throws JMSException {
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
		//创建一个消息主题,参数为消息主题的名字,名字要和发送时的消息队列名相同
		Topic topic = session.createTopic("test mq topic");
		//创建一个消息消费者,参数为指定的topic
		MessageConsumer consumer = session.createConsumer(topic);
		//设置消息监听,参数为匿名内部类
		consumer.setMessageListener(new MessageListener() {
			
			@Override
			public void onMessage(Message message) {
				if (message instanceof TextMessage) {
					TextMessage msg = (TextMessage) message;
					try {
						String textMsg = msg.getText();
						System.out.println("消息topic1内容：");
						System.out.println(textMsg);
					} catch (JMSException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		try {
			//阻塞主线程，保证测试一直处于消息监听状态，输入任意键后执行下面的关闭资源代码
			System.in.read();
			//关闭资源
			consumer.close();
			session.close();
			connection.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//topic消息消费者2测试
	@Test
	public void topicConsumerTest2() throws JMSException {
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
		//创建一个消息主题,参数为消息主题的名字,名字要和发送时的消息队列名相同
		Topic topic = session.createTopic("test mq topic");
		//创建一个消息消费者,参数为指定的topic
		MessageConsumer consumer = session.createConsumer(topic);
		//设置消息监听,参数为匿名内部类
		consumer.setMessageListener(new MessageListener() {
			
			@Override
			public void onMessage(Message message) {
				if (message instanceof TextMessage) {
					TextMessage msg = (TextMessage) message;
					try {
						String textMsg = msg.getText();
						System.out.println("消息topic2内容：");
						System.out.println(textMsg);
					} catch (JMSException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		try {
			//阻塞主线程，保证测试一直处于消息监听状态，输入任意键后执行下面的关闭资源代码
			System.in.read();
			//关闭资源
			consumer.close();
			session.close();
			connection.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//topic消息持久订阅消费者测试
	@Test
	public void topicDurableConsumerTest() throws JMSException {
		//消息服务器地址
		String brokerUrl = "tcp://127.0.0.1:61616";
		//创建一个连接工厂对象
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(brokerUrl);
		//创建一个connection连接对象
		Connection connection = connectionFactory.createConnection();
		//持久消费者需要设置订阅者id
		connection.setClientID("001subscriber");
		//开启连接
		connection.start();
		//创建会话,参数：true开启事务，第二个参数会忽略；false不使用事务，第二个参数为消息的应答模式,自动应答
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//创建一个消息主题,参数为消息主题的名字,名字要和发送时的消息队列名相同
		Topic topic = session.createTopic("test mq topic");
		//创建一个消息消费者,参数为指定的topic
		MessageConsumer consumer = //session.createConsumer(topic);
		session.createDurableSubscriber(topic, "001subscriber");
		//设置消息监听,参数为匿名内部类
		consumer.setMessageListener(new MessageListener() {
			
			@Override
			public void onMessage(Message message) {
				if (message instanceof TextMessage) {
					TextMessage msg = (TextMessage) message;
					try {
						String textMsg = msg.getText();
						System.out.println("消息topic 持久订阅内容：");
						System.out.println(textMsg);
					} catch (JMSException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		try {
			//阻塞主线程，保证测试一直处于消息监听状态，输入任意键后执行下面的关闭资源代码
			System.in.read();
			//关闭资源
			consumer.close();
			session.close();
			connection.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
