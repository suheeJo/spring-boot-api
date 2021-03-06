package com.shjo.api.common;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
	
	// 405
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public @ResponseBody ResponseModel httpRequestMethodNotSupportedExceptionHandler() throws Exception {
		log.debug("######################## httpRequestMethodNotSupportedExceptionHandler()");
		
		ResponseModel response = new ResponseModel();
		
		response.getHeader().setCode(ApiStatus.METHOD_NOT_ALLOWED.getCode());
		response.getHeader().setMessage(ApiStatus.METHOD_NOT_ALLOWED.getMessage());
		
		return response;
	}

	// 415
	@ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE) 
	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public @ResponseBody ResponseModel mediaTypeNotSupportedExceptionHandler() throws Exception {
		log.debug("######################## mediaTypeNotSupportedExceptionHandler()");
		
		ResponseModel response = new ResponseModel();
		
		response.getHeader().setCode(ApiStatus.UNSUPPORTED_MEDIA_TYPE.getCode());
		response.getHeader().setMessage(ApiStatus.UNSUPPORTED_MEDIA_TYPE.getMessage());
		
		return response;
	}

	// 400
	@ResponseStatus(HttpStatus.BAD_REQUEST) 
	@ExceptionHandler({
		BindException.class
		, MissingServletRequestParameterException.class
		, MethodArgumentNotValidException.class})
	public @ResponseBody ResponseModel badRequestExceptionHandler() throws Exception {
		log.debug("######################## badRequestExceptionHandler()");
		
		ResponseModel response = new ResponseModel();
		
		response.getHeader().setCode(ApiStatus.BAD_REQUEST.getCode());
		response.getHeader().setMessage(ApiStatus.BAD_REQUEST.getMessage());
		
		return response;
	}

	// 401
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(ServletRequestBindingException.class)
	public @ResponseBody ResponseModel unAuthrizedExceptionHandler() throws Exception {
		log.debug("######################## unAuthrizedExceptionHandler()");
		
		ResponseModel response = new ResponseModel();
		
		response.getHeader().setCode(ApiStatus.UNAUTHORIZED.getCode());
		response.getHeader().setMessage(ApiStatus.UNAUTHORIZED.getMessage());
		
		return response;
	}

	// 500
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(NullPointerException.class)
	public @ResponseBody ResponseModel nullPointerExceptionHandler() throws Exception {
		log.debug("######################## nullPointerExceptionHandler()");
		
		ResponseModel response = new ResponseModel();
		
		response.getHeader().setCode(ApiStatus.INTERNAL_SERVER_ERROR.getCode());
		response.getHeader().setMessage(ApiStatus.INTERNAL_SERVER_ERROR.getMessage());
		
		return response;
	}
	
}
