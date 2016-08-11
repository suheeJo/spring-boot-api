package com.shjo.api.model;

import lombok.Data;

@Data
public class ResponseModel {
	private Header header = new Header();
	private Object date = null;
	
	public ResponseModel() {
		header.setCode(200);
		header.setMessage("SUCCESS");
	}

	@Data
	public class Header {
		private Integer code;
		private String message;
	}
}