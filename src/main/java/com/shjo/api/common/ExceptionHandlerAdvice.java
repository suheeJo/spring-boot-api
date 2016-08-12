package com.shjo.api.common;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
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
public class ExceptionHandlerAdvice {
	
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public @ResponseBody ResponseModel httpRequestMethodNotSupportedExceptionHandler() throws Exception {
		log.debug("######################## httpRequestMethodNotSupportedExceptionHandler()");
		
		ResponseModel response = new ResponseModel();
		
		response.getHeader().setCode(ApiStatus.METHOD_NOT_ALLOWED.getCode());
		response.getHeader().setMessage(ApiStatus.METHOD_NOT_ALLOWED.getMessage());
		
		return response;
	}

	@ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE) 
	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public @ResponseBody ResponseModel mediaTypeNotSupportedExceptionHandler() throws Exception {
		log.debug("######################## mediaTypeNotSupportedExceptionHandler()");
		
		ResponseModel response = new ResponseModel();
		
		response.getHeader().setCode(ApiStatus.UNSUPPORTED_MEDIA_TYPE.getCode());
		response.getHeader().setMessage(ApiStatus.UNSUPPORTED_MEDIA_TYPE.getMessage());
		
		return response;
	}

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
