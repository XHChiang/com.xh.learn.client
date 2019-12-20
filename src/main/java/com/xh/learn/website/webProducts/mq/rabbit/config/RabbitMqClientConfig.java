package com.xh.learn.website.webProducts.mq.rabbit.config;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xh.learn.website.webProducts.mq.rabbit.RabbitMsgListener;

@Configuration
public class RabbitMqClientConfig {

	/**
	 * 连接工厂
	 * 
	 * @return
	 */
	@Bean
	public CachingConnectionFactory cachingConnectionFactory() {
		CachingConnectionFactory factory = new CachingConnectionFactory();
		factory.setAddresses("127.0.0.1:5672");
		factory.setUsername("guest");
		factory.setPassword("guest");
		return factory;
	}

	@Bean
	public SimpleMessageListenerContainer messageContainer(RabbitMsgListener rabbitMsgListener) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(cachingConnectionFactory());
		container.setQueueNames("DEFAULT_RABBITMQ_QUEUE");
		container.setExposeListenerChannel(true);
		container.setMaxConcurrentConsumers(1);
		container.setConcurrentConsumers(1);
		container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
		// listener
		container.setMessageListener(rabbitMsgListener);
		return container;
	}
}
