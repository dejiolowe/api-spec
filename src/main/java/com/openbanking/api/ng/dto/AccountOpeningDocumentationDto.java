package com.openbanking.api.ng.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class AccountOpeningDocumentationDto implements Serializable {

	
	private String type;
	
	private String description;
}
