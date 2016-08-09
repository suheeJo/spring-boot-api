package com.shjo.api.param;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class RequestParamModel {
	@NotEmpty
	private String id;
	
	@NotNull
	private int age;
}
