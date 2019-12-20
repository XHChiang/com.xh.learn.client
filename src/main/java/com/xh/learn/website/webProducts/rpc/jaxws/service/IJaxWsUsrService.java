package com.xh.learn.website.webProducts.rpc.jaxws.service;

import javax.jws.WebService;

import com.xh.learn.website.webProducts.rpc.jaxws.IJaxWs;

@WebService(serviceName = "usrService")
public interface IJaxWsUsrService extends IJaxWs {

	public String queryUsrs();

}
