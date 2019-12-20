package com.xh.learn.website.webProducts.jmx;

import javax.management.MBeanInfo;
import javax.management.MBeanServerConnection;
import javax.management.ObjectName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jmx")
public class JMXController {
	@Autowired
	IJmx jmsService;

	@Autowired
	MBeanServerConnection mBeanServerConnection;

	@GetMapping("/mbean/info")
	public Object mBeanInfo() throws Exception {
		ObjectName name = new ObjectName("BS-SUPER", "name", "JMXService");
		MBeanInfo mBeanInfo = mBeanServerConnection.getMBeanInfo(name);
		return mBeanInfo.getOperations();
	}

	@GetMapping("/mbean/invoke")
	public Object invoke(String operationName, Integer param, String type) throws Exception {
		ObjectName name = new ObjectName("BS-SUPER", "name", "JMXService");
		Object[] params = new Object[] {};
		if (param != null) {
			params = new Object[] { param };
		}
		String[] types = new String[] {};
		if (type != null) {
			types = new String[] { type };
		}
		return mBeanServerConnection.invoke(name, operationName, params, types);
	}

	@GetMapping("/assignment")
	public Object assignment(Integer flag) {
		return jmsService.assignment(flag);
	}
}
