package com.shjo.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogModel {
	private String apiUri = null;						// API URI
	private String methodType = null;					// http method 타입
	private String ip = null;							// 요청 IP
	private String accessKey = null;					// 권한 Key
}
