package com.sanef.api.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class DigitalServicesDto implements Serializable {

	
	private boolean available;
	
	private String description;
	
	private String type;
}
