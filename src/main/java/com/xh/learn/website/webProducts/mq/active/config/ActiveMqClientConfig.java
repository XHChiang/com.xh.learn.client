package com.xh.learn.website.webProducts.mq.active.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.MessageListenerContainer;

import com.xh.learn.website.webProducts.mq.active.ActiveMqQueueListener;
import com.xh.learn.website.webProducts.mq.active.ActiveMqTopicListener;

@Configuration
public class ActiveMqClientConfig {

	/**
	 * 连接工厂
	 * 
	 * @return
	 */
	@Bean
	public ActiveMQConnectionFactory activeMQConnectionFactory() {
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
		//		activeMQConnectionFactory.setBrokerURL("http://localhost:61616");
		activeMQConnectionFactory.setTrustAllPackages(true);
		return activeMQConnectionFactory;
	}

	/**
	 * 点对点-目的地：队列
	 * 
	 * @return
	 */
	@Bean
	public ActiveMQQueue activeMQQueue() {
		ActiveMQQueue activeMQQueue = new ActiveMQQueue();
		activeMQQueue.setPhysicalName("BS-MQ-QUEUE");
		return activeMQQueue;
	}

	/**
	 * 发布订阅- 目的地：主题
	 * 
	 * @return
	 */
	@Bean
	public ActiveMQTopic activeMQTopic() {
		ActiveMQTopic activeMQTopic = new ActiveMQTopic();
		activeMQTopic.setPhysicalName("BS-MQ-TOPIC");
		return activeMQTopic;
	}

	/**
	 * 消息监听器：队列
	 * 
	 * @param connectionFactory
	 * @param destination
	 * @return
	 */
	@Bean
	public MessageListenerContainer queueListenerContainer1(ActiveMQConnectionFactory connectionFactory,
			ActiveMqQueueListener mqListener) {
		DefaultMessageListenerContainer dmlc = new DefaultMessageListenerContainer();
		dmlc.setConnectionFactory(connectionFactory);
		dmlc.setDestination(activeMQQueue());
		// listener
		dmlc.setMessageListener(mqListener);
		return dmlc;
	}

	/**
	 * 消息监听器: 主题
	 * 
	 * @param connectionFactory
	 * @param destination
	 * @return
	 */
	@Bean
	public MessageListenerContainer topicListenerContainer1(ActiveMQConnectionFactory connectionFactory,
			ActiveMqTopicListener mqListener) {
		DefaultMessageListenerContainer dmlc = new DefaultMessageListenerContainer();
		dmlc.setConnectionFactory(connectionFactory);
		dmlc.setDestination(activeMQTopic());
		// listener
		dmlc.setMessageListener(mqListener);
		return dmlc;
	}

	/**
	 * 消息监听器: 主题
	 * 
	 * @param connectionFactory
	 * @param destination
	 * @return
	 */
	@Bean
	public MessageListenerContainer topicListenerContainer2(ActiveMQConnectionFactory connectionFactory,
			ActiveMqTopicListener mqListener) {
		DefaultMessageListenerContainer dmlc = new DefaultMessageListenerContainer();
		dmlc.setConnectionFactory(connectionFactory);
		dmlc.setDestination(activeMQTopic());
		// listener
		dmlc.setMessageListener(mqListener);
		return dmlc;
	}
}
