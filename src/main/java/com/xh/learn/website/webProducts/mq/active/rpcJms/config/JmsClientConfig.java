package com.xh.learn.website.webProducts.mq.active.rpcJms.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.remoting.JmsInvokerProxyFactoryBean;

import com.xh.learn.website.webProducts.mq.active.rpcJms.service.DemoJmsService;

@Configuration
public class JmsClientConfig {

	@Bean
	public JmsInvokerProxyFactoryBean jmsInvokerProxyFactoryBean(ActiveMQConnectionFactory activeMQConnectionFactory) {
		JmsInvokerProxyFactoryBean proxy = new JmsInvokerProxyFactoryBean();
		proxy.setConnectionFactory(activeMQConnectionFactory);
		proxy.setQueueName("BS-RPC-QUEUE");

		proxy.setServiceInterface(DemoJmsService.class);
		return proxy;
	}

}
