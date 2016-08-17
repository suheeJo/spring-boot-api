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
		
		log.debug("####################### getMethod: " + request.getMethod()); //
		
		// TODO method 잘못 쓰면 여기 안탐
		// 404 에러 나면 /error 형식으로 반환됨..
		
		
		// 1. access_key 입력 안함 - 탐
		// 2. @ModelAttribute 안넣음 - 탐
		// 3. @RequestParam 안넣음 - 탐
		// 4. get을 post로 - 안탐
		// 5. @PathVariable 을 사용하면 - 안탐


		
		
		
		
		// TODO access key 체크 로직

		return true;
	}
}
