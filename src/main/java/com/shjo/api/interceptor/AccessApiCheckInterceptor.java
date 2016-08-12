package com.shjo.api.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AccessApiCheckInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		log.debug("####################### access key check interceptor");
		
		log.debug("####################### access_key: " + request.getHeader("access_key"));
		
		log.debug("####################### getRemoteAddr: " + request.getRemoteAddr()); // 0:0:0:0:0:0:0:1
		
		log.debug("####################### getServletPath: " + request.getServletPath()); //
		log.debug("####################### getRequestURI: " + request.getRequestURI()); // /test
		
		log.debug("####################### getQueryString: " + request.getQueryString()); //
		
		log.debug("####################### getMethod: " + request.getMethod()); //


		// TODO access key 체크 로직

		return true;
	}
}
