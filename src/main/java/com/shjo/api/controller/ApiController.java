package com.shjo.api.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shjo.api.model.ResponseModel;
import com.shjo.api.param.RequestParamModel;

@Controller
public class ApiController {
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public @ResponseBody ResponseModel test() throws Exception {
		return new ResponseModel();
	}
	
	@RequestMapping(value="/test2", method=RequestMethod.GET)
	public ResponseEntity<ResponseModel> test2() throws Exception {
		return new ResponseEntity<>(new ResponseModel(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/test3", method=RequestMethod.GET)
	public @ResponseBody ResponseModel test3(
		@Valid @ModelAttribute RequestParamModel param) throws Exception {
		// respone 부분을 반환 되는 ResponseModel로 변경할 순 없는걸까?
		return new ResponseModel(); 
	}
}
