package com.shjo.api.common.aop;

import org.aspectj.lang.annotation.Around;

import lombok.extern.slf4j.Slf4j;

//@Slf4j
public class RequestAop {

	@Around("execution(* com.shjo.api.controller.*Controller.*(..))")
	public Object requestAop() throws Exception {
//		log.debug("#################### aop()");
		
		System.out.println("1111111");
		return null;
	}
}
