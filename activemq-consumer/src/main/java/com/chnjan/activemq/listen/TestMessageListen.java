/**
 * 
 */
package com.chnjan.activemq.listen;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author chenjian
 * @date 2018年11月4日
 * 消息监听
 */
public class TestMessageListen implements MessageListener{

	@Override
	public void onMessage(Message message) {
		//打印消息
		try {
			String msg = ((TextMessage) message).getText();
			System.out.println("接收到消息："+msg);
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	}

}
