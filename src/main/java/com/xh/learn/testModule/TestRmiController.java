package com.xh.learn.testModule;

import java.rmi.RemoteException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xh.learn.website.webProducts.rpc.rmi.service.IRmiServiceA;
import com.xh.learn.website.webProducts.rpc.rmi.service.IRmiServiceB;

@RestController
@RequestMapping("/test/rmi")
public class TestRmiController {
	@Autowired
	IRmiServiceA iRmiServiceA;

	@Autowired
	IRmiServiceB iRmiServiceB;

	@RequestMapping("/a_v1")
	public String test_a_v1() throws RemoteException {
		return iRmiServiceA.test_v1();
	}

	@RequestMapping("/a_v2")
	public String test_a_v2(String msg) throws RemoteException {
		return iRmiServiceA.test_v2(msg);
	}

	@RequestMapping("/b_v1")
	public String test_b_v1() throws RemoteException {
		return iRmiServiceB.test_v1();
	}

	@RequestMapping("/b_v2")
	public String test_b_v2(String msg) throws RemoteException {
		return iRmiServiceB.test_v2(msg);
	}
}
