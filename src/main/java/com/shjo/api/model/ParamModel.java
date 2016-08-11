package com.shjo.api.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class ParamModel {

	@NotEmpty
	private String id;
	
	@NotNull
	private Integer age;
}
