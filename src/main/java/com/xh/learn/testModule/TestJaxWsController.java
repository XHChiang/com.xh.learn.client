package com.xh.learn.testModule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xh.learn.website.webProducts.rpc.jaxws.service.IJaxWsLogService;
import com.xh.learn.website.webProducts.rpc.jaxws.service.IJaxWsUsrService;

@RestController
@RequestMapping("/test/jax-ws")
public class TestJaxWsController {
	@Autowired
	IJaxWsLogService iJaxWsLogService;

	@Autowired
	IJaxWsUsrService iJaxWsUsrService;

	@RequestMapping("/v1")
	public String test_v1() {
		return iJaxWsUsrService.queryUsrs();
	}

	@RequestMapping("/v2")
	public String test_v2() {
		return iJaxWsLogService.queryLogs();
	}

}
