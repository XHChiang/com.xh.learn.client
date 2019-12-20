package com.xh.learn.testModule;

import java.rmi.RemoteException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xh.learn.website.webProducts.mq.active.rpcJms.service.DemoJmsService;

@RestController
@RequestMapping("/test/jms")
public class TestJmsController {
	@Autowired
	DemoJmsService demoJmsService;

	@RequestMapping("/v1")
	public String test_v1() throws RemoteException {
		return demoJmsService.queryUsrs();
	}
}
