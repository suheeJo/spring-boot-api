package com.shjo.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shjo.api.model.ResponseModel;

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
}
