package com.xh.learn.website.webProducts.rpc.rmi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import com.xh.learn.website.webProducts.rpc.rmi.service.IRmiServiceA;
import com.xh.learn.website.webProducts.rpc.rmi.service.IRmiServiceB;

@Configuration
public class RmiClientConfig {

	@Bean
	public RmiProxyFactoryBean irmiserviceA(@Value("${bs.port.rmi}") int rmiPort) {
		RmiProxyFactoryBean factory = new RmiProxyFactoryBean();
		factory.setServiceInterface(IRmiServiceA.class);
		factory.setServiceUrl("rmi://"+"127.0.0.1"+":"+String.valueOf(rmiPort)+"/irmiservicea");
		return factory;
	}

	@Bean
	public RmiProxyFactoryBean irmiserviceB(@Value("${bs.port.rmi}") int rmiPort) {
		RmiProxyFactoryBean factory = new RmiProxyFactoryBean();
		factory.setServiceInterface(IRmiServiceB.class);
		factory.setServiceUrl("rmi://"+"127.0.0.1"+":"+String.valueOf(rmiPort)+"/irmiserviceb");
		return factory;
	}
}
