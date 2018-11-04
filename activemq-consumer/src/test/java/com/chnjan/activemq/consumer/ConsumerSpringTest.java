/**
 * 
 */
package com.chnjan.activemq.consumer;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author chenjian
 * @date 2018年11月4日
 * 整合spring后消息接收测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext.xml"})
public class ConsumerSpringTest {

	//消息监听会随着spring容器启动一直监听，所以只要保证spring容器不关闭就可以接收到发来的消息
	@Test
	public void testConsumerMessage() {
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
