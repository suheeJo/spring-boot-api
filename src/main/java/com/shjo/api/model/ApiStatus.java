package com.shjo.api.model;

import lombok.Getter;

@Getter
public enum ApiStatus {
	
	OK(200, "OK"),
	
	BAD_REQUEST(400, "Bad Request");
 
    private int code;
    private String desc;
 
    ApiStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
