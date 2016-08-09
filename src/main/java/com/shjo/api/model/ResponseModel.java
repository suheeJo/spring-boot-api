package com.shjo.api.model;

import lombok.Data;

@Data
public class ResponseModel {
	private Header header = new Header();
	private Object date = null;
	
	public ResponseModel() {
		header.isSuccessful = true;
		header.code = 200;
		header.message = "SUCCESS";
	}

	class Header {
		public Boolean isSuccessful;
		public Integer code;
		public String message;
	}
}
