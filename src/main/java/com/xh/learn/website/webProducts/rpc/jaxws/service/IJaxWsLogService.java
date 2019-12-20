package com.xh.learn.website.webProducts.rpc.jaxws.service;

import javax.jws.WebService;

import com.xh.learn.website.webProducts.rpc.jaxws.IJaxWs;

@WebService(serviceName = "logService")
public interface IJaxWsLogService extends IJaxWs {

	public String queryLogs();

}
