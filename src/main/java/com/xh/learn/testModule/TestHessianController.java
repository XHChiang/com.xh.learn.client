package com.xh.learn.testModule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xh.learn.website.webProducts.rpc.hessian.service.IHessianUsrService;

@RestController
@RequestMapping("/test/hessian")
public class TestHessianController {
	@Autowired
	IHessianUsrService iHessianUsrService;

	@RequestMapping("/v1")
	public String test_v1() {
		return iHessianUsrService.queryUsrs();
	}

	@RequestMapping("/v2")
	public String test_v2(String msg) {
		return iHessianUsrService.sayHelloToSomeBody(msg);
	}

}
