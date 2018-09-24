package com.sanef.api.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class AccountOpeningDocumentationDto implements Serializable {

	
	private String type;
	
	private String description;
}
