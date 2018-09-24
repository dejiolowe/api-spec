package com.sanef.api.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public abstract class BaseTypedDto implements Serializable{

	
	private String description;
	
	
	private String type;
	
	
	private String value;
	
}
