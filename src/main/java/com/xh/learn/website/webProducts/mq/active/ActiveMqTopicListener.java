package com.xh.learn.website.webProducts.mq.active;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqTopicListener implements MessageListener {
	private static Logger logger = LoggerFactory.getLogger(ActiveMqTopicListener.class);

	@Override
	public void onMessage(Message message) {
		ActiveMQTextMessage textMessage = (ActiveMQTextMessage) message;
		try {
			String text = textMessage.getText();
			logger.info("\n>>>>>>>>>>>>>>>>>>\ncur topic msg: [" + text + "]\n<<<<<<<<<<<<<<<<<<");
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
