package com.shjo.api.common;

import lombok.Getter;

@Getter
public enum ApiStatus {
	
	BAD_REQUEST(400, "Bad Request"),
	UNAUTHORIZED(401, "Unauthorized"),
	NOT_FOUND(404, "Not Found"),
	
	INTERNAL_SERVER_ERROR(500, "Internal Server Error");
 
    private int code;
    private String message;
 
    ApiStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
