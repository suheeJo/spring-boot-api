package com.shjo.api.common;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.shjo.api.model.ResponseModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerController {

	@ResponseStatus(HttpStatus.BAD_REQUEST) 
	@ExceptionHandler({BindException.class, MissingServletRequestParameterException.class})
	public @ResponseBody ResponseModel badRequestExceptionHandler() throws Exception {
		log.debug("######################## badRequestExceptionHandler()");
		
		ResponseModel response = new ResponseModel();
		
		response.getHeader().setCode(ApiStatus.BAD_REQUEST.getCode());
		response.getHeader().setMessage(ApiStatus.BAD_REQUEST.getMessage());
		
		return response;
	}

	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(ServletRequestBindingException.class)
	public @ResponseBody ResponseModel unAuthrizedExceptionHandler() throws Exception {
		log.debug("######################## unAuthrizedExceptionHandler()");
		
		ResponseModel response = new ResponseModel();
		
		response.getHeader().setCode(ApiStatus.UNAUTHORIZED.getCode());
		response.getHeader().setMessage(ApiStatus.UNAUTHORIZED.getMessage());
		
		return response;
	}
	
}
