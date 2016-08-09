package com.shjo.api.model;

import lombok.Data;

@Data
public class ResponseModel {
	private Header header = new Header();
	private Object date = null;
	
	public ResponseModel() {
		header.code = 200;
		header.message = "SUCCESS";
	}

	class Header {
		public Integer code;
		public String message;
	}
}
