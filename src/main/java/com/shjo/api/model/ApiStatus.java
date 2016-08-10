package com.shjo.api.model;

import lombok.Getter;

@Getter
public enum ApiStatus {
	
	OK(200, "OK"),
	
	BAD_REQUEST(400, "Bad Request"),
	UNAUTHORIZED(401, "Unauthorized"),
	NOT_FOUND(404, "Not Found"),
	
	INTERNAL_SERVER_ERROR(500, "Internal Server Error");
 
    private int code;
    private String desc;
 
    ApiStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
