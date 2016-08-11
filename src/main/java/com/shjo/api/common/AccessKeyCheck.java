package com.shjo.api.common;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class AccessKeyCheck {
	
	@Around("execution(* com.shjo.api.controller.*Controller.*(..))")
	public Object accessKeyCheck() throws Exception {
		System.out.println("111111111111111111");
		// SUCCESS 해야지만 들어옴. 아마 Exceptionhandler 밑에 타서 그러는듯 보임
		return null;
	}
}
