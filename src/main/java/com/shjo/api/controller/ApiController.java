package com.shjo.api.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.shjo.api.common.ApiStatus;
import com.shjo.api.model.ParamModel;
import com.shjo.api.model.ResponseModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ApiController {
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public @ResponseBody ResponseModel test(
		@RequestHeader String accessKey) throws Exception {
		log.debug("######################## accessKey: {}", accessKey);
		
		ResponseModel response = new ResponseModel();
		
		return response;
	}
	
	@RequestMapping(value="/test2", method=RequestMethod.GET)
	public @ResponseBody ResponseModel test2(
		@RequestHeader String accessKey
		, @Valid @ModelAttribute ParamModel paramModel) throws Exception {
		log.debug("######################## accessKey: {}", accessKey);
		log.debug("######################## paramModel: {}", paramModel);
		
		ResponseModel response = new ResponseModel();
		
		return response;
	}
	
	@RequestMapping(value="/test3", method=RequestMethod.GET)
	public @ResponseBody ResponseModel test3(
		@RequestHeader String accessKey
		, @RequestParam String id) throws Exception {
		log.debug("######################## accessKey: {}", accessKey);
		log.debug("######################## id: {}", id);
		
		ResponseModel response = new ResponseModel();
		
		return response;
	}
	
	/*
	@RequestMapping(value="/test3/{id}", method=RequestMethod.GET)
	public @ResponseBody ResponseModel test3(
		@RequestHeader String accessKey
		, @PathVariable int id) throws Exception {
		log.debug("######################## test3()");
		log.debug("######################## accessKey: {}", accessKey);
		log.debug("######################## id: {}", id);
		
		ResponseModel response = new ResponseModel();
		
		return response;
	}
	*/

	@ResponseStatus(HttpStatus.UNAUTHORIZED) // TODO http status 도 변경 되어야 하는건가?
	@ExceptionHandler(ServletRequestBindingException.class)
	public @ResponseBody ResponseModel unAuthrizedExceptionHandler() throws Exception {
		log.debug("######################## unAuthrizedExceptionHandler()");
		
		ResponseModel response = new ResponseModel();
		
		response.getHeader().setCode(ApiStatus.UNAUTHORIZED.getCode());
		response.getHeader().setMessage(ApiStatus.UNAUTHORIZED.getMessage());
		
		return response;
	}
	

	@ResponseStatus(HttpStatus.BAD_REQUEST) 
	@ExceptionHandler(BindException.class)
	public @ResponseBody ResponseModel badRequestExceptionHandler() throws Exception {
		log.debug("######################## badRequestExceptionHandler()");
		
		ResponseModel response = new ResponseModel();
		
		response.getHeader().setCode(ApiStatus.BAD_REQUEST.getCode());
		response.getHeader().setMessage(ApiStatus.BAD_REQUEST.getMessage());
		
		return response;
	}
	
}
