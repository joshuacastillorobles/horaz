package com.joshua.addressbook.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;

@ApiModel
public class CarrierDto {

	@NotEmpty
	@Size(max = 10)
	private String code;
	
	@NotEmpty
	@Size(max = 45)
	private String name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
