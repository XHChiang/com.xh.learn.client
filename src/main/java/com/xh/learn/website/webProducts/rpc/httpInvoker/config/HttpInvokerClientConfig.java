package com.xh.learn.website.webProducts.rpc.httpInvoker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

import com.xh.learn.website.webProducts.rpc.httpInvoker.service.IHttpInvokerUsrService;

@Configuration
public class HttpInvokerClientConfig {

	@Bean
	public HttpInvokerProxyFactoryBean httpInvokerProxyFactoryBean() {
		HttpInvokerProxyFactoryBean factory = new HttpInvokerProxyFactoryBean();
		factory.setServiceUrl("http://127.0.0.1/http-invoker/usrservice");
		factory.setServiceInterface(IHttpInvokerUsrService.class);
		return factory;
	}

}
