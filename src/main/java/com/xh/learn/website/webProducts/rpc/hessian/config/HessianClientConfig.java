package com.xh.learn.website.webProducts.rpc.hessian.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

import com.xh.learn.website.webProducts.rpc.hessian.service.IHessianUsrService;

@Configuration
public class HessianClientConfig {

	@Bean
	public HessianProxyFactoryBean hessianProxyFactoryBean() {
		HessianProxyFactoryBean factory = new HessianProxyFactoryBean();
		factory.setServiceUrl("http://127.0.0.1:80/hessian/usrservice");
		factory.setServiceInterface(IHessianUsrService.class);
		return factory;
	}

}
