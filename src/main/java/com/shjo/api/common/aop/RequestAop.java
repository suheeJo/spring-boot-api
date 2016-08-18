package com.shjo.api.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class RequestAop {
	
	@Around("execution(* com.shjo.api.controller.*Controller.*(..))")
	public Object accessKeyCheck(ProceedingJoinPoint joinPoint) throws Throwable {
		log.debug("###################### aop()");
		
		// filter 에서 exception 나는 건 여기 안탐
		// interceptor 탄 이후에 exceptionhandler 간 것도 안탐
		// 여기서 권한 체크를...?
		
		return  joinPoint.proceed();
	}
}