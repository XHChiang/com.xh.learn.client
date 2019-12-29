package com.xh.learn.website.webProducts.jmx.config;

import java.net.MalformedURLException;

import javax.management.MBeanServerConnection;
import javax.management.ObjectName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jmx.access.MBeanProxyFactoryBean;
import org.springframework.jmx.access.NotificationListenerRegistrar;
import org.springframework.jmx.support.MBeanServerConnectionFactoryBean;

import com.xh.learn.website.webProducts.jmx.IJmx;
import com.xh.learn.website.webProducts.jmx.listener.JMXListener;

/**
 * JMX配置
 */
@Configuration
public class JMXConfig {

	@Autowired
	private JMXListener listener;

	@Bean
	@Primary
	public MBeanServerConnectionFactoryBean connectorServerFactoryBean(@Value("${bs.port.rmi}") int rmiPort)
			throws MalformedURLException {
		String urlformat = "service:jmx:rmi://127.0.0.1/jndi/rmi://127.0.0.1:%s/%s";
		String serviceurl = String.format(urlformat, rmiPort, "BS-SUPER");

		MBeanServerConnectionFactoryBean mscfb = new MBeanServerConnectionFactoryBean();
		mscfb.setServiceUrl(serviceurl);
		return mscfb;
	}

	@Bean
	public MBeanProxyFactoryBean mBeanProxyFactoryBean(MBeanServerConnection mBeanServerConnection) throws Exception {
		MBeanProxyFactoryBean mBeanProxyFactoryBean = new MBeanProxyFactoryBean();

		ObjectName objectName = new ObjectName("BS-SUPER", "name", "JMXService");
		mBeanProxyFactoryBean.setObjectName(objectName);

		mBeanProxyFactoryBean.setProxyInterface(IJmx.class);
		mBeanProxyFactoryBean.setServer(mBeanServerConnection);

		return mBeanProxyFactoryBean;
	}

	@Bean
	public NotificationListenerRegistrar notificationListenerRegistrar(MBeanServerConnection server) {
		NotificationListenerRegistrar registry = new NotificationListenerRegistrar();

		registry.setMappedObjectName("BS-SUPER:name=JMXService");
		registry.setNotificationListener(listener);
		
		registry.setServer(server);
		return registry;
	}
}
