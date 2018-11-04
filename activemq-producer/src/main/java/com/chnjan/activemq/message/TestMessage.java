/**
 * 
 */
package com.chnjan.activemq.message;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

/**
 * @author chenjian
 * @date 2018年11月4日
 * 消息生成类
 */

@Service(value="tmessage")
public class TestMessage implements MessageCreator {

	@Override
	public Message createMessage(Session session) throws JMSException {
		TextMessage textMessage = session.createTextMessage("hello spring mq 1");
		return textMessage;
	}

}
