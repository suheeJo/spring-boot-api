package com.shjo.api.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.shjo.api.model.LogModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RequestFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		log.debug("######### filter doFilter()");
		
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		
		String apiUri = servletRequest.getRequestURI();
		String methodType = servletRequest.getMethod();
		String ip = request.getRemoteAddr();
		String accessKey = servletRequest.getHeader("access_key");

		log.debug("####################### getRequestURI: {}", apiUri);
		log.debug("####################### getMethod: {}", methodType);
		log.debug("####################### getRemoteAddr: {}", ip);
//		log.debug("####################### getRemoteAddr: " + servletRequest.getRemoteAddr()); // 0:0:0:0:0:0:0:1
		log.debug("####################### access_key: {}", accessKey);
		
		
		// TODO 로그 저장
		LogModel logModel = new LogModel(apiUri, methodType, ip, accessKey);
		log.debug("####################### logModel: {}", logModel);
		
		
		// 여기서 exception이 나면 exceptionHandler로 이동함
		chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {}

}
