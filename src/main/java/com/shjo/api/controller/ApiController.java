package com.shjo.api.controller;

import javax.validation.Valid;

import org.mortbay.log.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shjo.api.model.ParamModel;
import com.shjo.api.model.ResponseModel;

@Controller
public class ApiController {
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public @ResponseBody ResponseModel test(
		@RequestHeader String access_key) throws Exception {
		
		ResponseModel response = new ResponseModel();
		
		return response;
	}
	
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public @ResponseBody ResponseModel test2(
		@RequestHeader String access_key
		, @Valid @ModelAttribute ParamModel paramModel) throws Exception {
		
		ResponseModel response = new ResponseModel();
		
		return response;
	}
	
	@RequestMapping(value = "/test3", method = RequestMethod.GET)
	public @ResponseBody ResponseModel test3(
		@RequestHeader String access_key
		, @RequestParam String id) throws Exception {
		
		ResponseModel response = new ResponseModel();
		
		return response;
	}
	
	
	@RequestMapping(value = "/test4/123/1234", method = RequestMethod.POST)
	public @ResponseBody ResponseModel test4(
		@RequestHeader String access_key
		, @RequestBody ParamModel paramModel) throws Exception {
		Log.debug("###### paramModel: {}", paramModel);
		
		ResponseModel response = new ResponseModel();
		
		return response;
	}
	
}
