/**
 * 
 */
package com.chnjan.activemq.producer;

import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author chenjian
 * @date 2018年11月4日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext.xml"})
public class ProduceSpringTest {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private ActiveMQQueue queue;
	
	@Autowired
	private MessageCreator messageCreator;
	
	//发送消息
	@Test
	public void testProduceMessage() {
		jmsTemplate.send(queue, messageCreator);
	}
}
