package com.xh.learn.testModule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xh.learn.website.webProducts.rpc.httpInvoker.service.IHttpInvokerUsrService;

@RestController
@RequestMapping("/test/http-invoker")
public class TestHttpInvokerController {
	@Autowired
	IHttpInvokerUsrService iHttpInvokerUsrService;

	@RequestMapping("/v1")
	public String test_v1() {
		return iHttpInvokerUsrService.queryUsrs();
	}

	@RequestMapping("/v2")
	public String test_v2(String msg) {
		return iHttpInvokerUsrService.sayHelloToSomeBody(msg);
	}

}
