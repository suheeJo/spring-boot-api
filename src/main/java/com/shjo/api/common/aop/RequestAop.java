package com.shjo.api.common.aop;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class RequestAop {
	
	@Autowired
	private HttpServletRequest request;
	
	@Around("execution(* com.shjo.api.controller.*Controller.*(..))")
	public Object accessKeyCheck(ProceedingJoinPoint joinPoint) throws Throwable {
		log.debug("###################### aop()");
		
		String uri = "";
		String ip = "";
		String accessKey = null;

		MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();

		// uri
		Class<?> curClass = methodSignature.getDeclaringType();
		RequestMapping classMappingValue = AnnotationUtils.findAnnotation(curClass, RequestMapping.class);
		if(classMappingValue != null) {
			uri = classMappingValue.value()[0];
		}
		// TODO 예외 추가. PathParameter 같은 경우 체크 할 수 없음.
		
		Method method = methodSignature.getMethod();
		uri = uri + (String)method.getAnnotation(RequestMapping.class).value()[0];
		log.debug("###################### uri1: {}", uri);
		
		// ip
		ip = request.getRemoteAddr();
		log.debug("###################### ip: {}", ip);
		
		
		// access key
		accessKey = request.getHeader("access_key");
		log.debug("###################### accessKey: {}", accessKey);
		
		
		// TODO 권한 확인
		
		
		
		return  joinPoint.proceed();
	}
}