package com.xh.learn.website.webProducts.rpc.jaxws.config;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;

import com.xh.learn.website.webProducts.rpc.jaxws.service.IJaxWsLogService;
import com.xh.learn.website.webProducts.rpc.jaxws.service.IJaxWsUsrService;

@Configuration
public class JaxWsClientConfig {

	@Bean
	public JaxWsPortProxyFactoryBean logService() throws MalformedURLException {
		JaxWsPortProxyFactoryBean proxy = new JaxWsPortProxyFactoryBean();
		proxy.setWsdlDocumentUrl(new URL("http://127.0.0.1:8080/logService?wsdl"));
		proxy.setNamespaceUri("http://service.jaxws.rpc.webProducts.manage.s2h.com/");
		proxy.setServiceInterface(IJaxWsLogService.class);
		proxy.setPortName("IJaxWsLogServicePort");
		proxy.setServiceName("logService");
		return proxy;
	}

	@Bean
	public JaxWsPortProxyFactoryBean usrService() throws MalformedURLException {
		JaxWsPortProxyFactoryBean proxy = new JaxWsPortProxyFactoryBean();
		proxy.setWsdlDocumentUrl(new URL("http://127.0.0.1:8080/usrService?wsdl"));
		proxy.setNamespaceUri("http://service.jaxws.rpc.webProducts.manage.s2h.com/");
		proxy.setServiceInterface(IJaxWsUsrService.class);
		proxy.setPortName("IJaxWsUsrServicePort");
		proxy.setServiceName("usrService");
		return proxy;
	}

	//	@Bean
	//	public IHello jaxWsProxyFactoryBean() throws RemoteException {
	//		JaxWsProxyFactoryBean jaWsProxyFactoryBean = new JaxWsProxyFactoryBean();
	//		jaWsProxyFactoryBean.setAddress("http://127.0.0.1:8088/ihello?wsdl");
	//		jaWsProxyFactoryBean.setServiceClass(IHello.class);
	//
	//		IHello iHello = jaWsProxyFactoryBean.create(IHello.class);
	//		return iHello;
	//	}

	//	public static void main(String[] args) throws Exception {
	//		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
	//		Client client = dcf.createClient("http://127.0.0.1:8088/IHelloImplService?wsdl");
	//		Object[] objects = client.invoke("queryUsrs");
	//
	//		System.out.println(JSON.toJSONString(objects));
	//	}
}
