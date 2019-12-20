package com.xh.learn.website.webProducts.mq.rabbit;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;

@Component
public class RabbitMsgListener implements ChannelAwareMessageListener {

	@Override
	public void onMessage(Message message, Channel channel) throws Exception {
		byte[] body = message.getBody();
		System.out.println("消费端接收到消息 : " + new String(body));
		channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
	}

}
