package com.sanef.api.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class BankAgency implements Serializable {

	@NotNull
	private String requestId;

	private String superAgent;
	
	private String agentId;
	
	private String agentName;
	
	private String agentPhone;
	
	private String agentAddress;
	
	private String longitude;
	
	private String latitude;
	
	
}